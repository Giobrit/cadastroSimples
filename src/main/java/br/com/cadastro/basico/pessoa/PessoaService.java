package br.com.cadastro.basico.pessoa;

import br.com.cadastro.basico.endereco.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service("pessoaService")
@Transactional
public class PessoaService {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @PostConstruct
    public void criarNovasPessoas(){
        pessoaRepositorio.save(new Pessoa("Joao1", new Endereco("rua um", "10")));
        pessoaRepositorio.save(new Pessoa("Joao2", new Endereco("rua dois", "11")));
        pessoaRepositorio.save(new Pessoa("Joao3", new Endereco("rua um", "12")));
        pessoaRepositorio.save(new Pessoa("Joao4", new Endereco("rua dois", "13")));
        pessoaRepositorio.save(new Pessoa("Joao5", new Endereco("rua tres", "14")));
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepositorio.save(pessoa);
    }

    public void editarPessoa(Pessoa pessoa){
        pessoaRepositorio.save(pessoa);
    }

    public Pessoa localizarPessoa(Long idPessoa){
        return pessoaRepositorio.findOne(idPessoa);
    }

    public void excluirPessoa(Long idPessoa){
        pessoaRepositorio.delete(idPessoa);
    }

    public List<Pessoa> listarPessoa (){
        return pessoaRepositorio.findAll();
    }
}
