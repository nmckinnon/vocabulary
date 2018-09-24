package com.nmckinnon.vocabulary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * An exception indicating that a word could not be retrieved for presentation.
 * 
 * @author nmckinnon
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WordLookupException extends Exception
{
    private static final long serialVersionUID = 2470066385071647261L;

}
