package pl.pjatk.blog.model;

import java.util.Date;

public class Comment {

    private Long idComment;
    private Author authorComment;
    private String bodyComment;
    private String categoryComment;
    private Date timeComment;
    private Post post;


}
