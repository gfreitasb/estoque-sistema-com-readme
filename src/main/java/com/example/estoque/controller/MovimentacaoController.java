package com.example.estoque.controller;

import com.example.estoque.model.MovimentacaoEstoque;
import com.example.estoque.model.Produto;
import com.example.estoque.repository.MovimentacaoRepository;
import com.example.estoque.repository.ProdutoRepository;
import com.example.estoque.service.MovimentacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;
    private final MovimentacaoRepository movimentacaoRepository;
    private final ProdutoRepository produtoRepository;

    public MovimentacaoController(MovimentacaoService movimentacaoService,
                                  MovimentacaoRepository movimentacaoRepository,
                                  ProdutoRepository produtoRepository) {
        this.movimentacaoService = movimentacaoService;
        this.movimentacaoRepository = movimentacaoRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody MovimentacaoEstoque mov) {
        try {
            MovimentacaoEstoque salvo = movimentacaoService.registrar(mov);
            return ResponseEntity.ok(salvo);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<MovimentacaoEstoque>> historico(@PathVariable Long produtoId) {
        Optional<Produto> p = produtoRepository.findById(produtoId);
        if (p.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(movimentacaoRepository.findByProdutoOrderByDataMovimentacaoDesc(p.get()));
    }
}
