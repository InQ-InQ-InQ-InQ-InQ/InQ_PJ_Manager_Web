package team.projectmanager.domain.memberproject.mprepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.projectmanager.domain.memberproject.MemberProject;
import team.projectmanager.domain.project.ProjectStatus;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberProjectRepositoryImp implements MemberProjectRepository{

    private final EntityManager em;

    @Override
    public Long save(MemberProject memberProject) {
        em.persist(memberProject);
        return memberProject.getId();
    }

    @Override
    public void remove(MemberProject memberProject) {
        em.remove(memberProject);
    }

    @Override
    public MemberProject findMP(Long id) {
        return em.find(MemberProject.class, id);
    }

    @Override
    public MemberProject findMPByStatus(Long memberId, ProjectStatus status) {
        String query = "select mp from MemberProject mp " +
                "join fetch mp.member m " +
                "join fetch mp.project p " +
                "where m.id = :memberId " +
                "and p.status = :status";
        List<MemberProject> resultList = em.createQuery(query, MemberProject.class)
                .setParameter("memberId", memberId)
                .setParameter("status", status)
                .setMaxResults(0)
                .getResultList();
        if (resultList.isEmpty()) return null;
        else return resultList.get(0);
    }
}
