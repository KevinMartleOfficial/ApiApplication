package be.vdab.apiapplication.mensen;

import be.vdab.apiapplication.todos.Todo;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "mensen")
public class Mens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String voornaam;
    private String familienaam;
    @OneToMany(mappedBy = "mens", fetch = FetchType.LAZY)
    @OrderBy("id")
    private List<Todo> todos;

    protected Mens(){};

    public Mens(String voornaam, String familienaam) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        todos = new LinkedList<Todo>();
    }

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public List<Todo>getTodos(){
        return Collections.unmodifiableList(todos);
    }
}
