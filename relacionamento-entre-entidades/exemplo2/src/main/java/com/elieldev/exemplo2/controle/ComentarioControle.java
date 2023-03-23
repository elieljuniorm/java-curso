package com.elieldev.exemplo2.controle;

import com.elieldev.exemplo2.modelo.Comentario;
import com.elieldev.exemplo2.repositorio.ComentarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentarios") //rota principal
public class ComentarioControle {

  @Autowired
  private ComentarioRepositorio comentario_repositorio; //intancia do repositorio
  // validações de rota devem ser feitas no repositorio e importa apenas a função

  @GetMapping("/listar") //sub rota
  public Iterable<Comentario> listar() { //lista todos os registros de comentario
    return comentario_repositorio.findAll();
  }

  @PostMapping("/cadastrar") //sub rota
  public Comentario cadastrar(@RequestBody Comentario obj) { //cria um comentario
    return comentario_repositorio.save(obj);
  }
}