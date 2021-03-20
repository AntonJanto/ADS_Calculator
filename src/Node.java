public class Node<T>
{
     private T data;
     private Node<T> next;

     public Node(T data, Node<T> next)
     {
          this.data = data;
          this.next = next;
     }

     public void setData(T data)
     {
          this.data = data;
     }

     public T getData()
     {
          return data;
     }

     public void setNext(Node<T> node)
     {
          next = node;
     }

     public Node<T> getNext()
     {
          return next;
     }
}
