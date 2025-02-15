package br.com.nilson.AppPessoasContatos.DTO;

/**
 * DTO (Data Transfer Object) para representar os dados de mala direta de uma pessoa.
 * Utiliza o recurso `record` do Java, que é uma forma concisa de definir classes imutáveis.
 *
 * @param id         Identificador único da pessoa.
 * @param nome       Nome da pessoa.
 * @param malaDireta Texto formatado contendo informações da mala direta (endereço, CEP, cidade e UF).
 */
public record MalaDiretaDTO(Long id, String nome, String malaDireta) {
}
