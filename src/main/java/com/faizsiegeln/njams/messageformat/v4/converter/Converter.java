package com.faizsiegeln.njams.messageformat.v4.converter;

/**
 * A converter defines how specific types have to be serialized for V4 message format.
 * 
 * @author cwinkler
 *
 * @param <T> The type that this {@link Converter} serializes.
 */
public interface Converter<T> {

    public String serialize(T obj) throws Exception;

    public T deserialize(String json) throws Exception;

    public Class<T> getType();

}
