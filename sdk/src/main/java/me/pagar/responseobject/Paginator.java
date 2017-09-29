package me.pagar.responseobject;

/**
 * Created by henriquekano on 9/29/17.
 */

import me.pagar.endpoint.EndpointConsumer;
import me.pagar.exception.ApiErrors;
import me.pagar.objecttraits.CanBecomeQueryString;
import me.pagar.objecttraits.CanLoadFieldsFromSources;
import me.pagar.objecttraits.ExceptionHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Paginator<T extends CanLoadFieldsFromSources> implements Iterator<T> {

    private final Integer pageSize;
    private Integer currentPage = 1;

    private Integer currentIndex = 0;
    private EndpointConsumer<T> endpointConsumer;
    private CanBecomeQueryString filter;

    private List<T> accumulator;
    private ExceptionHandler handler;

    public Paginator(Integer currentPage, Integer pageSize, EndpointConsumer<T> endpointConsumer, CanBecomeQueryString filter, ExceptionHandler handler) {
        this.currentPage = currentPage;
        this.pageSize = pageSize < 1 ? 1 : pageSize;
        this.endpointConsumer = endpointConsumer;
        this.filter = filter;
        this.accumulator = new ArrayList<T>();
    }

    public Paginator(Integer pageSize, EndpointConsumer<T> endpointConsumer, CanBecomeQueryString filter, ExceptionHandler handler) {
        this(0, pageSize, endpointConsumer, filter, handler);
    }

    public Paginator(EndpointConsumer<T> endpointConsumer, CanBecomeQueryString filter, ExceptionHandler handler) {
        this(0, 10, endpointConsumer, filter, handler);

    }

    public boolean hasNext() {
        Boolean indexBeyondAccumulatorSize = this.accumulator.size() <= currentIndex + 1;
        if(indexBeyondAccumulatorSize) {
            List<T> freshBatch = null;
            try {
                freshBatch = retrieveNextAccumulatorIteration();
            } catch (IOException e) {
                handler.handleException(e);
            } catch (ApiErrors e) {
                handler.handleException(e);
            }
            this.accumulator.addAll(freshBatch);
            Boolean theresMoreTs = freshBatch.size() > 0;
            if(theresMoreTs) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public T next() {
        if(hasNext()) {
            return this.accumulator.get(this.currentIndex);
        }
        return null;
    }

    public void remove() {

    }

    private List<T> retrieveNextAccumulatorIteration() throws IOException, ApiErrors {
        this.currentPage++;
        List<T> freshBatch = this.endpointConsumer.listWithParameters(this.filter);
        return freshBatch;
    }

}
