package pl.pjatk.blog.model;

import java.time.LocalDateTime;

public class Comment {
    private Long idComment;
    private Author authorComment;
    private String bodyComment;
    private String categoryComment;
    private LocalDateTime timeComment;
    private Post post;
}
