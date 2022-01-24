package com.company;


import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

interface MyList<T> extends Iterable<T> {
    int size();

    void add(T t);

    void addAll(MyList<T> myList);

    void clear();

    boolean contains(T t);

    void forEach(Consumer<? super T> consumer);

    T get(int index);

    boolean isEmpty();

    int indexOf(T i);

    T remove(int index);

    void remove(T t);

    boolean removeAll(MyList<T> list);

    boolean removeIf(Predicate<T> predicate);

    void replaceAll(UnaryOperator<T> operator);

    T set(int i, T t);

    void sort(Comparator<? super T> sort);

    MyList<T> subList(int start, int end);

    Object[] toArray();
}
