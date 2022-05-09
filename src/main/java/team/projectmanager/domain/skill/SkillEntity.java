package team.projectmanager.domain.skill;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter @EqualsAndHashCode
public class SkillEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;

    @Column(name = "skill_name")
    @Enumerated(EnumType.STRING)
    private Skills skill;

    public SkillEntity(Skills skill) {
        this.skill = skill;
    }

    protected SkillEntity() {
    }
}
