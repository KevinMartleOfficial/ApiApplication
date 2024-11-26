package be.vdab.apiapplication.todos;

import be.vdab.apiapplication.mensen.Mens;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tekst;
    private LocalDateTime gemaakt;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "mensid")
    private Mens mens;

    protected Todo(){}

    public Todo(String tekst, Mens mens) {
        this.tekst = tekst;
        this.gemaakt = LocalDateTime.now();
        this.mens = mens;
    }

    public long getId() {
        return id;
    }

    public String getTekst() {
        return tekst;
    }

    public LocalDateTime getGemaakt() {
        return gemaakt;
    }

    public Mens getMens() {
        return mens;
    }
}
