package team.projectmanager.domain.memberproject.mprepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.projectmanager.domain.memberproject.MemberProject;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DbMemberProjectRepository implements MemberProjectRepository{

    private final EntityManager em;

    @Override
    public Long save(MemberProject memberProject) {
        em.persist(memberProject);
        return memberProject.getId();
    }


}
