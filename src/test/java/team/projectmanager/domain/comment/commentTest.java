package team.projectmanager.domain.comment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.projectmanager.domain.comment.commentrepository.CommentRepository;
import team.projectmanager.domain.project.Project;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class commentTest {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    EntityManager em;

    @Test
    void createCommentAndRemoveTest() {
        Project project = new Project();
        project.setName("hello");
        em.persist(project);

        Comment comment = new Comment("good");

        project.addComment(comment);

        em.flush();
        em.clear();

        Project findProject = em.find(Project.class, project.getId());
        findProject.getComments().removeIf(c -> c.getId().equals(comment.getId()));
        System.out.println(findProject.getComments().size());
        em.flush();
    }
}
