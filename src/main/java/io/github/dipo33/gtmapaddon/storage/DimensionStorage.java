package io.github.dipo33.gtmapaddon.storage;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DimensionStorage<T> {

    private final Map<Integer, ChunkStorage<T>> dimensions;

    public DimensionStorage() {
        dimensions = new ConcurrentHashMap<>();
    }

    public ChunkStorage<T> getDimension(int dimensionId) {
        if (!dimensions.containsKey(dimensionId)) {
            dimensions.put(dimensionId, new ChunkStorage<>(dimensionId));
        }

        return dimensions.get(dimensionId);
    }

    public Collection<ChunkStorage<T>> getAll() {
        return dimensions.values();
    }
}
