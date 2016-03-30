package br.com.cadastro.basico.utils;

public class ErrorDTO {
    private String erro;
    private String descricao;

    public ErrorDTO() {
    }

    public ErrorDTO(String erro, String descricao) {
        this.erro = erro;
        this.descricao = descricao;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
