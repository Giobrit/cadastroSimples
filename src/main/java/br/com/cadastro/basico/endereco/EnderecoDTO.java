package br.com.cadastro.basico.endereco;

import br.com.cadastro.basico.pessoa.PessoaDTO;

import java.io.Serializable;
import java.util.List;

public class EnderecoDTO implements Serializable{
    public Long id;
    public String rua;
    public String numero;
    public List<PessoaDTO> pessoas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }
}
