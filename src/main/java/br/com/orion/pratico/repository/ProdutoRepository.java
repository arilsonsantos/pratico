package br.com.orion.pratico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orion.pratico.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
}