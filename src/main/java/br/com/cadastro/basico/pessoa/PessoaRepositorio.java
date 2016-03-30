package br.com.cadastro.basico.pessoa;

import br.com.cadastro.basico.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByEndereco(Endereco endereco);

    List<Pessoa> findByNomeContainsAllIgnoreCase(String nome);

    List<Pessoa> findByEnderecoAndNomeContainsAllIgnoreCase(Endereco endereco, String nome);

    @Query("SELECT p FROM Pessoa p WHERE LOWER(p.nome) LIKE  LOWER(CONCAT('%', :nome,'%'))")
    List<Pessoa> buscarPorNome2(@Param("nome") String nome);

    @Query(value = "SELECT p.* FROM PESSOA p WHERE LOWER(p.nome) LIKE  LOWER(CONCAT('%', :nome,'%'))", nativeQuery = true)
    List<Pessoa> buscarPorNome3(@Param("nome") String nome);
}
