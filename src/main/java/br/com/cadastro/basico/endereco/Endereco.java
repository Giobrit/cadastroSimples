package br.com.cadastro.basico.endereco;

import br.com.cadastro.basico.pessoa.Pessoa;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ENDERECO")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_GENERATOR")
    @SequenceGenerator(name = "ENDERECO_GENERATOR", sequenceName = "ENDERECO_SEQUENCE", allocationSize = 1, initialValue = 0)
    private Long id;

    @Column(name = "RUA")
    private String rua;

    @Column(name = "NUMERO")
    private String numero;

    @OneToMany(mappedBy = "endereco")
    private List<Pessoa> pessoas;

    public Endereco() {
    }

    public Endereco(String rua, String numero) {
        this.rua = rua;
        this.numero = numero;
    }

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

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco that = (Endereco) o;

        return Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("rua", rua)
                .add("numero", numero)
                .toString();
    }
}

