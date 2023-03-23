package com.elieldev.exemplo3.repositorio;

import com.elieldev.exemplo3.modelo.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepositorio extends CrudRepository<Curso, Long> {}
