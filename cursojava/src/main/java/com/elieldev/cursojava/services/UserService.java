package com.elieldev.cursojava.services;

import com.elieldev.cursojava.entities.User;
import com.elieldev.cursojava.repositories.UserRepositorys;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // registra como uma classe de serviço, classe que ira entregar resposta entre as camadas de Controller e data repositorys
public class UserService {

  @Autowired
  private UserRepositorys repositorys;

  public List<User> findAll() { //retorna todos os dados do banco de user
    return repositorys.findAll();
  }

  public User findById(Long id) { //retorna o usuario por id
    Optional<User> obj = repositorys.findById(id); //optional é um modo de resposta da requisição antigo no java
    return obj.get();
  }
}
