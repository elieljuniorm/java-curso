package com.elieldev.cursojava.repositories;

import com.elieldev.cursojava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorys extends JpaRepository<User, Long> {}
