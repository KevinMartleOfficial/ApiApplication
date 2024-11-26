package be.vdab.apiapplication.mensen;

import jakarta.validation.constraints.NotBlank;

public record NieuwMens(
        @NotBlank String voornaam,
        @NotBlank String familienaam
) {
}
