package br.com.producers.api.rest;

import br.com.producers.application.service.ProducerService;
import br.com.producers.domain.valueobjects.WinnerIntervalsVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(servers = {
        @Server(url = "http://localhost:8090/")
})
public class ProducerController {

    private ProducerService producerService;

    ProducerController(ProducerService producerService){
        this.producerService = producerService;
    }

    @GetMapping("/winners")
    public ResponseEntity<WinnerIntervalsVO> getWinners(){
        return ResponseEntity.ok(producerService.getWinners());
    }
}




