package pl.pjatk.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuthor;
    private String nameAuthor;
    private String emailAuthor;
    @OneToMany(cascade= CascadeType.ALL, mappedBy = "authorPost", fetch = FetchType.LAZY)
//    @JsonIgnore
    private List<Post> postsList;


    public Author() {

    }

    public Author(String nameAuthor, String emailAuthor, List<Post> postsList) {
        this.nameAuthor = nameAuthor;
        this.emailAuthor = emailAuthor;
        this.postsList = postsList;
    }



    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getEmailAuthor() {
        return emailAuthor;
    }

    public void setEmailAuthor(String emailAuthor) {
        this.emailAuthor = emailAuthor;
    }

//    @JsonManagedReference
    public List<Post> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Post> postsList) {
        this.postsList = postsList;
    }
}
