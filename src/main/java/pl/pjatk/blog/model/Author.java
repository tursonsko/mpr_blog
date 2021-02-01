package pl.pjatk.blog.model;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_author")
    private Long idAuthor;


    private String nameAuthor;

    private String emailAuthor;

    public Author() {

    }

    public Author(String nameAuthor, String emailAuthor) {
        this.nameAuthor = nameAuthor;
        this.emailAuthor = emailAuthor;
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
}
