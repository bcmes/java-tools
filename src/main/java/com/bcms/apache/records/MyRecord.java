package com.bcms.apache.records;

import java.util.List;

//responsabilidade de record é atuar como um suporte de dados imutável.
public class MyRecord {
    /**
     * record é a partir java 14
     * . É uma classe imutável com dois campos: x e y
     * . um record é uma classe final
     * . os campos dados na definicao, tambem sao private final
     * . sao oferecidos "getters" com os mesmos nomes dos atributos dados na definicao
     * . sao implementados os métodos toString(), equals(), hashCode() automaticamente.
     * . nao pode extends nenhuma classe, mas pode implements interfaces
     * . a classe record so pode ter atributos static
     */

    //definicao de record simples
    public record Point(int x, int y) { }

    //definicao de record, com validacao simples dos dados de entrada
    public record Range(int start, int end) {
        public Range { //nao pode usar this aqui..
            if (start < 0)
                start = 0;
            if (end < 0)
                end = 0;

        }
    }

    //definicao de record usando o Construtor Canônico
    public record Range2(int start, int end) {
        public Range2(int start, int end) {
            if (end <= start) {
                throw new IllegalArgumentException("End cannot be lesser than start");
            }
            if (start < 0) {
                this.start = 0;
            } else {
                this.start = start;
            }
            if (end > 100) {
                this.end = 10;
            } else {
                this.end = end;
            }
        }
    }

    //definicao de record usando as diversas formas dos construtores, um chamando o outro
    public record State(String name, String capitalCity, List<String> cities) {
        public State {
            // List.copyOf returns an unmodifiable copy,
            // so the list assigned to `cities` can't change anymore
            cities = List.copyOf(cities); //cópia defensiva: para garantir a imutabilidade do parametro
            //veja que nao se pode alterar os tipos primitivos por serem final, mas os tipos references
            // , exceto strings ficam descobertos, por isso a cópia defensiva.
        }
        public State(String name, String capitalCity) {
            this(name, capitalCity, List.of());
        }
        public State(String name, String capitalCity, String... cities) {
            this(name, capitalCity, List.of(cities));
        }

    }


    public static void main(String[] args) {
        Point point = new Point(4, 6);
        int x = point.x(); //records oferecem os "getters" para os valores, com o mesmo nomes dos atributos.
    }
}

/**
 * Serializando Registros
 * - Nenhum dos sistemas que você pode usar para substituir o processo
 *    de serialização padrão está disponível para registros. Criar um método writeObject()
 *    and readObject() não tem efeito, nem implementar Externalizable.
 * - Os registros podem ser usados como objetos proxy para serializar outros objetos.
 *    Um readResolve()método pode retornar um registro.
 *    Adicionar um writeReplace() registro também é possível.
 * - Desserializar um registro sempre chama o construtor canônico.
 *    Portanto, todas as regras de validação que você adicionar neste construtor
 *    serão aplicadas ao desserializar um registro.
 *    Isso torna os registros uma escolha muito boa para criar objetos de transporte de dados
 *    em seu aplicativo.
 */