package com.elieldev.cursojava.repositories;

import com.elieldev.cursojava.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositorys extends JpaRepository<Product, Long> {}
