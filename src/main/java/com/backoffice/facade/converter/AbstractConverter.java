package com.backoffice.facade.converter;

public abstract class AbstractConverter<S, T> implements Converter<S, T> {

	protected abstract T createTarget();
}
