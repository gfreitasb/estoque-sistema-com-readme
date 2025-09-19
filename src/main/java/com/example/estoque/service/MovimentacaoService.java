package com.example.estoque.service;

import com.example.estoque.model.MovimentacaoEstoque;
import com.example.estoque.model.Produto;
import com.example.estoque.model.TipoMovimentacao;
import com.example.estoque.repository.MovimentacaoRepository;
import com.example.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final ProdutoRepository produtoRepository;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository, ProdutoRepository produtoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public MovimentacaoEstoque registrar(MovimentacaoEstoque mov) {
        Optional<Produto> opt = produtoRepository.findById(mov.getProduto().getId());
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado: " + mov.getProduto().getId());
        }
        Produto produto = opt.get();

        if (mov.getTipoMovimentacao() == TipoMovimentacao.ENTRADA) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + mov.getQuantidade());
        } else {
            if (produto.getQuantidadeEstoque() < mov.getQuantidade()) {
                throw new IllegalArgumentException("Quantidade em estoque insuficiente.");
            }
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - mov.getQuantidade());
        }

        produtoRepository.save(produto);
        mov.setProduto(produto);
        return movimentacaoRepository.save(mov);
    }
}
