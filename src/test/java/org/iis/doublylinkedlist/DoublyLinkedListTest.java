package org.iis.doublylinkedlist;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

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
      list.addFirst(number);
    }
    assertEquals(numbers.length, list.size());
  }

  @Test(expected = NullPointerException.class)
  public void getFirstThrowsNullPointerExceptionEmptyList() {
    list.getFirst();
  }

  @Test(expected = NullPointerException.class)
  public void getLastThrowsNullPointerExceptionEmptyList() {
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

  @Test(expected = NoSuchElementException.class)
  public void removeFirstThrowsNoSuchElementExceptionEmptyList() {
    list.removeFirst();
  }

  @Test(expected = NoSuchElementException.class)
  public void removeLastThrowsNoSuchElementExceptionEmptyList() {
    list.removeLast();
  }

  @Test
  public void removeFirstDecreasesSizeInOne() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    int listSize = list.size();
    list.removeFirst();
    assertEquals(listSize - 1, list.size());
  }

  @Test
  public void removeLastDecreasesSizeInOne() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    int listSize = list.size();
    list.removeLast();
    assertEquals(listSize - 1, list.size());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getWithNegativePositionThrowsIndexOutOfBoundsException() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    list.get(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getWithPositionGreaterThanSizeThrowsIndexOutOfBoundsException() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    list.get(10);
  }

  @Test
  public void getElementWithPositionZeroEqualsToGetFirst() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.getFirst(), list.get(0));
  }
  
  @Test
  public void getElementWithPositionSizeMinusOneEqualsToGetLast() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.getLast(), list.get(list.size()-1));
  }
  
  @Test(expected = IndexOutOfBoundsException.class)
  public void setWithNegativePositionThrowsIndexOutOfBoundsException() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    list.set(-1, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void setWithPositionGreaterThanSizeThrowsIndexOutOfBoundsException() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    list.set(10, 0);
  }
  
  @Test
  public void setElementWithPositionXChangesElementAtPositionX() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    list.set(1, 0);
    assertEquals(list.get(1), Integer.valueOf(0));
  }
  
  @Test
  public void firstIndexOfElementReturnsCorrectPosition(){
    Integer[] numbers = {1, 0, 3, 0, 5, 0};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.firstIndexOf(0), 1);
  }
  
  @Test
  public void firstIndexOfElementNotPresentReturnsMinusOne(){
    Integer[] numbers = {1, 2, 3, 4, 5};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.firstIndexOf(0), -1);
  }
  
  @Test
  public void lastIndexOfElementReturnsCorrectPosition(){
    Integer[] numbers = {1, 0, 3, 0, 5, 0};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.lastIndexOf(0), 5);
  }
  
  @Test
  public void lastIndexOfElementNotPresentReturnsMinusOne(){
    Integer[] numbers = {1, 2, 3, 4, 5};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.lastIndexOf(0), -1);
  }
  
  @Test
  public void occurrencesOfElementReturnsCorrectNumberOfOccurrences(){
    Integer[] numbers = {1, 0, 3, 0, 5, 0};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.occurrences(0), 3);
  }
  
  @Test
  public void occurrencesOfElementNotPresentReturnsZero(){
    Integer[] numbers = {1, 2, 3, 4, 5};
    for (Integer number : numbers) {
      list.add(number);
    }
    assertEquals(list.occurrences(0), 0);
  }
  
  @Test(expected = IndexOutOfBoundsException.class)
  public void removeNodeAtIndexThrowsNoSuchElementExceptionEmptyList() {
    list.removeNodeAtIndex(0);
  }
  
  @Test(expected = IndexOutOfBoundsException.class)
  public void removeNodeAtNegativeIndexThrowsNoSuchElementException() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    list.removeNodeAtIndex(-2);
  }

  @Test
  public void removeNodeAtIndexDecreasesSizeInOne() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    int listSize = list.size();
    list.removeNodeAtIndex(0);
    assertEquals(listSize - 1, list.size());
  }
  
  @Test(expected = IndexOutOfBoundsException.class)
  public void removeFirstOccurrenceOfElementNotPresentThrowsNoSuchElementException() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    list.removeFirstOccurrence(0);
  }
  
  @Test
  public void removeFirstOccurrenceDecreasesSizeInOne() {
    Integer[] numbers = {1, 0, 3, 0, 5, 0};
    for (Integer number : numbers) {
      list.add(number);
    }
    int listSize = list.size();
    list.removeFirstOccurrence(0);
    assertEquals(listSize - 1, list.size());
  }
  
  @Test(expected = IndexOutOfBoundsException.class)
  public void removeLastOccurrenceOfElementNotPresentThrowsNoSuchElementException() {
    Integer[] numbers = {1, 2, 3, 4};
    for (Integer number : numbers) {
      list.add(number);
    }
    list.removeLastOccurrence(0);
  }
  
  @Test
  public void removeLastOccurrenceDecreasesSizeInOne() {
    Integer[] numbers = {1, 0, 3, 0, 5, 0};
    for (Integer number : numbers) {
      list.add(number);
    }
    int listSize = list.size();
    list.removeLastOccurrence(0);
    assertEquals(listSize - 1, list.size());
  }
  
  @Test
  public void sublistFromZeroToSizeMinusOneReturnsSameList(){
    Integer[] numbers = {1, 0, 3, 0, 5, 0};
    for (Integer number : numbers) {
      list.add(number);
    }
    DoublyLinkedList<Integer> list1 = list.sublist(0, list.size()-1);
    assertEquals(list.size(), list1.size());
  }
  
  @Test
  public void sublistWithSizeOneReturnsCorrectElement(){
    Integer[] numbers = {1, 0, 3, 0, 5, 0};
    for (Integer number : numbers) {
      list.add(number);
    }
    DoublyLinkedList<Integer> list1 = list.sublist(0, 0);
    assertEquals(list.get(0), list1.get(0));
  }
  
}
