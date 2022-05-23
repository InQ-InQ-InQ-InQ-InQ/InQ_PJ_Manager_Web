package team.projectmanager.domain.project.projectservice;

import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.ProjectStatus;
import team.projectmanager.domain.project.projectrepository.ProjectSearch;

import java.time.LocalDate;
import java.util.List;

public interface ProjectService {
    Long newProject(Long memberId, String name, LocalDate period, LocalDate startDate, LocalDate endDate, String introduction, List<Position> positions);

    Project findProjectById(Long projectId);

    void editProjectStatus(Long projectId, ProjectStatus status);

    List<Project> findByStatus(ProjectStatus status);

    List<Project> findBySearch(ProjectSearch search);
}
