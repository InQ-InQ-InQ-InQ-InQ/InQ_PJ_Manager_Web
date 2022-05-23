package team.projectmanager.domain.project.projectservice;

import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.ProjectStatus;

import java.time.LocalDate;
import java.util.List;

public interface ProjectService {
    Long newProject(Long memberId, String name, LocalDate period, LocalDate startDate, LocalDate endDate, String introduction, List<Position> positions);

    Project findProjectById(Long projectId);

    void editProjectStatus(Long projectId, ProjectStatus status);
}
