package pl.pjatk.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
//import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author authorPost;
    private String bodyPost;
    private String categoryPost;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timePost;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> commentsList = new ArrayList<>();

    public Post() {

    }

    public Post(String bodyPost, String categoryPost, List<Comment> commentsList) {
        this.bodyPost = bodyPost;
        this.categoryPost = categoryPost;
        this.commentsList = commentsList;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    @JsonBackReference
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

    public Date getTimePost() {
        return timePost;
    }

    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    @JsonManagedReference
    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }
}
