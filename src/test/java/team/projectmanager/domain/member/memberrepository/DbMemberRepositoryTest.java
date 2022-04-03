package team.projectmanager.domain.member.memberrepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.projectmanager.domain.member.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class DbMemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    void createMemberAndFind() {
        //given
        Member member = new Member();
        member.setName("memberA");
        member.setLoginId("hello");
        //when
        Long id = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(id);
        Member findMember2 = memberRepository.findByLoginId("hello2");
        Member findMember3 = memberRepository.findByName("memberA");
        assertThat(findMember).isEqualTo(member);
        assertThat(findMember2).isEqualTo(null);
        assertThat(findMember3).isEqualTo(member);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("memberA");
        member1.setLoginId("helloA");
        Member member2 = new Member();
        member2.setName("memberB");
        member2.setLoginId("helloB");
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> members = memberRepository.findAll();
        //then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member1, member2);
    }
}