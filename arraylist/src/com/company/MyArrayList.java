package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class MyArrayList<Type> implements MyList<Type>, Cloneable {
    Type[] backingArray;
    int size;
    int capacity;

    private class MyItr implements Iterator<Type> {

        int current = 0;

        @Override
        public boolean hasNext() {
            return current != size();
        }

        @Override
        public Type next() {
            return backingArray[current++];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super Type> action) {
            Iterator.super.forEachRemaining(action);
        }
    }

    public MyArrayList() {
        backingArray = (Type[]) new Object[0];
        size = 0;
        capacity = 0;
    }

    public MyArrayList(MyList<Type> list) {
        backingArray = (Type[]) new Object[list.size()];
        int index = 0;
        for(Type i : list) {
            backingArray[index++] = i;
        }
    }

    public MyArrayList(int initialCapacity) {
        backingArray = (Type[]) new Object[initialCapacity];
        capacity = initialCapacity;
    }

    private Type[] expandArray() {
        int newSize = 1 << size();
        Type[] newArray = (Type[]) new Object[newSize];
        System.arraycopy(backingArray, 0, newArray, 0, size());
        capacity = newSize;
        return newArray;
    }

    public void add(Type element) {
        if( size + 1 >= capacity ) {
            this.backingArray = expandArray();
        }
        backingArray[size++] = element;
    }

    public void addAll(MyList<Type> list) {
        for(Type i : list) {
            this.add(i);
        }
    }

    public void clear() {
        backingArray = (Type[]) new Object[0];
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean contains(Type element) {
        for(int i = 0; i < this.size(); i++) {
            if(backingArray[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void ensureCapacity(int minCapacity) {
        if( capacity < minCapacity) {
            backingArray = expandArray();
        }
    }

    public void forEach(Consumer<? super Type> consumer) {
        for(int i = 0; i < this.size(); i++) {
            consumer.accept(backingArray[i]);
        }
    }

    public Type get(int index) {
        if(index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return backingArray[index];
    }

    public int indexOf(Type element) {
        for(int i = 0; i < size(); ++i ) {
            if(backingArray[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<Type> iterator() {
        return new MyArrayList<Type>.MyItr();
    }

    public int lastIndexOf(Type element) {
        for(int i = size() - 1; i >= 0; --i) {
            if( backingArray[i].equals(element) ) {
                return i;
            }
        }
        return -1;
    }

    public Type remove(int index) {
        if(index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Type element = null;
        int count = 0;
        for(int i = 0; i < size(); ++i) {
            if(i != index) {
                backingArray[count++] = backingArray[i];
            } else {
                element = backingArray[i];
                backingArray[i] = null;
                --size;
            }
        }
        return element;
    }

    public void remove(Type element) {
        boolean deleted = false;
        int count = 0;
        for(int i = 0; i < size(); i++) {
            if(backingArray[i].equals(element)) {
                deleted = true;
                backingArray[i] = null;
                break;
            } else {
                backingArray[count++] = backingArray[i];
            }
        }
        for(int i = count; i < size() - 1; i++) {
            backingArray[i] = backingArray[i + 1];
        }
        if(deleted) {
            --size;
        }
    }

    public boolean removeAll(MyList<Type> list) {
        boolean result = false;
        for(Type i : list) {
            for (int j = 0; j < this.size(); ++j) {
                if (backingArray[j].equals(i)) {
                    result = true;
                    remove(i);
                    break;
                }
            }
        }
        return result;
    }

    public boolean removeIf(Predicate<Type> predicate) {
        boolean result = false;
        for(int i = 0; i < this.size(); ++i) {
            if(predicate.test(backingArray[i])) {
                result = true;
                remove(backingArray[i--]);
            }
        }
        return result;
    }

    public void replaceAll(UnaryOperator<Type> operator) {
        for(int i = 0; i < size(); ++i) {
            backingArray[i] = operator.apply(backingArray[i]);
        }
    }

    public Type set(int index, Type element) {
        if(index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Type returnVal = backingArray[index];
        backingArray[index] = element;
        return returnVal;
    }

    public int size() {
        return size;
    }

    public void sort(Comparator<? super Type> comparator) {
        Arrays.sort(backingArray, 0, this.size() ,comparator);
    }

    public MyList<Type> subList(int fromIndex, int toIndex) {
        MyList<Type> returnList = new MyArrayList<>();
        if( fromIndex < 0 || fromIndex > toIndex || toIndex >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = fromIndex; i < toIndex; i++) {
            returnList.add(backingArray[i]);
        }
        return returnList;
    }

    public Object[] toArray() {
        Object[] returnArray = new Object[this.size()];
        if (this.size() >= 0) System.arraycopy(backingArray, 0, returnArray, 0, this.size());
        return returnArray;
    }

    public void trimToSize() {
        Type[] newArray = (Type[]) new Object[this.size()];
        if (this.size() >= 0) System.arraycopy(backingArray, 0, newArray, 0, this.size());
        capacity = this.size();
    }
}
