package pl.pjatk.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;


    private String authorComment;

    private String bodyComment;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeComment;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;

    public Comment() {
        this.timeComment = new Date();
    }

    public Comment(String authorComment, String bodyComment) {
        this.authorComment = authorComment;
        this.bodyComment = bodyComment;
        this.timeComment = new Date();
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public String getAuthorComment() {
        return authorComment;
    }

    public void setAuthorComment(String authorComment) {
        this.authorComment = authorComment;
    }

    public String getBodyComment() {
        return bodyComment;
    }

    public void setBodyComment(String bodyComment) {
        this.bodyComment = bodyComment;
    }

    public Date getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(Date timeComment) {
        this.timeComment = timeComment;
    }

    @JsonBackReference
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date subtractMin() {
        return new Date();
    }
}
