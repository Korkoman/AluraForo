package com.alura_foro.Alura_foro.modelos.usuario;

import com.alura_foro.Alura_foro.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity addUsuario(@RequestBody @Valid UsuarioDto usuarioDto, UriComponentsBuilder uriBuilder){
        Usuario usuario = usuarioRepository.save(new Usuario(usuarioDto));
        UsuarioRespuestaDto usuarioRespuestaDto = new UsuarioRespuestaDto(usuario.getUsuario(), usuario.getEmail());
        URI url = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(usuarioRespuestaDto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteUsuario(@RequestBody @Valid UsuarioDeleteDto usuarioDeleteDto){
        Usuario usuario = usuarioRepository.encontrarUsuario(usuarioDeleteDto.usuario());
        System.out.println(usuario.toString());
        usuarioRepository.delete(usuario);
        return ResponseEntity.noContent().build();
    }
}
