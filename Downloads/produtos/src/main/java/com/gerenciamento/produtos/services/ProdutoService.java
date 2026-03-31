package com.gerenciamento.produtos.services;

import com.gerenciamento.produtos.entities.Produto;
import com.gerenciamento.produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //post
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
        Produto newProduto = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
    }

    //get
    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> allProdutos = produtoRepository.findAll();
                return ResponseEntity.ok(allProdutos);
    }

    //get por id
    public ResponseEntity<Optional<Produto>> getProdutoById(@PathVariable Long id){
        Optional<Produto> getProdutoById = produtoRepository.findById(id);
        return ResponseEntity.ok(getProdutoById);
    }

    //delet
    public ResponseEntity<?> deletProdutoById (@PathVariable Long id){
        produtoRepository.deleteById(id);
        return  ResponseEntity.ok("Deletado com sucesso");
    }

    //put
    public Optional<ResponseEntity<Produto>> updateProdutoById(@RequestBody Produto updateProduto, @PathVariable Long id){
        return produtoRepository.findById(id).map(produto ->{
           produto.setNome(updateProduto.getNome());
            produto.setPreço(updateProduto.getPreço());
            produto.setQuantidadeEmEstoque(updateProduto.getQuantidadeEmEstoque());

            Produto updatedProduto = produtoRepository.save(produto);
            return ResponseEntity.ok(updatedProduto);
        });
    }

}
