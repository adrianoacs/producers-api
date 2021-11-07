package br.com.producers.api.rest;

import br.com.producers.application.service.ProducerService;
import br.com.producers.domain.valueobjects.WinnerIntervalsVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(servers = {
        @Server(url = "http://localhost:8090/")
})
@RequestMapping("/api")
public class ProducerController {

    private ProducerService producerService;

    ProducerController(ProducerService producerService){
        this.producerService = producerService;
    }

    @GetMapping("/winners")
    @Operation(summary = "Vencedores do prêmio Golden Raspberry Awards", responses = {
            @ApiResponse(description = "Operação Sucesso", responseCode = "200"),
            @ApiResponse(description = "Falha no processamento", responseCode = "417"),
            @ApiResponse(description = "Internal Server Error", responseCode = "500")})
    public ResponseEntity<WinnerIntervalsVO> getWinners(){
        return ResponseEntity.ok(producerService.getWinners());
    }
}




