package team.projectmanager.domain.project.projectservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.memberservice.MemberService;
import team.projectmanager.domain.memberproject.MemberProject;
import team.projectmanager.domain.memberproject.mprepository.MemberProjectRepository;
import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.ProjectStatus;
import team.projectmanager.domain.project.projectrepository.ProjectRepository;
import team.projectmanager.domain.project.projectrepository.ProjectSearch;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository pr;
    private final MemberService ms;
    private final MemberProjectRepository mpr;

    @Transactional
    public Long newProject(Long memberId, String name, LocalDate period, LocalDate startDate, LocalDate endDate, String introduction, List<Position> positions) {

        Project project = Project.createProject(memberId, name, period, startDate, endDate, introduction, positions);
        pr.save(project);

        Member member = ms.findById(memberId);
        MemberProject memberProject = MemberProject.createMemberProject(member, project);
        mpr.save(memberProject);

        return project.getId();
    }

    public Project findProjectById(Long projectId) {
        return pr.findById(projectId);
    }

    @Transactional
    public void editProjectStatus(Long projectId, ProjectStatus status) {
        Project project = pr.findByIdLazy(projectId);
        project.setStatus(status);
    }

    public List<Project> findByStatus(ProjectStatus status) {
        return pr.findByStatus(status);
    }

    public List<Project> findBySearch(ProjectSearch search) {
        return pr.findBySearch(search);
    }
}
