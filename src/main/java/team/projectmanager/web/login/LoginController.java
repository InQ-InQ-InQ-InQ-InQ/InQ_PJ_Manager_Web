package team.projectmanager.web.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import team.projectmanager.LoginConst;
import team.projectmanager.domain.login.LoginService;
import team.projectmanager.domain.member.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {

        return "login/loginForm";
    }

    @PostMapping("/login")
    public String loginForm(@Validated @ModelAttribute LoginForm loginForm,
                            BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPw());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 혹은 비밀번호가 틀립니다.");
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(LoginConst.LOGIN_MEMBER, loginMember.getId());

        return "redirect:/";
    }
}
