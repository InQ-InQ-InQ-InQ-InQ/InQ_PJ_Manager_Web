package team.projectmanager.domain.project.projectservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.project.Project;
import team.projectmanager.domain.project.projectrepository.ProjectRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository pr;

    @Transactional
    public void newProject(Long memberId, String name, LocalDate period, LocalDate startDate, LocalDate endDate, String introduction, List<Position> positions) {
        Project project = Project.createProject(memberId, name, period, startDate, endDate, introduction, positions);
        pr.save(project);
    }
}
