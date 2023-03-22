package com.elieldev.apijava.servico;

import com.elieldev.apijava.modelo.Mensagem;
import com.elieldev.apijava.modelo.Pessoa;
import com.elieldev.apijava.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Servico {

  @Autowired
  private Mensagem mensagem;

  @Autowired
  private Repositorio acao;

  // Método para cadastrar pessoas
  public ResponseEntity<?> cadastrar(Pessoa obj) {
    if (obj.getNome().equals("")) { //testa se o nome é vazio
      mensagem.setMensagem("O nome precisa ser preenchido");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    } else if (obj.getIdade() < 0) { //testa se a idade é negativa, 0 pode
      mensagem.setMensagem("Informe uma idaded válida");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    } else { // tudo certo ele salva e retorna o obj salvo no banco
      return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
    }
  }

  // Método para selecionar pessoas
  public ResponseEntity<?> selecionar() {
    return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
  }

  // Método para selecionar pessoas pelo codigo
  public ResponseEntity<?> selecionarPeloCodigo(int codigo) {
    if (acao.countByCodigo(codigo) == 0) { //validação do numero no repositorio
      mensagem.setMensagem("Não foi encontrada nenhuma pessoa");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
    }
  }

  // Método para editar dados
  public ResponseEntity<?> editar(Pessoa obj) {
    if (acao.countByCodigo(obj.getCodigo()) == 0) { //validação do numero no repositorio
      mensagem.setMensagem("O código informado não existe");
      return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
    } else if (obj.getNome().equals("")) { //valida se o nome está vazio
      mensagem.setMensagem("É necessário informar um nome");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    } else if (obj.getIdade() < 0) { //valida se a idade é menor que 0
      mensagem.setMensagem("Informe uma idade válida");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    } else { //Tudo certo ele atualiza os dados
      return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
    }
  }

  // Método para deletar um registro
  public ResponseEntity<?> remover(int codigo) {
    if (acao.countByCodigo(codigo) == 0) { //validação do numero no repositorio
      mensagem.setMensagem("O código informado não existe");
      return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
    } else {
      Pessoa obj = acao.findByCodigo(codigo); //pega o codigo no obj pessoa
      acao.delete(obj); //efetua a ação de delete
      mensagem.setMensagem("Pessoa removida com sucesso");
      return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }
  }
}
