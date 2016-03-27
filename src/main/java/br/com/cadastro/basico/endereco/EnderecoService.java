package br.com.cadastro.basico.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("enderecoService")
@Transactional
public class EnderecoService {

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepositorio.save(endereco);
    }

    public void editarEndereco(Endereco endereco) {
        enderecoRepositorio.save(endereco);
    }

    public Endereco localizarEndereco(Long idEndereco) {
        return enderecoRepositorio.findOne(idEndereco);
    }

    public void excluirEndereco(Long idEndereco) {
        enderecoRepositorio.delete(idEndereco);
    }

    public List<Endereco> listarEndereco() {
        return enderecoRepositorio.findAll();
    }
}
