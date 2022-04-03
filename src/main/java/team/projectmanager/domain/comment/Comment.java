package team.projectmanager.domain.comment;

import lombok.Getter;
import lombok.Setter;
import team.projectmanager.domain.project.Project;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String script;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    public void setProject(Project project) {
        this.project = project;
        project.getComments().add(this);
    }

    public Comment(String script) {
        this.script = script;
    }

    protected Comment() {
    }
}
