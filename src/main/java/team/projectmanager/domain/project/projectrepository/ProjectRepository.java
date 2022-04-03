package team.projectmanager.domain.project.projectrepository;

import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.ProjectStatus;
import team.projectmanager.domain.project.ProjectUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    Long save(Project project);

    Project findById(Long id);

    Project findByName(String name);

    List<Project> findAll();

    default void update(Project project, ProjectUpdateDto dto){}
}
