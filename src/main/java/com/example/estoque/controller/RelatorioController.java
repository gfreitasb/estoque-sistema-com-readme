package com.example.estoque.controller;

import com.example.estoque.model.Produto;
import com.example.estoque.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    private final ProdutoRepository produtoRepository;

    public RelatorioController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/produtos-em-falta")
    public List<Produto> produtosEmFalta(@RequestParam(defaultValue = "10") Integer limite) {
        return produtoRepository.findByQuantidadeEstoqueLessThan(limite);
    }
}
