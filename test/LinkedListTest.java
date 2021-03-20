import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
	private LinkedList<String> linkedList;
	private String first= "a";
	private String second = "b";
	private String third = "c";

	@BeforeEach
	public void setUp()
	{
		linkedList = new LinkedList<>();
	}

	@Test
	public void sizeIsZeroWhenContainsZeroElements()
	{
		assertEquals(0, linkedList.size());
	}

	@Test
	public void sizeIsOneUponAddingOneElementToFront()
	{
		linkedList.addToFront(first);
		assertEquals(1, linkedList.size());
	}

	@Test
	public void sizeIsManyUponAddingManyElementsToFront()
	{
		for (int i = 0; i < 5 ; i++)
		{
			linkedList.addToFront(first);
		}
		assertEquals(5, linkedList.size());
	}

	@Test
	public void isEmptyWhenContainsZeroElements()
	{
		assertTrue(linkedList.isEmpty());
	}

	@Test
	public void isEmptyWhenContainsOneElement()
	{
		linkedList.addToFront(first);
		assertFalse(linkedList.isEmpty());
	}

	@Test
	public void isEmptyWhenContainsManyElements()
	{
		for (int i = 0; i < 5 ; i++)
		{
			linkedList.addToFront(first);
		}
		assertFalse(linkedList.isEmpty());
	}

	@Test
	public void removeFirstReturnsFirstElementInList() throws EmptyListException
	{
		linkedList.addToFront(third);
		linkedList.addToFront(second);
		linkedList.addToFront(first);
		assertEquals(linkedList.removeFirst(), first);
	}

	@Test
	public void removeFirstRemovesFirstElementAndMovesSecondElementToFirstPosition() throws EmptyListException
	{
		linkedList.addToFront(third);
		linkedList.addToFront(second);
		linkedList.addToFront(first);
		linkedList.removeFirst();
		assertEquals(linkedList.removeFirst(), second);
	}

	@Test
	public void removeFirstThrowsExceptionWhenLinkedListIsEmpty()
	{
		assertThrows(EmptyListException.class, () -> linkedList.removeFirst());
	}
}
