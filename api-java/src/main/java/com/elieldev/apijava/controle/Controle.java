package com.elieldev.apijava.controle;

import com.elieldev.apijava.modelo.Pessoa;
import com.elieldev.apijava.repositorio.Repositorio;
import com.elieldev.apijava.servico.Servico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @Autowired
  private Servico servico;

  //salva
  @PostMapping("/api") //salva no banco uma pessoa no Crud do repositorio
  public ResponseEntity<?> cadastra(@RequestBody Pessoa obj) { //recebe o dado de Body json
    return servico.cadastrar(obj); //método vindo da classe servico
  }

  //busca dados
  @GetMapping("/api") //retorna do banco todas as pessoas
  public ResponseEntity<?> selecionar() {
    return servico.selecionar(); //método vindo da classe servico
  }

  //busca dados pelo codigo
  @GetMapping("/api/{codigo}") //variavel url
  public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo) { //recebe o valor
    return servico.selecionarPeloCodigo(codigo); //utiliza o valor pra busca
  }

  //edita dados
  @PutMapping("/api") //auterar um registro completo
  public ResponseEntity<?> editar(@RequestBody Pessoa obj) { //passar o obj na req http
    return servico.editar(obj); //salva a modificação
  }

  //deleta dados
  @DeleteMapping("/api/{codigo}")
  public ResponseEntity<?> remover(@PathVariable int codigo) { //envia o codigo
    return servico.remover(codigo); //efetua o delete tratado no servico
  }

  //conta os registros
  @GetMapping("/api/contador") //recebe a quantidade de registros
  public long contador() {
    return acao.count();
  }

  //ordena por nome
  @GetMapping("/api/ordenarNomes") //caminho que retorna nomes ordenados
  public List<Pessoa> ordenaNomes() {
    return acao.findByOrderByNome();
  }

  //retona o que contem no registro
  @GetMapping("/api/nomeContem") //caminho que retorna a pesquisa
  public List<Pessoa> nomeContem() { //pode ser usado para procurar em outros campos
    return acao.findByNomeContaining("l"); //explo procurar ativo ou inativo
  }

  //retorna a soma de idade
  @GetMapping("/api/somaIdades")
  public int somaIdades() {
    return acao.somaIdades();
  }

  //retorna idade maior ou igual
  @GetMapping("/api/idadeMaiorIgual")
  public List<Pessoa> idadeMaiorIgual() {
    return acao.idadeMaiorIgual(40); //paramentro para filtro idade
  }

  //retonar status
  @GetMapping("/status")
  public ResponseEntity<?> status() {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
