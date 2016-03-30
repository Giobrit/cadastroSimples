package br.com.cadastro.basico.endereco;

import java.io.Serializable;

public class EnderecoListagemDTO implements Serializable {
    private Long id;
    private String rua;
    private String Numero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
