package team.projectmanager.web.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.skill.Skills;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class MemberForm {

    private String name;

    private String loginId;

    private String pw;

    private String checkPw;

    @Email
    private String email;

    private Position position;

    private List<Skills> skills;

    private String gitAddress;

    private String intro;
}
