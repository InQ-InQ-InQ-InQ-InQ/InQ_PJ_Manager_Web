package team.projectmanager.web.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.projectmanager.LoginConst;
import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.projectservice.ProjectService;
import team.projectmanager.domain.skill.Skills;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService ps;

    @ModelAttribute("positionList")
    public List<Position> positionList() {
        return Arrays.asList(Position.values());
    }

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

    @GetMapping("/projects/{projectId}")
    public String projectInfo(@PathVariable Long projectId, Model model) {

        Project project = ps.findProjectById(projectId);

        model.addAttribute("project", project);

        return "/project/project_info";
    }
}
