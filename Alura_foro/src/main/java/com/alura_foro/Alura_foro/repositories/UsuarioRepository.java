package com.alura_foro.Alura_foro.repositories;

import com.alura_foro.Alura_foro.modelos.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByUsuario(String usuario);

    @Query("SELECT s FROM Usuario s WHERE s.usuario = :userName")
    Usuario encontrarUsuario(String userName);
}
