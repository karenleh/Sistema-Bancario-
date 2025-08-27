package com.mycompany.bancojava.repository;

import com.mycompany.bancojava.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {}
