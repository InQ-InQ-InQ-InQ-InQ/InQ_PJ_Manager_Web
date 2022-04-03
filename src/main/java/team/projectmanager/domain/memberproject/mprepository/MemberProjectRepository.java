package team.projectmanager.domain.memberproject.mprepository;

import team.projectmanager.domain.memberproject.MemberProject;

public interface MemberProjectRepository {

    Long save(MemberProject memberProject);

    void remove(MemberProject memberProject);

    MemberProject find(Long id);
}
