package team.projectmanager.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import team.projectmanager.LoginConst;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.memberservice.MemberService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home(@SessionAttribute(name = LoginConst.LOGIN_MEMBER, required = false) Long memberId,
                       Model model) {

        if (memberId == null) {
            return "redirect:/login";
        }

        Member member = memberService.findById(memberId);

        model.addAttribute("member", member);

        return "home";
    }
}
