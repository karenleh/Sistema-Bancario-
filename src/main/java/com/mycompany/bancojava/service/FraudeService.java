package com.mycompany.bancojava.service;

import com.mycompany.bancojava.model.Transacao;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FraudeService {
    public boolean verificarFraude(Transacao transacao) {
        return transacao.getValor().compareTo(new BigDecimal("10000")) > 0;
    }
}
