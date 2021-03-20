import java.util.ArrayList;

public class Client
{
     private final CalculatorVisitor calculator;

     public Client()
     {
          calculator = new CalculatorVisitor();
     }

     public int evaluateExpression(ArrayList<Token> tokenList)
     {
          for (Token token : tokenList) {
               token.accept(calculator);
          }

          try {
               var result = calculator.getResult();
               System.out.println(result);
               return result;
          }
          catch (MalformedExpressionException e) {
               System.out.println(e.getMessage());
               return -1;
          }
     }
}
