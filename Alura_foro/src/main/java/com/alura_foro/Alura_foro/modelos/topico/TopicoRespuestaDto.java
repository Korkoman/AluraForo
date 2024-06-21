package com.alura_foro.Alura_foro.modelos.topico;

import com.alura_foro.Alura_foro.constantes.Curso;
import com.alura_foro.Alura_foro.constantes.Estatus;

import java.time.LocalDateTime;

public record TopicoRespuestaDto(
        Long id,
        String titulo,
        String autor,
        String mensaje,
        Curso curso,
        LocalDateTime fecha,
        Estatus estatus
) {
}
