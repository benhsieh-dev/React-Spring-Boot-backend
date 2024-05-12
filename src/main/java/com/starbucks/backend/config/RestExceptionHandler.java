package com.starbucks.backend.config;

import com.starbucks.backend.dto.ErrorDto;
import com.starbucks.backend.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestExceptionHandler {

    @ExceptionHandler(value={AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        return ResponseEntity.status(ex.getCode())
                .body(ErrorDto.builder().message(ex.getMessage()).build());
    }

}
