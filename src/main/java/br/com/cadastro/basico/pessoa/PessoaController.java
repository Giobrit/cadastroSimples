package br.com.cadastro.basico.pessoa;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PessoaDTO criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoaRecebido = mapeador.map(pessoaDTO, Pessoa.class);

        Pessoa pessoa = pessoaService.criarPessoa(pessoaRecebido);

        return mapeador.map(pessoa, PessoaDTO.class);
    }

    @RequestMapping(value = "/{idPessoa}", method = RequestMethod.PUT)
    public void editarPessoa(@PathVariable Long idPessoa, @RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = mapeador.map(pessoaDTO, Pessoa.class);

        pessoaService.editarPessoa(pessoa);
    }

    @RequestMapping(value = "/{idPessoa}", method = RequestMethod.GET)
    public PessoaDTO localizarPessoa(@PathVariable Long idPessoa) {
        Pessoa pessoa = pessoaService.localizarPessoa(idPessoa);

        return mapeador.map(pessoa, PessoaDTO.class);
    }

    @RequestMapping(value = "/{idPessoa}", method = RequestMethod.DELETE)
    public void criarPessoa(@PathVariable Long idPessoa) {
        pessoaService.excluirPessoa(idPessoa);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<PessoaListagemDTO> listarPessoa() {
        List<Pessoa> pessoas = pessoaService.listarPessoa();

        Type listType = new TypeToken<List<PessoaListagemDTO>>() {
        }.getType();

        return mapeador.map(pessoas, listType);
    }
}
