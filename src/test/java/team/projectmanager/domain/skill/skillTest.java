package team.projectmanager.domain.skill;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.skills.SkillEntity;
import team.projectmanager.domain.skills.Skills;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class skillTest {

    @Autowired
    EntityManager em;

    @Test
    void memberSKillTest() {
        Member member = new Member();
        member.setName("hello");
        em.persist(member);

        SkillEntity skill = new SkillEntity(Skills.SPRING);

        member.getSkills().add(skill);
        em.flush();
        em.clear();
        Member findMember = em.find(Member.class, member.getId());
        findMember.getSkills().removeIf(s -> s.getId().equals(skill.getId()));
        em.flush();
    }
}
