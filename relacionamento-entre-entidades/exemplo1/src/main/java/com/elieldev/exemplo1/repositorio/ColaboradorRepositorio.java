package com.elieldev.exemplo1.repositorio;

import com.elieldev.exemplo1.modelo.Colaborador;
import org.springframework.data.repository.CrudRepository;

public interface ColaboradorRepositorio
  extends CrudRepository<Colaborador, Long> {}
