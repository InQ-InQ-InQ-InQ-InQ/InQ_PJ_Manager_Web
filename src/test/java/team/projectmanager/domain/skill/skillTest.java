package team.projectmanager.domain.skill;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.memberrepository.MemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class skillTest {

    @Autowired private MemberRepository memberRepository;

    @Test
    void findByIdTest() {
        //given
        Member member = new Member();
        member.setIntro("hello");
        memberRepository.save(member);
        //when
        Member findMember = memberRepository.findById(member.getId());
        System.out.println(member.getId());
        //then
        assertThat(true).isEqualTo(findMember == null);
    }
}
