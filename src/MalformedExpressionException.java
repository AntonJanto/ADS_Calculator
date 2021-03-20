public class MalformedExpressionException extends Exception
{
     public MalformedExpressionException()
     {
          super("Malformed expression.\n");
     }

     public MalformedExpressionException(String message)
     {
          super("Malformed expression:\n\t" + message);
     }
}
