package com.faizsiegeln.njams.messageformat.v4.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.faizsiegeln.njams.messageformat.v4.projectmessage.AttributeType;
import com.faizsiegeln.njams.messageformat.v4.projectmessage.RuleType;

/**
 * This is the actual {@link Converter} implementation defined for V4 message format.
 * Use static methods for accessing the converter instances.
 * 
 * @author cwinkler
 *
 * @param <T> The type that this converter instance can convert.
 */
public class DefaultConverter<T> implements Converter<T> {
    @FunctionalInterface
    private interface Mapper<T, R> {
        public R apply(T t) throws Exception;
    }

    private final Class<T> type;
    private final Mapper<T, String> serializer;
    private final Mapper<String, T> deserializer;

    private static final Map<Class<?>, Converter<?>> DEFAULT_CONVERTERS;
    static {
        final Collection<Converter<?>> all = new ArrayList<>();
        all.add(new DefaultConverter<>(LocalDateTime.class,
                DefaultConverter::toString,
                DefaultConverter::unmarshalLocalDateTime));
        all.add(new DefaultConverter<>(RuleType.class,
                DefaultConverter::toString,
                RuleType::fromValue));
        all.add(new DefaultConverter<>(AttributeType.class,
                DefaultConverter::toString,
                AttributeType::fromValue));

        DEFAULT_CONVERTERS = Collections
                .unmodifiableMap(all.stream().collect(
                        Collectors.toMap(Converter::getType, Function.identity())));
    }

    private DefaultConverter(Class<T> type, Mapper<T, String> serializer, Mapper<String, T> deserializer) {
        this.type = type;
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    /**
     * Returns the default converter for the given type, or <code>null</code> if there is none.
     * @param <T> The object type that the returned converter converts
     * @param type The type for that a converter shall be returned.
     * @return The converter instance or <code>null</code>:
     */
    @SuppressWarnings("unchecked")
    public static <T> Converter<T> get(final Class<T> type) {
        return (Converter<T>) DEFAULT_CONVERTERS.get(type);
    }

    /**
     * Returns all default converters.
     * @return An unmodifiable collection of all default converters. 
     */
    public static Collection<Converter<?>> getAll() {
        return DEFAULT_CONVERTERS.values();
    }

    @Override
    public String serialize(T obj) throws Exception {
        return serializer.apply(obj);
    }

    @Override
    public T deserialize(String json) throws Exception {
        return deserializer.apply(json);
    }

    @Override
    public Class<T> getType() {
        return type;
    }

    private static String toString(Object o) {
        return o == null ? null : o.toString();
    }

    private static LocalDateTime unmarshalLocalDateTime(String v) throws Exception {
        if (v == null || v.isEmpty() || v.trim().length() <= 0) {
            return null;
        }
        if (v.endsWith("Z")) {
            String vWithoutZ = v.substring(0, v.length() - 1);
            return fastParseLocalDateTime(vWithoutZ);
        }
        return fastParseLocalDateTime(v);

    }

    private static LocalDateTime fastParseLocalDateTime(String s) {
        // instead of LocalDateTime.parse(s)
        try {
            int nano = 0;
            if (s.length() > 20) {
                nano = Integer.parseInt(rightPadZero(s.substring(20), 9));
            }
            return LocalDateTime.of(intAt(s, 0, 4), intAt(s, 5, 2), intAt(s, 8, 2), intAt(s, 11, 2),
                    intAt(s, 14, 2), intAt(s, 17, 2), nano);
        } catch (Exception e) {
            throw new IllegalArgumentException(s + " is not in valid ISO date/time format.", e);
        }
    }

    private static int intAt(String s, int start, int length) {
        if (s.length() <= start) {
            return 0;
        }
        return Integer.parseInt(s.substring(start, start + length));
    }

    private static String rightPadZero(final String numString, final int size) {
        if (numString == null) {
            return null;
        }
        final int pads = size - numString.length();
        if (pads <= 0) {
            return numString;
        }
        char[] pad = new char[pads];
        Arrays.fill(pad, '0');
        return numString + String.valueOf(pad);
    }

}
