package com.example.game_service.controller.implementation;

import com.example.game_service.commons.exceptions.GameException;
import com.example.game_service.commons.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler(value = {GameException.class})
    ResponseEntity<ErrorResponse> handleError(GameException gameException){
    log.error("New exception", gameException);
        var errorResponse = ErrorResponse.builder()
                .codeStatus(gameException.getHttpStatus().value())
                .message(gameException.getMessage())
                .build();


        return ResponseEntity.status(gameException.getHttpStatus()).body(errorResponse);
    }
}
