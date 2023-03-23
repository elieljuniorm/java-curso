package com.elieldev.exemplo1.controle;

import com.elieldev.exemplo1.modelo.Colaborador;
import com.elieldev.exemplo1.repositorio.ColaboradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaboradores") //caminho pricipal
public class ColaboradorControle {

  @Autowired
  private ColaboradorRepositorio colaborador_repositorio;

  @GetMapping("/listar") //sub caminho /colaborador/listar
  public Iterable<Colaborador> listar() { //lista dos colaboradores
    return colaborador_repositorio.findAll();
  }

  @PostMapping("/cadastrar")
  public Colaborador cadastrar(@RequestBody Colaborador obj) { //cadastra um colaborador
    return colaborador_repositorio.save(obj);
  }
}
