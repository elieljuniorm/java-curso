package com.elieldev.exemplo2.controle;

import com.elieldev.exemplo2.modelo.Postagem;
import com.elieldev.exemplo2.repositorio.PostagemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
public class PostagemControle {

  @Autowired
  private PostagemRepositorio postagem_repositorio;

  @GetMapping("/listar")
  public Iterable<Postagem> listar() {
    return postagem_repositorio.findAll();
  }

  @PostMapping("/cadastrar")
  public Postagem cadastrar(@RequestBody Postagem obj) {
    return postagem_repositorio.save(obj);
  }
}
