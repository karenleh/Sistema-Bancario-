package com.mycompany.bancojava.repository;

import com.mycompany.bancojava.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
