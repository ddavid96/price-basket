package com.example.priceBasket.util;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class Utils {

    private Utils() {
        // prevent instantiation
    }

    public static <T> Stream<T> collectionToStream(Collection<T> collection) {
        return Optional.ofNullable(collection)
                .map(Collection::stream)
                .orElseGet(Stream::empty);
    }

}
