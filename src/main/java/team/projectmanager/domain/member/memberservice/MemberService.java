package team.projectmanager.domain.member.memberservice;

import team.projectmanager.domain.member.Member;

import java.util.List;

public interface MemberService {
    void join(Member member);

    Member findById(Long id);

    List<Member> findMembers();
}
