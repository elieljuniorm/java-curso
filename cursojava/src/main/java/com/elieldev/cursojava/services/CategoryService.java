package com.elieldev.cursojava.services;

import com.elieldev.cursojava.entities.Category;
import com.elieldev.cursojava.repositories.CategoryRepositorys;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // registra como uma classe de serviço, classe que ira entregar resposta entre as camadas de Controller e data repositorys
public class CategoryService {

  @Autowired
  private CategoryRepositorys repositorys;

  public List<Category> findAll() { //retorna todos os dados do banco de category
    return repositorys.findAll();
  }

  public Category findById(Long id) { //retorna o usuario por id
    Optional<Category> obj = repositorys.findById(id); //optional é um modo de resposta da requisição antigo no java
    return obj.get();
  }
}
