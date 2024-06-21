package com.alura_foro.Alura_foro.modelos.usuario;

import jakarta.validation.constraints.NotBlank;

public record LogInDto(
        @NotBlank
        String usuario,
        @NotBlank
        String password
) {
}
