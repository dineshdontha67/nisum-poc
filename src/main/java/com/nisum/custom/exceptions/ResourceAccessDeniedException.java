package com.nisum.custom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="Your are not authorized")
public class ResourceAccessDeniedException extends RuntimeException{

}
