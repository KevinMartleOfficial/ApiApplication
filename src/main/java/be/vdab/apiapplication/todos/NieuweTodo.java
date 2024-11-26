package be.vdab.apiapplication.todos;

import jakarta.validation.constraints.NotBlank;

public record NieuweTodo(@NotBlank String tekst) {
}
