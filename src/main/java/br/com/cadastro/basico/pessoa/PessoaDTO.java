package br.com.cadastro.basico.pessoa;


import br.com.cadastro.basico.endereco.EnderecoDTO;

import java.io.Serializable;

public class PessoaDTO implements Serializable {
    public Long id;
    public String nome;
    public EnderecoDTO endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
