package team.projectmanager.web.project;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import team.projectmanager.domain.position.Position;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjectForm {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate period;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private List<Position> positions;

    private String introduction;
}
