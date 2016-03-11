package com.client.api.utils;


public interface Filter<F> {

    public boolean accept(F f);
}