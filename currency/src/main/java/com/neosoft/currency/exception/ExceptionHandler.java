package com.neosoft.currency.exception;

import com.neosoft.currency.domain.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionHandler {

//    @ExceptionHandler(NotFoundException.class)
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public BaseResponse notFoundException(final NotFoundException ex)
    {
        log.error("not found");
        return new BaseResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),null);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotCreatedException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public BaseResponse notCreatedException(final NotCreatedException ex){
        log.error("not created");
        return new BaseResponse(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage(),null);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AlreadyPresentException.class)
    @ResponseStatus(HttpStatus.FOUND)
    @ResponseBody
    public BaseResponse alreadyPresentException(final AlreadyPresentException ex){
        log.error("already present");
        return new BaseResponse(HttpStatus.FOUND.value(),ex.getMessage(),null);
    }
}
