package com.elieldev.cursojava.resources;

import com.elieldev.cursojava.entities.Order;
import com.elieldev.cursojava.services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controladores que comunicam com o front por http(get,put,delete,post, ...)
@RequestMapping(value = "/orders")
public class OrderResource {

  @Autowired
  private OrderService service;

  @GetMapping //endpoint get padrao
  public ResponseEntity<List<Order>> findAll() { //endpoint para buscar todos os dados de usuarios
    List<Order> list = service.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}") // endpoint get que passa como parametro na url uma variavel(id) como valor para busca
  public ResponseEntity<Order> findById(@PathVariable Long id) { //registro para o spring entender que recebe a variavel via url
    Order obj = service.findById(id); //instancia a resposta

    return ResponseEntity.ok().body(obj); //entrega a resposta via body http
  }
}
