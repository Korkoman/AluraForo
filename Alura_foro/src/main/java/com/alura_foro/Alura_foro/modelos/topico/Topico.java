package com.alura_foro.Alura_foro.modelos.topico;

import com.alura_foro.Alura_foro.constantes.Curso;
import com.alura_foro.Alura_foro.constantes.Estatus;
import com.alura_foro.Alura_foro.modelos.usuario.Usuario;
import com.alura_foro.Alura_foro.token.TokenService;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name="Topico")
@Table(name= "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topico;
    private String mensaje;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_id;

    public Topico(TopicoDto topicoDto , String autor, Usuario usuario_id) {
        this.topico = topicoDto.titulo();
        this.mensaje = topicoDto.mensaje();
        this.fecha = LocalDateTime.now();
        this.estatus = topicoDto.estatus();
        this.curso = topicoDto.curso();
        this.autor = autor;
        this.usuario_id = usuario_id;
    }

    public void actualizaTopico(TopicoActualizaDto topicoActualizaDto){
        this.topico = topicoActualizaDto.topico();
        this.mensaje = topicoActualizaDto.mensaje();
        this.fecha = LocalDateTime.now();
        this.estatus = topicoActualizaDto.estatus();
        this.curso = topicoActualizaDto.curso();
    }
}
