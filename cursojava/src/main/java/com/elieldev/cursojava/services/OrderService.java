package com.elieldev.cursojava.services;

import com.elieldev.cursojava.entities.Order;
import com.elieldev.cursojava.repositories.OrderRepositorys;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // registra como uma classe de serviço, classe que ira entregar resposta entre as camadas de Controller e data repositorys
public class OrderService {

  @Autowired
  private OrderRepositorys repositorys;

  public List<Order> findAll() { //retorna todos os dados do banco de order
    return repositorys.findAll();
  }

  public Order findById(Long id) { //retorna o usuario por id
    Optional<Order> obj = repositorys.findById(id); //optional é um modo de resposta da requisição antigo no java
    return obj.get();
  }
}
