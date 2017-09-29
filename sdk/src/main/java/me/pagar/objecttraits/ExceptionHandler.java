package me.pagar.objecttraits;

import me.pagar.exception.ApiErrors;

import java.io.IOException;

/**
 * Created by henriquekano on 9/29/17.
 */
public interface ExceptionHandler {

    void handleException(IOException ioException);
    void handleException(ApiErrors apiError);

}
