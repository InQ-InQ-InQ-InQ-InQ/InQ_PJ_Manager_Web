package team.projectmanager.domain.member;

import lombok.Getter;
import lombok.Setter;
import team.projectmanager.domain.memberproject.MemberProject;
import team.projectmanager.domain.memberskill.MemberSkill;

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

    @OneToMany(mappedBy = "member")
    private List<MemberSkill> memberSkills = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProject> memberProjects =  new ArrayList<>();
}
