package com.sparta.outsourcing.comment.entity;

import com.sparta.outsourcing.board.entity.Board;
import com.sparta.outsourcing.comment.dto.CommentRequestDTO;
import com.sparta.outsourcing.common.AnonymousNameGenerator;
import com.sparta.outsourcing.common.Timestamped;
import com.sparta.outsourcing.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "공백이거나 null인 것은 불가합니다.")
    @Column(name = "comment", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String generatedname;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "likes")
    private Long like;

    public Comment(Board board, CommentRequestDTO commentRequestDTO, User user){
        this.board = board;
        this.comment = commentRequestDTO.getComment();
        this.generatedname = AnonymousNameGenerator.nameGenerate();
        this.user = user;
        this.like = 0L;
    }

    public void updateComment(CommentRequestDTO requestDTO) {
        this.comment = requestDTO.getComment();
    }

    public void decreaseLike() {
        this.like--;
    }

    public void increaseLike() {
        this.like++;
    }
}
