package com.elieldev.exemplo3.repositorio;

import com.elieldev.exemplo3.modelo.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepositorio extends CrudRepository<Aluno, Long> {}
