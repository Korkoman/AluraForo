package com.alura_foro.Alura_foro.constantes;

public enum Curso {
    FORMACION_ALURA_SPRING_API("Formación alura Spring"),
    FORMACION_ALURA_JAVA("Formación alura Java"),
    FORMACION_ALURA_SQL("Formación alura SQL"),
    FORMACION_ALURA_JPA("Formación alura JPA"),
    FORMACION_ALURA_ORACLE("Formación alura ORACLE");

    private String curso;

    Curso(String curso) {
        this.curso = curso;
    }

    public String getCurso() throws Exception {
        if (curso == null) {
            return curso;
        }else{
            throw new Exception("Este curso no existe o está vacío");
        }
    }


}
