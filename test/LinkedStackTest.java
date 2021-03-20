import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest
{
  // String was selected as object type for testing the linked stack.
  private LinkedStack<String> linkedStack;

  // Sample string objects:
  private final String one = "one";
  private final String two = "two";
  private final String three = "three";

  @BeforeEach
  public void beforeEach(){
    linkedStack = new LinkedStack<String>();
  }

  // Testing of all methods

  // isEmpty()
  @Test void isEmpty()
  {
    assertTrue(linkedStack.isEmpty());
  }

  @Test void isNotEmpty()
  {
    linkedStack.push(one);
    assertFalse(linkedStack.isEmpty());
  }

  // push()
  @Test void push()
  {
    linkedStack.push(one);
    linkedStack.push(two);
    linkedStack.push(three);
    //if an exception were to rise up, test fails automatically
  }

  // pop()
  @Test void pop()
  {
    linkedStack.push(one);
    linkedStack.push(two);
    linkedStack.push(three);
    assertEquals(linkedStack.pop(), three);
    assertEquals(linkedStack.pop(), two);
    assertEquals(linkedStack.pop(), one);
  }

  // ZOMBE Tests

  // ZERO
  @Test void zeroTest()
  {
    linkedStack.push(null);
    assertEquals(linkedStack.pop(), null);
  }

  // ONE
  @Test void oneTest()
  {
    linkedStack.push(one);
    assertEquals(linkedStack.pop(), one);
  }
  // MANY
  @Test void manyTest()
  {
    linkedStack.push(one);
    linkedStack.push(two);
    linkedStack.push(three);
    assertEquals(linkedStack.pop(), three);
    assertEquals(linkedStack.pop(), two);
    assertEquals(linkedStack.pop(), one);
  }
  // BOUNDARIES

  @Test void lowerBound()
  {
    assertThrows(EmptyStackException.class, () -> {
      linkedStack.pop();
    });
  }
  // (upper bound is not possible to test because it can go to infinity)

  // Exceptions

  // EmptyStackException
  @Test void emptyStackException()
  {
    linkedStack.push(one);
    linkedStack.push(two);
    linkedStack.push(three);

    linkedStack.pop();
    linkedStack.pop();
    linkedStack.pop();

    assertThrows(EmptyStackException.class, () -> {
      linkedStack.pop();
    });
  }
}