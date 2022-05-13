package team.projectmanager.web.login;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data @AllArgsConstructor
public class LoginForm {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String pw;
}
