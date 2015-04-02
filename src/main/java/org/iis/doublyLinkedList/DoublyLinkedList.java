package org.iis.doublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private static class DoublyLinkedNode<E> {
        private E elem;
        private DoublyLinkedNode<E> prev, next;

        public DoublyLinkedNode(E elem, DoublyLinkedNode<E> prev,
                DoublyLinkedNode<E> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    private DoublyLinkedNode<T> firstNode, lastNode;

    public DoublyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    private void insertAfter(DoublyLinkedNode<T> node,
            DoublyLinkedNode<T> newNode) {
        newNode.prev = node;
        newNode.next = node.next;
        if (node.next == null) {
            this.lastNode = newNode;
        } else {
            node.next.prev = newNode;
        }
        node.next = newNode;
    }

    private void insertBefore(DoublyLinkedNode<T> node,
            DoublyLinkedNode<T> newNode) {
        newNode.prev = node.prev;
        newNode.next = node;
        if (node.prev == null) {
            this.firstNode = newNode;
        } else {
            node.prev.next = newNode;
        }
        node.prev = newNode;
    }

    private void insertBeginning(DoublyLinkedNode<T> newNode) {
        if (this.firstNode == null) {
            this.firstNode = newNode;
            this.lastNode = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else {
            this.insertBefore(this.firstNode, newNode);
        }
    }

    private void insertEnd(DoublyLinkedNode<T> newNode) {
        if (this.firstNode == null) {
            this.insertBeginning(newNode);
        } else {
            this.insertAfter(this.lastNode, newNode);
        }
    }

    private void remove(DoublyLinkedNode<T> node) {
        if (node.prev == null) {
            this.firstNode = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            this.lastNode = node.prev;
        } else {
            node.next.prev = node.prev;
        }
    }

    public Iterator<T> iterator() {
        return new ForwardIterator();
    }

    public Iterator<T> forwardIterator() {
        return new ForwardIterator();
    }

    public Iterator<T> backwardIterator() {
        return new BackwardIterator();
    }

    private class ForwardIterator implements Iterator<T> {

        private DoublyLinkedNode<T> current;

        public ForwardIterator() {
            this.current = firstNode;
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T nextElem = this.current.elem;
            this.current = this.current.next;
            return nextElem;
        }

    }

    private class BackwardIterator implements Iterator<T> {

        private DoublyLinkedNode<T> current;

        public BackwardIterator() {
            this.current = lastNode;
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T nextElem = this.current.elem;
            this.current = this.current.prev;
            return nextElem;
        }

    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public T getFirst() {
        return this.firstNode.elem;
    }

    public T getLast() {
        return this.lastNode.elem;
    }

    public void add(T elem) {
        this.insertEnd(new DoublyLinkedNode<T>(elem, null, null));
    }

    public void addFirst(T elem) {
        this.insertBeginning(new DoublyLinkedNode<T>(elem, null, null));
    }

    public void removeFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("Remove from empty list.");
        }
        this.remove(this.firstNode);
    }

    public void removeLast() {
        if (this.isEmpty()) {
            throw new RuntimeException("Remove from empty list.");
        }
        this.remove(this.lastNode);
    }

    public int size() {
        int size = 0;
        Iterator<T> iter = this.iterator();
        while (iter.hasNext()) {
            iter.next();
            size++;
        }
        return size;
    }

    private DoublyLinkedNode<T> getNode(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        int position = 0;
        DoublyLinkedNode<T> node = this.firstNode;
        while (position != index) {
            node = node.next;
            position++;
        }
        return node;
    }

    public T get(int index) {
        return this.getNode(index).elem;
    }

    public void set(int index, T elem) {
        this.getNode(index).elem = elem;
    }

    public int firstIndexOf(T elem) {
        Iterator<T> iter = this.iterator();
        T listElem = null;
        int index = -1;
        while (iter.hasNext() && !elem.equals(listElem)) {
            listElem = iter.next();
            index++;
        }
        if (!elem.equals(listElem)) {
            index = -1;
        }
        return index;
    }

    public int lastIndexOf(T elem) {
        Iterator<T> iter = this.backwardIterator();
        T listElem = null;
        int index = this.size();
        while (iter.hasNext() && !elem.equals(listElem)) {
            listElem = iter.next();
            index--;
        }
        if (!elem.equals(listElem)) {
            index = -1;
        }
        return index;
    }

    public int occurrences(T elem) {
        int occurrences = 0;
        for (T listElem : this) {
            if (listElem.equals(elem)) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public void removeNodeAtIndex(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.remove(this.getNode(index));
    }

    public void removeFirstOccurrence(T elem) {
        this.removeNodeAtIndex(this.firstIndexOf(elem));
    }

    public void removeLastOccurrence(T elem) {
        this.removeNodeAtIndex(this.lastIndexOf(elem));
    }

    public DoublyLinkedList<T> sublist(int fromIndex, int toIndex) {
        DoublyLinkedList<T> list = new DoublyLinkedList<T>();
        for (int i = fromIndex; i <= toIndex; i++) {
            list.add(this.get(i));
        }
        return list;
    }

    public DoublyLinkedList<T> reverseList() {
        DoublyLinkedList<T> list = new DoublyLinkedList<T>();
        Iterator<T> iter = this.backwardIterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        return list;
    }

    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        int i = 0;
        for (T elem : this) {
            array[i] = elem;
            i++;
        }
        return array;
    }

    public String stringFromIterator(Iterator<T> iter) {
        StringBuilder listStringBuilder = new StringBuilder("[");
        while (iter.hasNext()) {
            listStringBuilder.append(iter.next());
            if (iter.hasNext()) {
                listStringBuilder.append(", ");
            }
        }
        listStringBuilder.append("]");
        return listStringBuilder.toString();
    }

    public String toString() {
        return this.stringFromIterator(this.iterator());
    }

    public String forwardString() {
        return this.stringFromIterator(this.forwardIterator());
    }

    public String backwardString() {
        return this.stringFromIterator(this.backwardIterator());
    }
}
