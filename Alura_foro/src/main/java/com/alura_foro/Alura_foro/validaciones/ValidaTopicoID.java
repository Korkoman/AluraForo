package com.alura_foro.Alura_foro.validaciones;

import com.alura_foro.Alura_foro.modelos.topico.TopicoDto;
import com.alura_foro.Alura_foro.repositories.TopicoRepository;

public class ValidaTopicoID implements IValidadorTopico{

    private TopicoRepository topicoRepository;

    public ValidaTopicoID(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    public void validaTopico(TopicoDto topicoDto) {
       Long topico = topicoRepository.findByTopico(topicoDto.titulo()).getId();

       if(topico == null){
           throw new ValidacionDeIntegridad("EL topico que busca no existe");
       }
    }
}
