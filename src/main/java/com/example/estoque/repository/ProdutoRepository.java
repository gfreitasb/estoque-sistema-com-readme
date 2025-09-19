package com.example.estoque.repository;

import com.example.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByQuantidadeEstoqueLessThan(Integer quantidade);
}
