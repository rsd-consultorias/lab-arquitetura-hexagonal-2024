package br.com.rsdconsultoria.pagamentos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    
    public ResponseEntity<Object> autorizarPagamento(@RequestBody PagamentoRequest payload) {
        return ResponseEntity.ok().build();
    }
}
