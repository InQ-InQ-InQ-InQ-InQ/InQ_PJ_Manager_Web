package team.projectmanager.domain.memberskill;

import lombok.Getter;
import lombok.Setter;
import team.projectmanager.domain.member.Member;
import team.projectmanager.domain.skill.Skill;

import javax.persistence.*;

@Entity
@Getter @Setter
public class MemberSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_skill_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
