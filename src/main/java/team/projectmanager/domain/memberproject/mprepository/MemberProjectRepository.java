package team.projectmanager.domain.memberproject.mprepository;

import team.projectmanager.domain.memberproject.MemberProject;
import team.projectmanager.domain.project.ProjectStatus;

public interface MemberProjectRepository {

    Long save(MemberProject memberProject);

    void remove(MemberProject memberProject);

    MemberProject findMP(Long id);

    MemberProject findMPByStatus(Long memberId, ProjectStatus status);
}
