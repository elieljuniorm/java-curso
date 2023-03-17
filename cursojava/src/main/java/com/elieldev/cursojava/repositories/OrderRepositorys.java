package com.elieldev.cursojava.repositories;

import com.elieldev.cursojava.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositorys extends JpaRepository<Order, Long> {}
