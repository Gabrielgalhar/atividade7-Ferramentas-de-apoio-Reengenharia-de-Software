package com.gerenciamento.produtos.services;


import com.gerenciamento.produtos.entities.Fornecedor;
import com.gerenciamento.produtos.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    //post
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor){
        Fornecedor  newFornecedor = fornecedorRepository.save(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Fornecedor());
    }
    //get
    public ResponseEntity<List<Fornecedor>>getallFornecedor(){
        List<Fornecedor> allFornecedor = fornecedorRepository.findAll();
        return ResponseEntity.ok(allFornecedor);
    }
    //get by id
    public ResponseEntity<Optional<Fornecedor>> getFornecedorById (@PathVariable Long id){
        Optional<Fornecedor> getFornecedorById = fornecedorRepository.findById(id);
        return ResponseEntity.ok(getFornecedorById);

    }
    //delet
    public ResponseEntity<?> deletFornecedorById(@PathVariable Long id){
        fornecedorRepository.deleteById(id);
        return ResponseEntity.ok("deletado");
    }
    //put
    public Optional<ResponseEntity<Fornecedor>> updateFornecedorById(@RequestBody Fornecedor updateFornecedor, @PathVariable Long id){
        return fornecedorRepository.findById(id).map(fornecedor ->{
            fornecedor.setNome(updateFornecedor.getNome());
            fornecedor.setCnpj(updateFornecedor.getCnpj());

            Fornecedor updatedFornecedor = fornecedorRepository.save(fornecedor);
            return ResponseEntity.ok(updatedFornecedor);
        });
    }
}
