package team.projectmanager.domain.skills;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SkillEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;

    @Column(name = "skill_name")
    @Enumerated
    private Skills name;

    public SkillEntity(Skills name) {
        this.name = name;
    }

    protected SkillEntity() {
    }
}
