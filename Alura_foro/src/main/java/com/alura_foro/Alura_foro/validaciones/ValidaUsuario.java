package com.alura_foro.Alura_foro.validaciones;

import com.alura_foro.Alura_foro.modelos.usuario.Usuario;
import com.alura_foro.Alura_foro.modelos.usuario.UsuarioDto;
import com.alura_foro.Alura_foro.repositories.UsuarioRepository;

public class ValidaUsuario implements IValidadorUsuario {

    private UsuarioRepository usuarioRepository;

    public ValidaUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void validar(UsuarioDto datos) {

        Usuario usuario = (Usuario) usuarioRepository.findByUsuario(datos.usuario());
        if (usuario == null) {
            throw new ValidacionDeIntegridad("Usuario no encontrado");
        }
    }
}
