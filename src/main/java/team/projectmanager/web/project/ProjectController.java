package team.projectmanager.web.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.projectmanager.LoginConst;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.memberrepository.MemberRepository;
import team.projectmanager.domain.member.memberservice.MemberService;
import team.projectmanager.domain.memberproject.MemberProject;
import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.ProjectStatus;
import team.projectmanager.domain.project.projectrepository.ProjectSearch;
import team.projectmanager.domain.project.projectservice.ProjectService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService ps;
    private final MemberRepository mr;

    @ModelAttribute("positionList")
    public List<Position> positionList() {
        return Arrays.asList(Position.values());
    }

    @ModelAttribute("statusList")
    public List<ProjectStatus> statusList() {
        return Arrays.asList(ProjectStatus.values());
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

        Long projectId = ps.newProject(memberId, projectForm.getName(), projectForm.getPeriod(), projectForm.getStartDate(),
                projectForm.getEndDate(), projectForm.getIntroduction(), projectForm.getPositions());

        return "redirect:/projects/" + projectId;
    }

    @GetMapping("/projects/{projectId}")
    public String projectInfo(@PathVariable Long projectId, Model model,
                              @SessionAttribute(value = LoginConst.LOGIN_MEMBER, required = false) Long memberId) {

        Project project = ps.findProjectById(projectId);

        boolean isJoin = getIsJoin(memberId, project);

        Member admin = mr.findByIdLazy(project.getAdminId());

        boolean isAdmin = admin.getId().equals(memberId);

        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("isJoin", isJoin);
        model.addAttribute("admin", admin);
        model.addAttribute("project", project);

        return "/project/project_info";
    }

    @PostMapping("/projects/edit/status")
    public String editProjectStatus(@RequestParam Long projectId,
                                    @RequestParam ProjectStatus projectStatus) {

        ps.editProjectStatus(projectId, projectStatus);

        return "redirect:/projects/" + projectId;
    }

    @GetMapping("/projects")
    public String projectList(@ModelAttribute("search") ProjectSearch search,
                              Model model) {

        List<Project> projects = ps.findBySearch(search);

        model.addAttribute("projects", projects);

        return "/project/project_home";
    }

    private boolean getIsJoin(Long memberId, Project project) {

        for (MemberProject memberProject : project.getMemberProjects()) {
            if (memberProject.getMember().getId().equals(memberId)) {
                return true;
            }
        }
        return false;
    }


}
