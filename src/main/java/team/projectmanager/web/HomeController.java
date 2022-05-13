package team.projectmanager.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import team.projectmanager.LoginConst;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name = LoginConst.LOGIN_MEMBER, required = false) Long memberId) {

        if (memberId == null) {
            return "redirect:/login";
        }

        return "home";
    }
}
