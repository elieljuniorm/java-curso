package com.elieldev.cursojava.services;

import com.elieldev.cursojava.entities.Product;
import com.elieldev.cursojava.repositories.ProductRepositorys;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // registra como uma classe de serviço, classe que ira entregar resposta entre as camadas de Controller e data repositorys
public class ProductService {

  @Autowired
  private ProductRepositorys repositorys;

  public List<Product> findAll() { //retorna todos os dados do banco de Product
    return repositorys.findAll();
  }

  public Product findById(Long id) { //retorna o usuario por id
    Optional<Product> obj = repositorys.findById(id); //optional é um modo de resposta da requisição antigo no java
    return obj.get();
  }
}
