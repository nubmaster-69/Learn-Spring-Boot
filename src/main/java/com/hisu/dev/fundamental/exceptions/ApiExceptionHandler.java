package com.hisu.dev.fundamental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ApiRequestException.class})
    public ApiException handleApiRequestException(ApiRequestException apiRequestException) {
        return new ApiException(apiRequestException.getMessage(), ZonedDateTime.now(ZoneId.of("Z")));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ApiException handleFindUserByIdException(UserNotFoundException userNotFoundException) {
        return new ApiException(userNotFoundException.getMessage(), ZonedDateTime.now(ZoneId.of("Z")));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {InvalidUserInfoException.class})
    public ApiException handleInvalidUserException(InvalidUserInfoException invalidUserInfoException) {
        return new ApiException(invalidUserInfoException.getMessage(), ZonedDateTime.now(ZoneId.of("Z")));
    }
}