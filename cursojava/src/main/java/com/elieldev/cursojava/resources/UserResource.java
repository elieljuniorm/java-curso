package com.elieldev.cursojava.resources;

import com.elieldev.cursojava.entities.User;
import com.elieldev.cursojava.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controladores que comunicam com o front por http(get,put,delete,post, ...)
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping //endpoint get padrao
  public ResponseEntity<List<User>> findAll() { //endpoint para buscar todos os dados de usuarios
    List<User> list = service.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}") // endpoint get que passa como parametro na url uma variavel(id) como valor para busca
  public ResponseEntity<User> findById(@PathVariable Long id) { //registro para o spring entender que recebe a variavel via url
    User obj = service.findById(id); //instancia a resposta

    return ResponseEntity.ok().body(obj); //entrega a resposta via body http
  }
}
