package io.GitHub.viniciusDias1001.Project.Moments.controller;

import io.GitHub.viniciusDias1001.Project.Moments.erros.ApiErros;
import io.GitHub.viniciusDias1001.Project.Moments.exception.UserNotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> msgErro= ex.getBindingResult().getAllErrors().stream().map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());

        return new ApiErros(msgErro);

    }

    @ExceptionHandler(UserNotFoudException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handUserNotFoudExceptions(UserNotFoudException ex){
        String msgErro = ex.getMessage();
        return new ApiErros(msgErro);
    }
}
