package com.alura_foro.Alura_foro.validaciones;

public class ValidacionDeIntegridad extends RuntimeException{
public ValidacionDeIntegridad(String mensaje){
    super(mensaje);
}
}
