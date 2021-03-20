import java.util.ArrayList;

public class TestTools
{
     static ArrayList<Token> generateTokens(Object... tokens)
     {
          ArrayList<Token> tokenList = new ArrayList<>();
          for (Object obj : tokens) {
               if (obj instanceof Integer)
                    tokenList.add(new Operand((Integer) obj));
               else if (obj instanceof Operation)
                    tokenList.add(new Operator((Operation) obj));
          }
          return tokenList;
     }

     static void calculatorAcceptTokens(CalculatorVisitor calculatorVisitor, ArrayList<Token> tokens)
     {
          for (Token token : tokens) {
               token.accept(calculatorVisitor);
          }
     }
}
