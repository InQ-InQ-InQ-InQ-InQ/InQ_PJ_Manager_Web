package team.projectmanager.domain.project.projectrepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.projectmanager.domain.project.Project;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DbProjectRepository implements ProjectRepository{

    private final EntityManager em;


    @Override
    public Long save(Project project) {
        em.persist(project);
        return project.getId();
    }

    @Override
    public Project findById(Long id) {
        String query = "select p from Project p where p.id = :projectId";
        List<Project> resultList = em.createQuery(query, Project.class)
                .setParameter("projectId", id)
                .getResultList();
        if (resultList.isEmpty()) return null;
        else return resultList.get(0);
    }

    @Override
    public Project findByName(String name) {
        String query = "select p from Project p where p.name = :projectName";
        List<Project> resultList = em.createQuery(query, Project.class)
                .setParameter("projectName", name)
                .getResultList();
        if (resultList.isEmpty()) return null;
        else return resultList.get(0);
    }

    @Override
    public List<Project> findAll() {
        String query = "select p from Project p";
        return em.createQuery(query, Project.class)
                .getResultList();
    }
}
