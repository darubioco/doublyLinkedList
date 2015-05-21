package org.iis.doublylinkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {

  DoublyLinkedList<Integer> list;

  @Before
  public void newEmptyList() {
    list = new DoublyLinkedList<Integer>();
  }

  @Test
  public void isEmptyEmptyList() {
    assertTrue(list.isEmpty());
  }

  @Test
  public void isNotEmptyNonEmptyList() {
    list.add(1);
    assertFalse(list.isEmpty());
  }

  @Test
  public void sizeIsZeroEmptyList() {
    assertEquals(0, list.size());
  }

  @Test
  public void sizeIsOneAfterInsertOne() {
    Integer number = 1;
    list.add(number);
    assertEquals(1, list.size());
  }

  @Test
  public void sizeIsXAfterInsertX() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(numbers.length, list.size());
  }

  @Test(expected = NullPointerException.class)
  public void getFirstThrowNullPointerExceptionEmptyList() {
    list.getFirst();
  }

  @Test(expected = NullPointerException.class)
  public void getLastThrowNullPointerExceptionEmptyList() {
    list.getLast();
  }

  @Test
  public void getFirstReturnsFirst() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.getFirst(), numbers[0]);
  }

  @Test
  public void getLastReturnsLast() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.getLast(), numbers[numbers.length - 1]);
  }

  @Test
  public void addReturnsSameToAddFirstEmptyList() {
    DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
    list.add(1);
    list1.addFirst(1);
    assertEquals(list.size(), list1.size());
    assertEquals(list.get(0), list1.get(0));
  }
}
