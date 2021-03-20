public class EmptyListException extends Exception
{
     public EmptyListException()
     {
          super("The list is empty.");
     }

     public EmptyListException(String message, Throwable cause)
     {
          super("The list is empty." + message, cause);
     }
}
