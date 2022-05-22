package team.projectmanager.domain.project.projectservice;

import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.project.Project;

import java.time.LocalDate;
import java.util.List;

public interface ProjectService {
    void newProject(Long memberId, String name, LocalDate period, LocalDate startDate, LocalDate endDate, String introduction, List<Position> positions);

    Project findProjectById(Long projectId);
}
