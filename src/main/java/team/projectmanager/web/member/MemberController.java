package team.projectmanager.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.memberservice.MemberService;
import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.skill.Skills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @ModelAttribute("skillList")
    public List<Skills> skillsList() {
        return Arrays.asList(Skills.values());
    }

    @ModelAttribute("positionList")
    public List<Position> positionList() {
        return Arrays.asList(Position.values());
    }

    @GetMapping("join")
    public String signupForm(@ModelAttribute("memberForm") MemberForm memberForm) {

        return "member/signup";
    }

    @PostMapping("join")
    public String signup(@Validated @ModelAttribute MemberForm memberForm,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/signup";
        }

        if (!memberForm.getPw().equals(memberForm.getCheckPw())) {
            bindingResult.reject("NotEqualPw", "비밀번호가 일치하지 않습니다.");
            return "member/signup";
        }

        Member member = Member.createMember(memberForm.getName(), memberForm.getLoginId(), memberForm.getPw(), memberForm.getPosition(),
                memberForm.getEmail(), memberForm.getGitAddress(), memberForm.getIntro(), memberForm.getSkills());

        memberService.join(member);

        return "redirect:/login";
    }
}
