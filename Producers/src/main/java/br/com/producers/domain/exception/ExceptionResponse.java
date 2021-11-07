package br.com.producers.domain.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class ExceptionResponse {

    private LocalDateTime timestamp;
    private String exception;
    private String message;

}
