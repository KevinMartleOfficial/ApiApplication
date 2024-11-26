package be.vdab.apiapplication.mensen;

import be.vdab.apiapplication.todos.NieuweTodo;
import be.vdab.apiapplication.todos.Todo;
import jakarta.validation.Valid;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.hateoas.server.TypedEntityLinks;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@RestController
@RequestMapping("mensen")
@ExposesResourceFor(Mens.class)
public class MensController {
    private final MensService mensService;
    private final TypedEntityLinks.ExtendedTypedEntityLinks<Mens> links;

    public MensController(MensService mensService, EntityLinks links) {
        this.mensService = mensService;
        this.links = links.forType(Mens.class, Mens::getId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HttpHeaders create (@RequestBody @Valid NieuwMens nieuwMens) {
        Mens mens = mensService.create(nieuwMens);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(links.linkToItemResource(mens).toUri());
        return headers;
    }

    @PostMapping("{id}/todos")
    void createTodo(@PathVariable long id, @RequestBody @Valid NieuweTodo nieuweTodo){
        mensService.createTodo(nieuweTodo, id);
    }

    private record TodoBeknopt(String tekst, LocalDateTime gemaakt){
        TodoBeknopt(Todo todo){
            this(todo.getTekst(), todo.getGemaakt());
        }
    }

    @GetMapping("{id}/todos")
    Stream<TodoBeknopt>findById(@PathVariable long id){
        return mensService.findById(id)
                .stream()
                .map(TodoBeknopt::new);
    }
}
