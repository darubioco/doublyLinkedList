package org.iis.doublyLinkedList;

import java.util.Arrays;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.add(3);
        list.add(8);
        list.add(5);
        list.add(4);
        list.add(-5);
        System.out.println("List: " + list);
        System.out.println("Reversed list: " + list.backwardString());
        System.out.println("First: " + list.getFirst() + ", Last: "
                + list.getLast());
        list.removeFirst();
        System.out.println("List (removed first): " + list);
        list.removeLast();
        System.out.println("List (removed last): " + list);
        System.out.println("Is list empty? " + list.isEmpty());
        DoublyLinkedList<Character> list2 = new DoublyLinkedList<Character>();

        System.out.println("\nList2: " + list2);
        System.out.println("Is list2 empty? " + list2.isEmpty());
        list2.addFirst('a');
        list2.addFirst('b');
        list2.addFirst('h');
        System.out.println("List2: " + list2 + " Size: " + list2.size());
        System.out.println("First index of 'a': " + list2.firstIndexOf('a'));
        list2.set(2, 'x');
        System.out.println("List2 (element at index 2 changed to 'x'): "
                + list2);
        list2.removeNodeAtIndex(1);
        System.out.println("List2 (removed node at index 1): " + list2);

        System.out.println("\nArray from list: "
                + Arrays.toString(list.toArray()));
        list.add(2);
        list.add(2);
        list.addFirst(2);
        System.out
                .println("List (added element 2 twice, and added 2 in first place): "
                        + list);
        System.out.println("Occurrences of 2: " + list.occurrences(2));
        System.out.println("First index of 2: " + list.firstIndexOf(2));
        System.out.println("Last index of 2: " + list.lastIndexOf(2));
        list.removeFirstOccurrence(2);
        list.removeLastOccurrence(2);
        System.out.println("List (removed first and last occurrences of 2): "
                + list);
        System.out.println("Sublist (index 0 to 2) from list: "
                + list.sublist(0, 2));

        DoublyLinkedList<Integer> list3 = list.reverseList();
        System.out.println("\nList3 (reversed from list): " + list3);
        list3.removeFirst();
        System.out.println("List3 (removed first): " + list3);
        System.out.println("Element at index 1: " + list.get(1));
        try {
            System.out.println("Trying to get element at index 4");
            System.out.println("Element at index 4: " + list.get(4));
        } catch (RuntimeException e) {
            System.out.println("Exception thrown because of illegal index.");
        }
        System.out.println("First index of 1: " + list.firstIndexOf(1));
    }

}
