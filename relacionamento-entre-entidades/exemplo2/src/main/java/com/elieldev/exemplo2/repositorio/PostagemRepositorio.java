package com.elieldev.exemplo2.repositorio;

import com.elieldev.exemplo2.modelo.Postagem;
import org.springframework.data.repository.CrudRepository;

public interface PostagemRepositorio extends CrudRepository<Postagem, Long> {}
