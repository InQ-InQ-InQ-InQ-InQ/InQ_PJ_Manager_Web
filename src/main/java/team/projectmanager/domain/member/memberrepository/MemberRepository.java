package team.projectmanager.domain.member.memberrepository;

import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.MemberUpdateDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Long save(Member member);

    Member findById(Long id);

    Member findByLoginId(String loginId);

    Member findByName(String name);

    List<Member> findAll();
}
