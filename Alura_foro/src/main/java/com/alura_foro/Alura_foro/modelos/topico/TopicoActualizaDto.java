package com.alura_foro.Alura_foro.modelos.topico;

import com.alura_foro.Alura_foro.constantes.Curso;
import com.alura_foro.Alura_foro.constantes.Estatus;

public record TopicoActualizaDto(
        Long id,
        String topico,
        String mensaje,
        Curso curso,
        Estatus estatus
) {
}
