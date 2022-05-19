package team.projectmanager.web.project;

import lombok.Data;
import team.projectmanager.domain.position.Position;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjectForm {

    private String name;

    private LocalDate period;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<Position> positions;

    private String introduction;
}
