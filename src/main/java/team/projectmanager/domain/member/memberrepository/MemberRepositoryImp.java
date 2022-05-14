package team.projectmanager.domain.member.memberrepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.projectmanager.domain.member.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImp implements MemberRepository{

    private final EntityManager em;

    @Override
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    @Override
    public Member findById(Long id) {
        String query = "select m from Member m join fetch m.skills where m.id = :id";
        List<Member> resultList = em.createQuery(query, Member.class)
                .setParameter("id", id)
                .getResultList();
        if (resultList.isEmpty()) return null;
        else return resultList.get(0);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        String query = "select m from Member m where m.loginId = :loginId";
        List<Member> resultList = em.createQuery(query, Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
        if (resultList.isEmpty()) return Optional.empty();
        else return Optional.ofNullable(resultList.get(0));
    }

    @Override
    public Member findByName(String name) {
        String query = "select m from Member m where m.name = :name";
        List<Member> resultList = em.createQuery(query, Member.class)
                .setParameter("name", name)
                .getResultList();
        if (resultList.isEmpty()) return null;
        else return resultList.get(0);
    }

    @Override
    public List<Member> findAll() {
        String query = "select m from Member m";
        return em.createQuery(query, Member.class)
                .getResultList();
    }
}
