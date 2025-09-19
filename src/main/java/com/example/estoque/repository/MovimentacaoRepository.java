package com.example.estoque.repository;

import com.example.estoque.model.MovimentacaoEstoque;
import com.example.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEstoque, Long> {
    List<MovimentacaoEstoque> findByProdutoOrderByDataMovimentacaoDesc(Produto produto);
}
