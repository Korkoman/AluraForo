package com.alura_foro.Alura_foro.modelos.topico;

import com.alura_foro.Alura_foro.modelos.usuario.Usuario;
import com.alura_foro.Alura_foro.repositories.TopicoRepository;
import com.alura_foro.Alura_foro.repositories.UsuarioRepository;
import com.alura_foro.Alura_foro.token.TokenService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.alura_foro.Alura_foro.token.TokenService.userName;


@RestController
@RequestMapping("/topico")
public class TopicoController {


    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {

        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity addTopico(@RequestBody @Valid TopicoDto topicoDto, UriComponentsBuilder uriBuilder) {
        String autor = userName;
        Usuario userId = usuarioRepository.encontrarUsuario(userName);
        Topico topico = new Topico(topicoDto, autor, userId);
        topicoRepository.save(topico);
        TopicoRespuestaDto topicoRespuestaDto = new TopicoRespuestaDto( topico.getId(), topico.getTopico(), topico.getAutor(),
                                                                        topico.getMensaje(), topico.getCurso(), topico.getFecha(),
                                                                        topico.getEstatus());
        URI url = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(topicoRespuestaDto);

    }
    @GetMapping
    public List<TopicoRespuestaDto> listarTopicos() {
        return topicoRepository.findAll().stream().map(e -> new TopicoRespuestaDto(e.getId(),
                                                       e.getTopico(),e.getAutor(),e.getMensaje(),e.getCurso(),e.getFecha(),
                                                       e.getEstatus())).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity topicoPorId(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id).get();
        return ResponseEntity.ok(new TopicoRespuestaDto(topico.getId(), topico.getTopico(),topico.getAutor(), topico.getMensaje(),topico.getCurso(), topico.getFecha(),topico.getEstatus()));

    }


    @PutMapping
    @Transactional
    public ResponseEntity editaTopico(@RequestBody @Valid TopicoActualizaDto topicoActualizaDto){
        Topico topico = topicoRepository.getReferenceById(topicoActualizaDto.id());
        topico.actualizaTopico(topicoActualizaDto);
        return ResponseEntity.ok().body(topicoActualizaDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopico(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
