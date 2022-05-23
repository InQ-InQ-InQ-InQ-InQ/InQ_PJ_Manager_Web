package team.projectmanager.domain.project.projectrepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.ProjectStatus;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectRepositoryImp implements ProjectRepository{

    private final EntityManager em;


    @Override
    public Long save(Project project) {
        em.persist(project);
        return project.getId();
    }

    @Override
    public Project findById(Long id) {
        String query = "select distinct p from Project p " +
                "left join fetch p.memberProjects mp " +
                "join fetch mp.member " +
                "where p.id = :id";
        List<Project> resultList = em.createQuery(query, Project.class)
                .setParameter("id", id)
                .getResultList();

        if (resultList.isEmpty()) return null;
        return resultList.get(0);
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

    @Override
    public Project findByIdLazy(Long id) {
        return em.find(Project.class, id);
    }

    @Override
    public List<Project> findByStatus(ProjectStatus status) {
        String query = "select distinct p from Project p " +
                "join fetch p.memberProjects " +
                "where p.status = :status";
        return em.createQuery(query, Project.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<Project> findBySearch(ProjectSearch search) {
        if ((search.getName() == null && search.getStatus() == null) || (search.getName().isEmpty() && search.getStatus() == null)) {
            String query = "select p from Project p " +
                    "join fetch p.memberProjects";
            return em.createQuery(query, Project.class)
                    .getResultList();
        } else if (search.getName().isEmpty()) {
            String query = "select p from Project p " +
                    "join fetch p.memberProjects " +
                    "where p.status = :status";
            return em.createQuery(query, Project.class)
                    .setParameter("status", search.getStatus())
                    .getResultList();
        } else if (search.getStatus() == null) {
            String query = "select p from Project p " +
                    "join fetch p.memberProjects " +
                    "where p.name = :name";
            return em.createQuery(query, Project.class)
                    .setParameter("name", search.getName())
                    .getResultList();
        } else {
            String query = "select p from Project p " +
                    "join fetch p.memberProjects " +
                    "where p.name = :name " +
                    "and p.status = :status";
            return em.createQuery(query, Project.class)
                    .setParameter("name", search.getName())
                    .setParameter("status", search.getStatus())
                    .getResultList();
        }
    }
}
