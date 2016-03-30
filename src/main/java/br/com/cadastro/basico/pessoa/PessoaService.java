package br.com.cadastro.basico.pessoa;

import br.com.cadastro.basico.endereco.Endereco;
import br.com.cadastro.basico.endereco.EnderecoService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("pessoaService")
@Transactional
public class PessoaService {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @Autowired
    private EnderecoService enderecoService;

    @PostConstruct
    public void criarNovasPessoas() {
        if (pessoaRepositorio.count() > 0) {
            return;
        }

        pessoaRepositorio.save(new Pessoa("Joao1", new Endereco("rua um", "10")));
        pessoaRepositorio.save(new Pessoa("Joao2", new Endereco("rua dois", "11")));
        pessoaRepositorio.save(new Pessoa("Joao3", new Endereco("rua um", "12")));
        pessoaRepositorio.save(new Pessoa("Joao4", new Endereco("rua dois", "13")));
        pessoaRepositorio.save(new Pessoa("Joao5", new Endereco("rua tres", "14")));
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepositorio.save(pessoa);
    }

    public void editarPessoa(Pessoa pessoa) {
        pessoaRepositorio.save(pessoa);
    }

    public Pessoa localizarPessoa(Long idPessoa) {
        return pessoaRepositorio.findOne(idPessoa);
    }

    public void excluirPessoa(Long idPessoa) {
        pessoaRepositorio.delete(idPessoa);
    }

    public List<Pessoa> listarPessoa(String nomeBusca, Long idEndereco) {

        Endereco endereco = null;

        if (!Objects.isNull(idEndereco)) {
            endereco = enderecoService.localizarEndereco(idEndereco);
        }

        List<Pessoa> pessoas = new ArrayList<>();

        if (!Strings.isNullOrEmpty(nomeBusca) && !Objects.isNull(endereco)) {
            pessoas = pessoaRepositorio.findByEnderecoAndNomeContainsAllIgnoreCase(endereco, nomeBusca);
        } else if (Strings.isNullOrEmpty(nomeBusca) && !Objects.isNull(endereco)) {
            pessoas = pessoaRepositorio.findByEndereco(endereco);
        } else if (!Strings.isNullOrEmpty(nomeBusca)) {
            pessoas = pessoaRepositorio.findByNomeContainsAllIgnoreCase(nomeBusca);
        } else {
            pessoas = pessoaRepositorio.findAll();
        }

        return pessoas;
    }

}
