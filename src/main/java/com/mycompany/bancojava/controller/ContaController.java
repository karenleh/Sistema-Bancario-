package com.mycompany.bancojava.controller;

import com.mycompany.bancojava.dto.TransferenciaDTO;
import com.mycompany.bancojava.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired private ContaService contaService;

    @PostMapping("/transferir")
    public ResponseEntity<?> transferir(@RequestBody TransferenciaDTO dto) {
        contaService.transferir(dto.origemId(), dto.destinoId(), dto.valor());
        return ResponseEntity.ok().build();
    }
}
