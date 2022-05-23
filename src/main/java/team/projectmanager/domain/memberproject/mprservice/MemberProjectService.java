package team.projectmanager.domain.memberproject.mprservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.member.memberrepository.MemberRepository;
import team.projectmanager.domain.memberproject.MemberProject;
import team.projectmanager.domain.memberproject.mprepository.MemberProjectRepository;
import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.projectrepository.ProjectRepository;

@Service
@RequiredArgsConstructor
public class MemberProjectService {

    private final MemberProjectRepository mpr;
    private final MemberRepository mr;
    private final ProjectRepository pr;

    @Transactional
    public void newMemberProject(Long memberId, Long projectId) {

        Member member = mr.findById(memberId);
        Project project = pr.findById(projectId);

        MemberProject memberProject = MemberProject.createMemberProject(member, project);

        mpr.save(memberProject);
    }
}
