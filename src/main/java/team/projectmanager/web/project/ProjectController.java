package team.projectmanager.web.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import team.projectmanager.LoginConst;
import team.projectmanager.domain.project.projectservice.ProjectService;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService ps;

    @GetMapping("/projects/new")
    public String projectForm(@ModelAttribute("projectForm") ProjectForm projectForm) {

        return "/project/project_posting";
    }

    @PostMapping("/projects/new")
    public String newProject(@Validated @ModelAttribute ProjectForm projectForm,
                             BindingResult bindingResult,
                             @SessionAttribute(name = LoginConst.LOGIN_MEMBER, required = false) Long memberId) {
        if (bindingResult.hasErrors()) {
            return "/project/project_posting";
        }

        ps.newProject(memberId, projectForm.getName(), projectForm.getPeriod(), projectForm.getStartDate(),
                projectForm.getEndDate(), projectForm.getIntroduction(), projectForm.getPositions());

        return "redirect:/";
    }
}
