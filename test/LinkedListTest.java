import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
	@Test
	public void sizeIsZeroWhenContainsZeroElements()
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		assertEquals(0, linkedList.size());
	}

	@Test
	public void sizeIsOneUponAddingOneElementToFront()
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		linkedList.addToFront(new Operand(5));
		assertEquals(1, linkedList.size());
	}

	@Test
	public void sizeIsManyUponAddingManyElementsToFront()
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		linkedList.addToFront(new Operand(5));
		linkedList.addToFront(new Operand(5));
		linkedList.addToFront(new Operand(5));
		linkedList.addToFront(new Operand(5));
		linkedList.addToFront(new Operand(5));
		assertEquals(5, linkedList.size());
	}

	@Test
	public void isEmptyWhenContainsZeroElements()
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		assertTrue(linkedList.isEmpty());
	}

	@Test
	public void isEmptyWhenContainsOneElement()
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		linkedList.addToFront(new Operand(5));
		assertFalse(linkedList.isEmpty());
	}

	@Test
	public void isEmptyWhenContainsManyElements()
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		linkedList.addToFront(new Operand(5));
		linkedList.addToFront(new Operand(8));
		linkedList.addToFront(new Operator(Operation.ADDITION));
		assertFalse(linkedList.isEmpty());
	}

	@Test
	public void removeFirstReturnsFirstElementInList() throws EmptyListException
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		Operand first= new Operand(5);
		Operand second = new Operand(10);
		Operand third = new Operand(15);
		linkedList.addToFront(third);
		linkedList.addToFront(second);
		linkedList.addToFront(first);
		assertEquals(linkedList.removeFirst(), first);
	}

	@Test
	public void removeFirstRemovesFirstElementAndMovesSecondElementToFirstPosition() throws EmptyListException
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		Operand first= new Operand(5);
		Operand second = new Operand(10);
		Operand third = new Operand(15);
		linkedList.addToFront(third);
		linkedList.addToFront(second);
		linkedList.addToFront(first);
		linkedList.removeFirst();
		assertEquals(linkedList.removeFirst(), second);
	}

	@Test
	public void removeFirstThrowsExceptionWhenLinkedListIsEmpty() throws EmptyListException
	{
		LinkedList<Token> linkedList = new LinkedList<>();
		assertThrows(EmptyListException.class, () -> linkedList.removeFirst());
	}
}
