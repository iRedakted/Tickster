package io.jking.tickster.interaction;

import net.dv8tion.jda.internal.interactions.InteractionImpl;

import java.util.HashMap;
import java.util.Map;

public class Registry<V> {

    private final Map<String, V> registryMap;

    public Registry() {
        this.registryMap = new HashMap<>();
    }

    public Registry<V> put(String key, V value) {
        this.registryMap.put(key, value);
        return this;
    }

    public V get(String id) {
        return registryMap.getOrDefault(id, null);
    }

    public Map<String, V> getMap() {
        return registryMap;
    }
}
