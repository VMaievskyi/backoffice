package com.backoffice.facade.converter;

import java.util.Collection;

public interface Converter<S, T> {

	T convert(S source);

	void populate(S source, T target);

	Collection<T> convertAll(Collection<S> sources);
}
