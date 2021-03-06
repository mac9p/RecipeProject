package io.github.mac9p.recipeproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

    public Notes() {
    }

    public Notes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
