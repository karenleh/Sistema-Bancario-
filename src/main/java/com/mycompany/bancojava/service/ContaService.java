package com.mycompany.bancojava.service;

import com.mycompany.bancojava.model.Conta;
import com.mycompany.bancojava.model.Transacao;
import com.mycompany.bancojava.repository.ContaRepository;
import com.mycompany.bancojava.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ContaService {

    @Autowired private ContaRepository contaRepo;
    @Autowired private TransacaoRepository transacaoRepo;
    @Autowired private FraudeService fraudeService;

    public void transferir(Long origemId, Long destinoId, BigDecimal valor) {
        Conta origem = contaRepo.findById(origemId).orElseThrow();
        Conta destino = contaRepo.findById(destinoId).orElseThrow();

        if (origem.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        
        origem.setSaldo(origem.getSaldo().subtract(valor));
        destino.setSaldo(destino.getSaldo().add(valor));
        contaRepo.save(origem);
        contaRepo.save(destino);

        Transacao t = new Transacao();
        t.setContaOrigem(origem);
        t.setContaDestino(destino);
        t.setValor(valor);
        t.setData(LocalDateTime.now());
        t.setTipo("transferencia");
        t.setSuspeita(fraudeService.verificarFraude(t));
        transacaoRepo.save(t);
    }
}