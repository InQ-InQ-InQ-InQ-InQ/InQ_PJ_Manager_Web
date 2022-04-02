package team.projectmanager.domain.memberproject;

import lombok.Getter;
import lombok.Setter;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.project.Project;

import javax.persistence.*;

@Entity
@Getter @Setter
public class MemberProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    //멤버와 프로젝트의 연관관계는 모두 여기서 설정
    public static MemberProject createMemberProject(Member member, Project project) {
        MemberProject memberProject = new MemberProject();
        memberProject.setMember(member);
        memberProject.setProject(project);
        member.getMemberProjects().add(memberProject);
        project.getMemberProjects().add(memberProject);

        return memberProject;
    }
}
