package team.projectmanager.domain.project.projectrepository;

import lombok.Data;
import team.projectmanager.domain.project.ProjectStatus;

@Data
public class ProjectSearch {

    private String name;

    private ProjectStatus status;
}
