package pl.pjatk.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPost;

//    @Column(name = "author_post")

    @OneToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JsonIgnore
    private Author authorPost;

    private String bodyPost;

    private String categoryPost;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timePost;

//    private List<Comment> commentsList;

    public Post() {

    }

    public Post(Author authorPost, String bodyPost, String categoryPost) {
        this.authorPost = authorPost;
        this.bodyPost = bodyPost;
        this.categoryPost = categoryPost;
//        this.commentsList = commentsList;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Author getAuthorPost() {
        return authorPost;
    }

    public void setAuthorPost(Author authorPost) {
        this.authorPost = authorPost;
    }

    public String getBodyPost() {
        return bodyPost;
    }

    public void setBodyPost(String bodyPost) {
        this.bodyPost = bodyPost;
    }

    public String getCategoryPost() {
        return categoryPost;
    }

    public void setCategoryPost(String categoryPost) {
        this.categoryPost = categoryPost;
    }

    public LocalDateTime getTimePost() {
        return timePost;
    }

    public void setTimePost(LocalDateTime timePost) {
        this.timePost = timePost;
    }

//    public List<Comment> getCommentsList() {
//        return commentsList;
//    }
//
//    public void setCommentsList(List<Comment> commentsList) {
//        this.commentsList = commentsList;
//    }
}
