package br.com.orion.pratico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orion.pratico.model.Produto;
import br.com.orion.pratico.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/produtos")
public class ProdutoController extends AbstractResponseController {

    private final ProdutoService produtoService;
        
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Produto> produtos = produtoService.findAll();
        if (produtos.isEmpty()) {
            return resposta(HttpStatus.NO_CONTENT);
        }
        return resposta(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Produto produto = produtoService.findById(id);
        return resposta(produto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody Produto produto) {
        produto = produtoService.insert(produto);
        return resposta(produto, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> update(@Valid @RequestBody Produto produto) {
        produto = produtoService.update(produto);
        return resposta(produto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> insert(@PathVariable("id") Long id) {
        produtoService.delete(id);
        return resposta(HttpStatus.NO_CONTENT);
    }
   
}