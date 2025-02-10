package br.com.nilson.AppPessoasContatos.Controller;
import br.com.nilson.AppPessoasContatos.DTO.MalaDiretaDTO;
import br.com.nilson.AppPessoasContatos.DTO.PessoaAtualizacaoDTO;
import br.com.nilson.AppPessoasContatos.DTO.PessoaDTO;
import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;
import br.com.nilson.AppPessoasContatos.Service.PessoasService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
@Tag(name = "Pessoa", description = "Gerenciamento de Pessoas")
public class PessoasController {

    @Autowired
    private PessoasService pessoasService;

    @PostMapping
    @Operation(summary = "Cria uma nova Pessoa")
    public ResponseEntity<Pessoas> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        // Convertendo PessoaDTO para Pessoas
        Pessoas novaPessoa = new Pessoas();
        novaPessoa.setNome(pessoaDTO.getNome());
        novaPessoa.setEndereco(pessoaDTO.getEndereco());
        novaPessoa.setCep(pessoaDTO.getCep());
        novaPessoa.setCidade(pessoaDTO.getCidade());
        novaPessoa.setUf(pessoaDTO.getUf());

        // Criando a pessoa
        Pessoas pessoaCriada = pessoasService.criarPessoa(novaPessoa);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }
    
    // Método para buscar pessoa por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtém os dados de uma Pessoa por ID")
    public ResponseEntity<Pessoas> obterPessoaPorId(@PathVariable Long id) {
        Pessoas pessoa = pessoasService.obterPessoaPorId(id);
        if (pessoa == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 caso não encontre a pessoa
        }
        return ResponseEntity.ok(pessoa); // Retorna a pessoa com 200 OK
    }
    
    // Método para buscar pessoa para Mala Direta por ID
    @GetMapping("/maladireta/{id}")
    @Operation(summary = "Obtém os dados de uma Pessoa por ID para Mala Direta")
    public ResponseEntity<MalaDiretaDTO> obterMalaDireta(@PathVariable Long id) {
        Pessoas pessoa = pessoasService.obterPessoaPorId(id);
        if (pessoa == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 caso não encontre a pessoa
        }

        // Criando a string de mala direta
        String malaDireta = String.format("%s – CEP: %s – %s/%s",
                pessoa.getEndereco(), pessoa.getCep(), pessoa.getCidade(), pessoa.getUf());

        // Retorna o DTO de Mala Direta
        MalaDiretaDTO malaDiretaDTO = new MalaDiretaDTO(pessoa.getId(), pessoa.getNome(), malaDireta);
        return ResponseEntity.ok(malaDiretaDTO); // Retorna a resposta com 200 OK
    }
    
    // Método para listar todas as pessoas
    @GetMapping
    @Operation(summary = "Lista todas as Pessoas")
    public ResponseEntity<List<Pessoas>> listarTodasPessoas() {
        List<Pessoas> pessoas = pessoasService.listarTodasPessoas();
        return ResponseEntity.ok(pessoas); // Retorna a lista de pessoas com 200 OK
    }
    
    // Método para atualizar uma pessoa existente
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma Pessoa existente por ID")
    @ApiOperation(value = "Atualiza uma pessoa existente")
    public ResponseEntity<Pessoas> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaAtualizacaoDTO pessoaDTO) {
        Pessoas pessoaExistente = pessoasService.obterPessoaPorId(id);

        if (pessoaExistente == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se a pessoa não existir
        }

        // Atualiza apenas os campos que foram passados no DTO (não vazios, não nulos e não 'string')
        if (isValid(pessoaDTO.getNome())) {
            pessoaExistente.setNome(pessoaDTO.getNome());
        }
        if (isValid(pessoaDTO.getEndereco())) {
            pessoaExistente.setEndereco(pessoaDTO.getEndereco());
        }
        if (isValid(pessoaDTO.getCep())) {
            pessoaExistente.setCep(pessoaDTO.getCep());
        }
        if (isValid(pessoaDTO.getCidade())) {
            pessoaExistente.setCidade(pessoaDTO.getCidade());
        }
        if (isValid(pessoaDTO.getUf())) {
            pessoaExistente.setUf(pessoaDTO.getUf());
        }

        // Salva as alterações no banco de dados
        Pessoas pessoaAtualizada = pessoasService.atualizarPessoa(pessoaExistente);
        return ResponseEntity.ok(pessoaAtualizada); // Retorna a pessoa atualizada com 200 OK
    }

    // Método para verificar se o campo é válido (não é 'null', vazio ou 'string')
    private boolean isValid(String field) {
        return field != null && !field.isEmpty() && !field.equals("string");
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma Pessoa por ID")
    @ApiOperation(value = "Remove uma pessoa por ID")
    public ResponseEntity<Void> removerPessoa(@PathVariable Long id) {
        Pessoas pessoaExistente = pessoasService.obterPessoaPorId(id);

        if (pessoaExistente == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se a pessoa não existir
        }

        pessoasService.removerPessoa(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content se a exclusão for bem-sucedida
    }
}