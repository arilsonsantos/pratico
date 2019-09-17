package br.com.orion.pratico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.orion.pratico.exception.ResourceNotFoundException;
import br.com.orion.pratico.model.Produto;
import br.com.orion.pratico.repository.ProdutoRepository;
import lombok.Setter;

@Service
public class ProdutoService {

    @Setter
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.setProdutoRepository(produtoRepository);
    }

    public List<Produto> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado. ID: " + id));
    }
    
    public Produto insert(Produto produto) {
        produto = produtoRepository.saveAndFlush(produto);
        return produto;
    }

    public Produto update(Produto produto) {
        Produto updateProduto = findById(produto.getId());

        updateProduto.setNome(produto.getNome());
        updateProduto.setCategoria(produto.getCategoria());
        produto = produtoRepository.save(updateProduto);

        return produto;
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }


}