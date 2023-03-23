package com.elieldev.exemplo1.controle;

import com.elieldev.exemplo1.modelo.Cargo;
import com.elieldev.exemplo1.repositorio.CargoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargos") //caminho pricipal
public class CargoControle {

  @Autowired
  private CargoRepositorio cargo_repositorio;

  @GetMapping("/listar") //sub caminho /cargos/listar
  public Iterable<Cargo> listar() { //lista dos os cargos
    return cargo_repositorio.findAll();
  }

  @PostMapping("/cadastrar")
  public Cargo cadastrar(@RequestBody Cargo obj) { //cadastra um cargo
    return cargo_repositorio.save(obj);
  }
}
