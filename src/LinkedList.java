public class LinkedList<T> implements List<T>
{
     private Node<T> head;
     private int size;

     public LinkedList()
     {
          head = null;
          size =  0;
     }

     @Override
     public boolean isEmpty()
     {
          return size < 1;
     }

     @Override
     public int size()
     {
          return size;
     }

     @Override
     public void addToFront(T data)
     {
          head = new Node<>(data, head);
          size++;
     }

     @Override
     public T removeFirst() throws EmptyListException
     {
          if (size == 0) {
               throw new EmptyListException();
          }
          else {
               var first = head.getData();
               head = head.getNext();
               size--;
               return first;
          }
     }
}
