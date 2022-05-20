package team.projectmanager.domain.skill;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.memberrepository.MemberRepository;
import team.projectmanager.domain.memberproject.mprepository.MemberProjectRepository;
import team.projectmanager.domain.project.projectrepository.ProjectRepository;
import team.projectmanager.domain.project.projectservice.ProjectService;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class skillTest {

    @Autowired
    private MemberRepository mr;
    @Autowired
    private ProjectService ps;
    @Autowired
    ProjectRepository pr;
    @Autowired
    MemberProjectRepository mpr;

    @Test
    void findByIdTest() {
        //given
        Member member = new Member();
        member.setIntro("hello");
        mr.save(member);
        //when
        Member findMember = mr.findById(member.getId());
        System.out.println(member.getId());
        //then
        assertThat(true).isEqualTo(findMember == null);
    }

    @Test
    void newProjectTest() {
        //given
        Member member = new Member();
        member.setIntro("hello");
        mr.save(member);
        //when
        ps.newProject(member.getId(), "projectA", LocalDate.now(), LocalDate.now(), LocalDate.now(), "hello", null);
        //then
        assertThat(1).isEqualTo(mpr.findAll().size());
        assertThat(1).isEqualTo(pr.findAll().size());
    }
}
