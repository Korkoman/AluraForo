package com.alura_foro.Alura_foro.modelos.topico;

import com.alura_foro.Alura_foro.constantes.Curso;
import com.alura_foro.Alura_foro.constantes.Estatus;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TopicoDto(
        @NotNull
        @JsonAlias("titulo") String titulo,
        @JsonAlias("mensaje") String mensaje,
        @NotNull
        @JsonAlias("curso") Curso curso,
        @NotNull
        @JsonAlias("estatus") Estatus estatus

) {
}
