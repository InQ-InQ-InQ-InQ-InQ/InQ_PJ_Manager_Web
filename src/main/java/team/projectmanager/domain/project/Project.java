package team.projectmanager.domain.project;

import lombok.Getter;
import lombok.Setter;
import team.projectmanager.domain.comment.Comment;
import team.projectmanager.domain.memberproject.MemberProject;
import team.projectmanager.domain.position.Position;
import team.projectmanager.domain.position.PositionEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private Long adminId;

    @Column(name = "project_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    private String introduction;

    private LocalDate period;

    private LocalDate startDate;

    private LocalDate endDate;

    @ElementCollection
    @CollectionTable(name = "project_positions",
                    joinColumns = @JoinColumn(name = "project_id"))
    @Enumerated(EnumType.STRING)
    private List<Position> positions = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<MemberProject> memberProjects =  new ArrayList<>();

    //넣을지 뺄지 고민
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments =  new ArrayList<>();

    public void removeMP(MemberProject memberProject) {
        getMemberProjects().removeIf(mp -> mp.getId().equals(memberProject.getId()));
    }

    public void addComment(Comment comment) {
        comment.setProject(this);
        getComments().add(comment);
    }
}
