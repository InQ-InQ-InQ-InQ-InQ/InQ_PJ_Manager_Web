package team.projectmanager.domain.member.memberservice;

import team.projectmanager.domain.member.Member;

public interface MemberService {
    void join(Member member);

    Member findById(Long id);
}
