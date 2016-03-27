package br.com.cadastro.basico.pessoa;

import br.com.cadastro.basico.endereco.Endereco;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_GENERATOR")
    @SequenceGenerator(name = "PESSOA_GENERATOR", sequenceName = "PESSOA_SEQUENCE", allocationSize = 1, initialValue = 0)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa that = (Pessoa) o;

        return Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
