package team.projectmanager.domain.position;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter @EqualsAndHashCode
public class PositionEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Position position;

    public PositionEntity(Position position) {
        this.position = position;
    }

    protected PositionEntity() {
    }
}
