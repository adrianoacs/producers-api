package br.com.producers.api.rest;

import br.com.producers.application.service.ProducerService;
import br.com.producers.domain.valueobjects.WinnerIntervalsVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
