package com.elieldev.cursojava.repositories;

import com.elieldev.cursojava.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositorys extends JpaRepository<Category, Long> {}
