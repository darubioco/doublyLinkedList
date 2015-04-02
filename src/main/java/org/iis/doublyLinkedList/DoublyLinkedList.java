package org.iis.doublyLinkedList;

public class DoublyLinkedList<T> {
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

    public void insertAfter(DoublyLinkedNode<T> node,
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

    public void insertBefore(DoublyLinkedNode<T> node,
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

    public void insertBeginning(DoublyLinkedNode<T> newNode) {
        if (this.firstNode == null) {
            this.firstNode = newNode;
            this.lastNode = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else {
            this.insertBefore(this.firstNode, newNode);
        }
    }

    public void insertEnd(DoublyLinkedNode<T> newNode) {
        if (this.firstNode == null) {
            this.insertBeginning(newNode);
        } else {
            this.insertAfter(this.lastNode, newNode);
        }
    }

    public void remove(DoublyLinkedNode<T> node) {
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
}
