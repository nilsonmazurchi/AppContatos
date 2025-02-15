package br.com.nilson.AppPessoasContatos.Controller;

import br.com.nilson.AppPessoasContatos.DTO.ContatoDTO;
import br.com.nilson.AppPessoasContatos.DTO.ContatoDTONome;
import br.com.nilson.AppPessoasContatos.Modelos.Contatos;
import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;
import br.com.nilson.AppPessoasContatos.Modelos.TipoContato;
import br.com.nilson.AppPessoasContatos.Service.ContatosService;
import br.com.nilson.AppPessoasContatos.Service.PessoasService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controlador responsável pelo gerenciamento de tipos de contatos.
@RestController
@RequestMapping("/api/contatos")
@Tag(name = "Contato", description = "Gerenciamento de Tipos de Contatos")
public class ContatosController {

    private final ContatosService contatosService;
    private final PessoasService pessoasService;

    public ContatosController(ContatosService contatosService, PessoasService pessoasService) {
        this.contatosService = contatosService;
        this.pessoasService = pessoasService;
    }
    
    
    //Adiciona um novo contato a uma pessoa pelo ID.
    @PostMapping("/id")
    @ApiOperation(value = "Adiciona um novo tipo de contato a uma Pessoa por ID")
    @Operation(summary = "Adiciona um novo tipo de contato a uma Pessoa por ID")
    public ResponseEntity<?> adicionarContatoPorId(@RequestBody ContatoDTO contatoDTO) {
        // Buscar pessoa pelo ID
        Pessoas pessoa = pessoasService.obterPessoaPorId(contatoDTO.getPessoaId());

        // Se a pessoa não for encontrada, retorna erro 404
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }

        // Converte a String tipoContato para o tipo TipoContato
        TipoContato tipoContato = TipoContato.valueOf(contatoDTO.getTipoContato().toUpperCase());

        // Criar o contato e associar à pessoa
        Contatos novoContato = new Contatos();
        novoContato.setTipoContato(tipoContato);
        novoContato.setDescContato(contatoDTO.getDescContato());
        novoContato.setPessoa(pessoa);

        // Salvar o contato
        Contatos contatoSalvo = contatosService.salvarContato(novoContato);

        // Retorna o contato salvo com 200 OK
        return ResponseEntity.ok(contatoSalvo);
    }
    
    //Adiciona um novo tipo de contato a uma pessoa pelo nome.
    @PostMapping("/nome")
    @ApiOperation(value = "Adiciona um novo tipo de contato a uma Pessoa por Nome")
    @Operation(summary = "Adiciona um novo tipo de contato a uma Pessoa por Nome")
    public ResponseEntity<?> adicionarContatoPorNome(@RequestBody ContatoDTONome contatoDTONome) {
        // Buscar pessoa pelo Nome
        Pessoas pessoa = pessoasService.obterPessoaPorNome(contatoDTONome.getPessoaNome());

        // Se a pessoa não for encontrada, retorna erro 404
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }

        // Converte a String tipoContato para o tipo TipoContato
        TipoContato tipoContato = TipoContato.valueOf(contatoDTONome.getTipoContato().toUpperCase());

        // Criar o tipo de contato e associar à pessoa
        Contatos novoContato = new Contatos();
        novoContato.setTipoContato(tipoContato);
        novoContato.setDescContato(contatoDTONome.getDescContato());
        novoContato.setPessoa(pessoa);

        // Salvar o tipo de contato
        Contatos contatoSalvo = contatosService.salvarContato(novoContato);

        // Retorna o tipo de contato salvo com 200 OK
        return ResponseEntity.ok(contatoSalvo);
    }
    
    //Retorna os dados de um tipo de contato por ID.
    @GetMapping("/api/contatos/{id}")
    @ApiOperation(value = "Retorna os dados de um tipo de contato por ID")
    @Operation(summary = "Retorna os dados de um tipo de contato por ID")
    public ResponseEntity<Contatos> obterContatoPorId(@PathVariable Long id) {
        // Busca o tipo de contato pelo ID
        Contatos contato = contatosService.obterContatoPorId1(id);

        // Verifica se o tipo de contato foi encontrado
        if (contato == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 caso não encontre o contato
        }

        // Retorna o tipo de contato encontrado com 200 OK
        return ResponseEntity.ok(contato);
    }
    
    //Lista todos os tipos de contatos de uma pessoa pelo IDPessoa.
    @GetMapping("/pessoa/{idPessoa}")
    @ApiOperation(value = "Lista todos os tipos de contatos de uma pessoa pelo ID")
    @Operation(summary = "Lista todos os tipos de contatos de uma pessoa pelo ID")
    public ResponseEntity<List<Contatos>> listarContatosPorPessoa(@PathVariable Long idPessoa) {
        // Busca a pessoa pelo ID
        Pessoas pessoa = pessoasService.obterPessoaPorId(idPessoa);
        
        if (pessoa == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se a pessoa não for encontrada
        }

        // Busca todos os tipos de contatos da pessoa
        List<Contatos> contatos = contatosService.listarContatosPorPessoa(pessoa);
        
        if (contatos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se não houver tipos de contatos
        }

        return ResponseEntity.ok(contatos); // Retorna os tipos de contatos com status 200
    }
    
    //Atualiza um tipo de contato existente.
    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um tipo de contato existente")
    @Operation(summary = "Atualiza um tipo de contato existente")
    public ResponseEntity<Contatos> atualizarContato(@PathVariable Long id, @RequestBody ContatoDTO contatoDTO) {
        // Busca o tipo de contato pelo ID
        Contatos contatoExistente = contatosService.obterContatoPorId1(id);
        
        if (contatoExistente == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o tipo de contato não for encontrado
        }

        // Atualiza os campos que foram passados no DTO, se não forem nulos ou vazios
        if (contatoDTO.getTipoContato() != null && !contatoDTO.getTipoContato().isEmpty()) {
            // Converte o tipo de contato para o tipo correto
            TipoContato tipoContato = TipoContato.valueOf(contatoDTO.getTipoContato().toUpperCase());
            contatoExistente.setTipoContato(tipoContato);
        }

        // Verifica se o campo "descContato" não é indesejado e, se válido, atualiza
        if (contatoDTO.getDescContato() != null && !contatoDTO.getDescContato().isEmpty() && 
            !contatoDTO.getDescContato().equals("CAMPO ABERTO DESCRIÇÃO")) {
            contatoExistente.setDescContato(contatoDTO.getDescContato());
        }

        // Atualiza a pessoa associada, caso o ID da pessoa seja fornecido
        if (contatoDTO.getPessoaId() != null) {
            Pessoas pessoa = pessoasService.obterPessoaPorId(contatoDTO.getPessoaId());
            if (pessoa != null) {
                contatoExistente.setPessoa(pessoa);
            }
        }

        // Salva o tipo de contato atualizado
        Contatos contatoAtualizado = contatosService.salvarContato(contatoExistente);
        
        return ResponseEntity.ok(contatoAtualizado); // Retorna o tipo de contato atualizado com status 200 OK
    }
    
    //Remove um tipo de contato por ID.
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove um tipo de contato por ID")
    @Operation(summary = "Remove um tipo de contato por ID")
    public ResponseEntity<Void> removerContato(@PathVariable Long id) {
        // Verifica se o tipo de contato existe
        Contatos contato = contatosService.obterContatoPorId1(id);
        
        if (contato == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o tipo de contato não for encontrado
        }

        // Remove o tipo de contato
        contatosService.removerContato(id);
        
        return ResponseEntity.noContent().build(); // Retorna 204 No Content (sucesso, sem corpo na resposta)
    }
    
}
