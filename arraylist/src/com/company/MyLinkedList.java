package com.company;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class MyLinkedList<Type> implements MyList<Type> {

    private class Node {
        Node next;
        Node prev;
        Type data;
        Node(Type data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private class MyItr implements Iterator<Type> {

        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Type next() {
            Type value = current.data;
            current = current.next;
            return value;
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
    private class MyReverseIterator implements Iterator<Type> {
        Node current = tail;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Type next() {
            Type value = current.data;
            current = current.prev;
            return value;
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

    private int size;
    private Node head;
    private Node tail;

    MyLinkedList() {
        head = null;
        tail = null;
    }

    MyLinkedList(MyList<Type> list) {
        this.addAll(list);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Type type) {
        Node node = new Node(type);
        if(this.head == null) {
            this.head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        this.tail = node;
        ++size;
    }

    @Override
    public void addAll(MyList<Type> myList) {
        for(Type type : myList) {
            this.add(type);
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(Type value) {
        Node node = head;
        while (node != null) {
            if(node.data.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean containsAll(MyList<Type> list) {
        for(Type i : list) {
            if(!this.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Type> descendingIterator() {
        return new MyReverseIterator();
    }

    @Override
    public Iterator<Type> iterator() {
        return new MyLinkedList<Type>.MyItr();
    }

    @Override
    public void forEach(Consumer<? super Type> consumer) {
        Node node = head;
        while (node != null) {
            consumer.accept(node.data);
            node = node.next;
        }
    }

    @Override
    public Type get(int index) {
        if (index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    public Type getFirst() {
        if(head == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return head.data;
    }

    public Type getLast() {
        if(tail == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return tail.data;
    }

    public boolean offerFirst(Type value) {
        if(head == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = new Node(value);
        node.next = head;
        head.prev = node;
        head = node;
        return true;
    }

    public boolean offerLast(Type value) {
        if(tail == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = new Node(value);
        tail.next = node;
        node.prev = tail;
        tail = node;
        return true;
    }

    public Type peekFirst() {
        if(head == null) {
            return null;
        }
        return head.data;
    }

    public Type peekLast() {
        if(tail == null) {
            return null;
        }
        return tail.data;
    }

    public Type pollFirst() {
        if(head == null) {
            return null;
        }
        Type data = head.data;
        removeFirst();
        return data;
    }

    public Type pollLast() {
        if(tail == null) {
            return null;
        }
        Type data = tail.data;
        removeLast();
        return data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int indexOf(Type value) {
        Node node = head;
        int result = -1;
        int index = 0;
        while (node != null) {
            if(node.data.equals(value)) {
                result = index;
            }
            node = node.next;
            ++index;
        }
        return result;
    }

    @Override
    public Type remove(int index) {
        if(index >= size()) {
            throw  new ArrayIndexOutOfBoundsException();
        }
        Node node = head;
        for(int i = 0; i < index; ++i) {
            node = node.next;
        }
        if(node == head) {
            head = head.next;
            head.prev = null;
        } else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        --size;
        return node.data;
    }

    @Override
    public void remove(Type value) {
        int index = indexOf(value);
        remove(index);
    }

    @Override
    public boolean removeAll(MyList<Type> list) {
        for(Type i : list) {
            remove(i);
        }
        return true;
    }

    @Override
    public boolean removeIf(Predicate<Type> predicate) {
        Node node = head;
        boolean result = false;
        while (node != null) {
            if(predicate.test(node.data)) {
                result = true;
                remove(node.data);
            }
            node = node.next;
        }
        return result;
    }

    public void removeFirst() {
        head = head.next;
        head.prev = null;
        --size;
    }

    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        --size;
    }

    @Override
    public void replaceAll(UnaryOperator<Type> operator) {
        Node node = head;
        while (node != null) {
            node.data = operator.apply(node.data);
            node = node.next;
        }
    }

    @Override
    public Type set(int index, Type value) {
        if(index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        Type prevValue = node.data;
        node.data = value;
        return prevValue;
    }

    @Override
    public void sort(Comparator<? super Type> comparator) {
        Type[] array =(Type[]) this.toArray();
        Arrays.sort(array, comparator);
        Node node = head;
        for(Type i : array) {
            node.data = i;
            node = node.next;
        }
    }

    @Override
    public MyList<Type> subList(int start, int end) {
        MyList<Type> list = new MyLinkedList<>();
        if( start < 0 || start > end || end >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node begin = head;
        for(int i = 0; i < start; i++) {
            begin = begin.next;
        }
        for(int i = start; i < end; i++) {
            list.add(begin.data);
            begin = begin.next;
        }
        return list;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node node = head;
        int index = 0;
        while (node != null) {
            array[index++] = node.data;
            node = node.next;
        }
        return array;
    }
}
