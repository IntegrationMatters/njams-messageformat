package com.faizsiegeln.njams.messageformat.v4.converter;

/**
 * A converter defines how specific types have to be serialized for V4 message format.
 * 
 * @author cwinkler
 *
 * @param <T> The type that this {@link Converter} serializes.
 */
public interface Converter<T> {

    String serialize(T obj) throws Exception;

    T deserialize(String json) throws Exception;

    Class<T> getType();

}
