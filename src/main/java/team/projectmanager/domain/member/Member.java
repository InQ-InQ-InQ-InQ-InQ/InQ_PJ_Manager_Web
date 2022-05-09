package team.projectmanager.domain.member;

import lombok.Getter;
import lombok.Setter;
import team.projectmanager.domain.memberproject.MemberProject;
import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.skill.SkillEntity;;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String loginId;

    private String pw;

    @Column(name = "member_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Position position;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<SkillEntity> skills = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProject> memberProjects =  new ArrayList<>();

    public void addSkill(SkillEntity skill) {
        skills.add(skill);
    }

    public void removeSkill(SkillEntity skill) {
        skills.removeIf(s -> s.getId().equals(skill.getId()));
    }

    public void removeMP(MemberProject memberProject) {
        getMemberProjects().removeIf(mp -> mp.getId().equals(memberProject.getId()));
    }
}
