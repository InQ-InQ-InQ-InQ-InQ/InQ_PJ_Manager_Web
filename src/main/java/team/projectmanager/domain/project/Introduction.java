package team.projectmanager.domain.project;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Introduction {

    private String start;
    private String main;
    private String last;
}
