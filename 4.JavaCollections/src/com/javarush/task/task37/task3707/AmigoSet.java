package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {

    private static final Object PRESENT = new Object();

    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) (Math.ceil(collection.size() / .75f));

        this.map = new HashMap<>(capacity < 16 ? 16 : capacity);

        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        if (map.containsKey(e)) {
            return false;
        } else {
            map.put(e, PRESENT);
            return true;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public AmigoSet<E> clone() {
        try {
            AmigoSet<E> cloneAmigoSet = new AmigoSet<>();
            cloneAmigoSet.map = (HashMap<E, Object>) map.clone();
            return cloneAmigoSet;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AmigoSet<?> amigoSet = (AmigoSet<?>) o;
        return Objects.equals(map, amigoSet.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), map);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");

        out.writeInt(capacity);
        out.writeFloat(loadFactor);
        out.writeInt(size());

        out.defaultWriteObject();

        for (E e : map.keySet()) {
            out.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        int size = in.readInt();

        map = new HashMap<>(capacity, loadFactor);

        in.defaultReadObject();

        for (int i = 0; i < size; i++) {
            map.put((E) in.readObject(), PRESENT);
        }
    }
}
