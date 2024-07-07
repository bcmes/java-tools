package com.bcms.apache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleAnnotation {
    String attributeName() default "default value x";
}

//Se o attributeName for renomeado de value, nem precisa informar o nome do atributo, ex.: @MyAnnotation("Meu valor passado")

/**
 * Para definir parametros devemos seguir as seguintes regras:
 * - o tipo de retorno do método está restrito aos tipos primitivos, String, Class, Enum, Annotation ou arrays desses tipos.
 * - o nome do metodo será o nome do parametro na Annotation
 * * o metodo nao pode receber parametros e nem lancar excecoes
 * - o método pode ter um valor default associado, para caso do parametro nao ter valor setado
 */

//Exemplo de utilização
record ExampleObject(
        @SimpleAnnotation(attributeName = "Pedro")
        String name,
        Integer age
) { }