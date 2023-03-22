package com.elieldev.apijava.controle;

import com.elieldev.apijava.modelo.Pessoa;
import com.elieldev.apijava.repositorio.Repositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //controla as rotas http
public class Controle {

  @Autowired //instacia o objeto de outra classe automaticamente
  private Repositorio acao;

  @PostMapping("/api") //salva no banco uma pessoa no Crud do repositorio
  public Pessoa cadastra(@RequestBody Pessoa obj) { //recebe o dado de Body json
    return acao.save(obj);
  }

  @GetMapping("/api") //retorna do banco todas as pessoas
  public List<Pessoa> selecionar() {
    return acao.findAll();
  }

  @GetMapping("/api/{codigo}") //variavel url
  public Pessoa selecionarPeloCodigo(@PathVariable int codigo) { //recebe o valor
    return acao.findByCodigo(codigo); //utiliza o valor pra busca
  }

  @PutMapping("/api") //auterar um registro completo
  public Pessoa editar(@RequestBody Pessoa obj) { //passar o obj completo na req http
    return acao.save(obj); //salva a modificação
  }

  @DeleteMapping("/api/{codigo}")
  public void remover(@PathVariable int codigo) {
    Pessoa obj = selecionarPeloCodigo(codigo); //pesquisa os dados e salva no obj
    acao.delete(obj); //deleta o obj
  }

  @GetMapping("/api/contador") //recebe a quantidade de registros
  public long contador() {
    return acao.count();
  }

  @GetMapping("/api/ordenarNomes")
  public List<Pessoa> ordenaNomes() {
    return acao.findByOrderByNome();
  }
}
