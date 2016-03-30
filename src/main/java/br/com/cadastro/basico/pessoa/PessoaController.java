package br.com.cadastro.basico.pessoa;

import br.com.cadastro.basico.utils.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ModelMapper mapeador;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoaRecebido = mapeador.map(pessoaDTO, Pessoa.class);

        Pessoa pessoa = pessoaService.criarPessoa(pessoaRecebido);

        PessoaDTO retorno = mapeador.map(pessoa, PessoaDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(retorno));
    }

    @RequestMapping(value = "/{idPessoa}", method = RequestMethod.PUT)
    public void editarPessoa(@PathVariable Long idPessoa, @RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = mapeador.map(pessoaDTO, Pessoa.class);

        pessoaService.editarPessoa(pessoa);
    }

    @RequestMapping(value = "/{idPessoa}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> localizarPessoa(@PathVariable Long idPessoa) {
        Pessoa pessoa = pessoaService.localizarPessoa(idPessoa);

        PessoaDTO retorno = mapeador.map(pessoa, PessoaDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(retorno));
    }

    @RequestMapping(value = "/{idPessoa}", method = RequestMethod.DELETE)
    public void criarPessoa(@PathVariable Long idPessoa) {
        pessoaService.excluirPessoa(idPessoa);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> listarPessoa(@RequestParam(required = false) String nome, @RequestParam(required = false) Long idEndereco) {
        List<Pessoa> pessoas = pessoaService.listarPessoa(nome, idEndereco);

        Type listType = new TypeToken<List<PessoaListagemDTO>>() {
        }.getType();

        List<PessoaListagemDTO> retorno = mapeador.map(pessoas, listType);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(retorno));
    }
}
