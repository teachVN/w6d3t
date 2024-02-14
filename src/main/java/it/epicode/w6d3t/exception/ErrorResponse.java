package it.epicode.w6d3t.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private LocalDateTime dataRisposta;

    public ErrorResponse(String message) {
        this.message = message;
        dataRisposta = LocalDateTime.now();
    }
}
