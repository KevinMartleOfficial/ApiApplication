package be.vdab.apiapplication.mensen;

import be.vdab.apiapplication.todos.NieuweTodo;
import be.vdab.apiapplication.todos.Todo;
import be.vdab.apiapplication.todos.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MensService {
    private final MensRepository mensRepository;
    private final TodoRepository todoRepository;


    public MensService(MensRepository mensRepository, TodoRepository todoRepository) {
        this.mensRepository = mensRepository;
        this.todoRepository = todoRepository;
    }

    Mens create(NieuwMens nieuwMens){
        Mens mens = new Mens(nieuwMens.voornaam(), nieuwMens.familienaam());
        mensRepository.save(mens);
        return mens;
    }


    void createTodo(NieuweTodo nieuweTodo, long id){
        Mens mens = mensRepository.findById(id).orElseThrow(MensNietGevondenException::new);
        Todo todo = new Todo(nieuweTodo.tekst(), mens);
        todoRepository.save(todo);
    }

    List<Todo> findById(long id){
        Mens mens = mensRepository.findById(id).orElseThrow(MensNietGevondenException::new);
        return mens.getTodos();
    }




}
