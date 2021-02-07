package pl.pjatk.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.blog.model.Comment;

import java.util.Date;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT count(c) FROM Comment c WHERE c.timeComment > :currentDateMinusOne")
     Long getCommentsYoungerThanOneMinute(Date currentDateMinusOne);
}