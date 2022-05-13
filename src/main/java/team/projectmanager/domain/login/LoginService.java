package team.projectmanager.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.memberrepository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String pw) {

        Optional<Member> optional = memberRepository.findByLoginId(loginId);

        return optional.filter(m -> m.getPw().equals(pw))
                .orElse(null);
    }
}
