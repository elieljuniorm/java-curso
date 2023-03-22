package com.elieldev.apijava.repositorio;

import com.elieldev.apijava.modelo.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Repositorio extends CrudRepository<Pessoa, Integer> {
  List<Pessoa> findAll(); //retorna a lista de todas as pessoas

  Pessoa findByCodigo(int codigo); //retorna pessoa pelo ID

  List<Pessoa> findByOrderByNome(); //ordena por nome os registros

  List<Pessoa> findByNomeContaining(String termo);

  // Anotação que permite utilizar comandos SQL que o JPA não disponibiliza
  @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
  int somaIdades();

  @Query(
    value = "SELECT * FROM pessoas WHERE idade >= :idade",
    nativeQuery = true
  ) //:idade faz o sql receber o valor do parametro idade da function idadeMaiorIgual
  List<Pessoa> idadeMaiorIgual(int idade);

  int countByCodigo(int codigo); //verifica se existe o numero pesquisado, se nao existe retorna zero
}
