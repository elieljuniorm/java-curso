package com.elieldev.exemplo1.repositorio;

import com.elieldev.exemplo1.modelo.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepositorio extends CrudRepository<Cargo, Long> {}
