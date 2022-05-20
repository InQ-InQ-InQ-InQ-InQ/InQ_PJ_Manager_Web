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
import team.projectmanager.domain.project.projectrepository.ProjectRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository pr;
    private final MemberService ms;
    private final MemberProjectRepository mpr;

    @Transactional
    public void newProject(Long memberId, String name, LocalDate period, LocalDate startDate, LocalDate endDate, String introduction, List<Position> positions) {

        Project project = Project.createProject(memberId, name, period, startDate, endDate, introduction, positions);
        pr.save(project);

        Member member = ms.findById(memberId);
        MemberProject memberProject = MemberProject.createMemberProject(member, project);
        mpr.save(memberProject);
    }
}
