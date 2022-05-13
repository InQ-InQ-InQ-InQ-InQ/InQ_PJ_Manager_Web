package team.projectmanager.web.login.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import team.projectmanager.LoginConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(LoginConst.LOGIN_MEMBER) == null) {
            log.info("비회원 접근");
            response.sendRedirect("/?redirectURI=" + requestURI);
            return false;
        }
        return true;
    }
}
