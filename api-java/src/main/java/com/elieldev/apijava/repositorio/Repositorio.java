package com.elieldev.apijava.repositorio;

import com.elieldev.apijava.modelo.Pessoa;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
  List<Pessoa> findAll(); //retorna a lista de todas as pessoas
  Pessoa findByCodigo(int codigo); //retorna pessoa pelo ID
  List<Pessoa> findByOrderByNome(); //ordena por nome os registros
}
