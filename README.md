# doublyLinkedList
Java implementation of a doubly linked list using Maven and SonarQube.
Basic algorithms from [Wikipedia specification](http://en.wikipedia.org/wiki/Doubly_linked_list).

#### Nested Class Summary
    private class BackwardIterator 
    private static class DoublyLinkedNode<E> 
    private class ForwardIterator 

#### Field Summary
    - DoublyLinkedNode<T> firstNode 
    - DoublyLinkedNode<T> lastNode 
    
#### Constructor Summary
    + DoublyLinkedList()

#### Method Summary

    + void add(T elem) 
    + void addFirst(T elem) 
    + Iterator<T> backwardIterator() 
    + String backwardString() 
    + int firstIndexOf(T elem) 
    + Iterator<T> forwardIterator() 
    + String forwardString() 
    + T get(int index) 
    + T getFirst() 
    + T getLast() 
    - DoublyLinkedNode<T> getNode(int index) 
    - void insertAfter(DoublyLinkedNode<T> node, DoublyLinkedNode<T> newNode) 
    - void insertBefore(DoublyLinkedNode<T> node, DoublyLinkedNode<T> newNode) 
    - void insertBeginning(DoublyLinkedNode<T> newNode) 
    - void insertEnd(DoublyLinkedNode<T> newNode) 
    + boolean isEmpty() 
    + Iterator<T> iterator() 
    + int lastIndexOf(T elem) 
    + int occurrences(T elem) 
    - void remove(DoublyLinkedNode<T> node) 
    + void removeFirst() 
    + void removeFirstOccurrence(T elem) 
    + void removeLast() 
    + void removeLastOccurrence(T elem) 
    + void removeNodeAtIndex(int index) 
    + DoublyLinkedList<T> reverseList() 
    + void set(int index, T elem) 
    + int size() 
    + String stringFromIterator(Iterator<T> iter) 
    + DoublyLinkedList<T> sublist(int fromIndex, int toIndex) 
    + Object[] toArray() 
    + String toString() 
    
Introducción a la Ingeniería del Software - **David Rubio Cortés (SW-A)**
