package com.empresa.Prueba.Tecnica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esta clase implementa el error HTTP InternalServer 500.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 * @see RuntimeException
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InternalServerErrorException() {
        super();
    }

    public InternalServerErrorException(String msg) {
        super(msg);
    }

}
