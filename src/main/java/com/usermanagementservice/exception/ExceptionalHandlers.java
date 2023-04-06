package com.usermanagementservice.exception;

import com.usermanagementservice.constants.ConstantUtils;
import com.usermanagementservice.domain.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.context.support.DefaultMessageSourceResolvable;

@Slf4j
@ControllerAdvice
public class ExceptionalHandlers {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public BaseResponse NotFoundException(final NotFoundException notFoundException) {
        log.info(ConstantUtils.USER_NOT_FOUND);
        return new BaseResponse(HttpStatus.BAD_REQUEST.value(),ConstantUtils.USER_NOT_FOUND, ConstantUtils.USER_NOT_FOUND,null,notFoundException.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse ValidCredentialException(final ValidationException validationException) {
        log.info(ConstantUtils.SOMETHING_WENT_WRONG);
        return new BaseResponse(HttpStatus.BAD_REQUEST.value(),ConstantUtils.SOMETHING_WENT_WRONG, ConstantUtils.SOMETHING_WENT_WRONG,null,validationException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse methodArgumentNotValidException(final MethodArgumentNotValidException methodArgumentNotValidException) {
        log.info(ConstantUtils.SOMETHING_WENT_WRONG);
        var errors = methodArgumentNotValidException.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        return new BaseResponse(HttpStatus.BAD_REQUEST.value(),ConstantUtils.SOMETHING_WENT_WRONG, ConstantUtils.SOMETHING_WENT_WRONG,null,errors);
    }
}
