package com.sparta.outsourcing.comment.dto;

import com.sparta.outsourcing.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDTO {
    private Long id;
    private String comment;
    private String generatedname;
    private Long boardId;
    private Long userId;

    public CommentResponseDTO(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.generatedname = comment.getGeneratedname();
        this.boardId = comment.getBoard().getId();
        this.userId = comment.getUser().getId();
    }
}
