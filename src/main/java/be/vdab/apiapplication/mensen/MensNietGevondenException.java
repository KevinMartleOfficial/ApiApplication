package be.vdab.apiapplication.mensen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MensNietGevondenException extends RuntimeException {
    MensNietGevondenException(){
        super("Deze persoon bevindt zich niet in de database");
    }
}
