package team.projectmanager.web.memberproject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import team.projectmanager.LoginConst;
import team.projectmanager.domain.memberproject.mprservice.MemberProjectService;

@Controller
@RequiredArgsConstructor
public class MemberProjectController {

    private final MemberProjectService mps;

    @PostMapping("/memberproject/join")
    public String newMemberProject(@SessionAttribute(value = LoginConst.LOGIN_MEMBER, required = false) Long memberId,
                                   @RequestParam Long projectId) {

        mps.newMemberProject(memberId, projectId);

        return "redirect:/projects/" + projectId;
    }
}
