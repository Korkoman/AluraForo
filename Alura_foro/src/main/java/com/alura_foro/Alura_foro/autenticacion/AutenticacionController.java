package com.alura_foro.Alura_foro.autenticacion;

import com.alura_foro.Alura_foro.modelos.usuario.LogInDto;
import com.alura_foro.Alura_foro.modelos.usuario.Usuario;
import com.alura_foro.Alura_foro.modelos.usuario.UsuarioDto;
import com.alura_foro.Alura_foro.token.TokenDto;
import com.alura_foro.Alura_foro.token.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity autenticacion(@RequestBody @Valid LogInDto logInDto) {
        Authentication authtoken = new UsernamePasswordAuthenticationToken(logInDto.usuario(), logInDto.password());
        authenticationManager.authenticate(authtoken);
        var usuarioAutenticado = authenticationManager.authenticate(authtoken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new TokenDto(jwtToken));
    }
}