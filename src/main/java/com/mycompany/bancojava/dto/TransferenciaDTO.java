package com.mycompany.bancojava.dto;

import java.math.BigDecimal;

public record TransferenciaDTO(Long origemId, Long destinoId, BigDecimal valor) {}
