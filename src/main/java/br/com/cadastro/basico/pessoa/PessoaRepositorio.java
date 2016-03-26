package br.com.cadastro.basico.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio  extends JpaRepository<Pessoa, Long>{
}
