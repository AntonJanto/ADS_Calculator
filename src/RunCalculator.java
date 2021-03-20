import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RunCalculator
{
     public static void main(String[] args)
     {
          Client client = new Client();

          client.evaluateExpression(new ArrayList<Token>(Arrays.asList(
               new Operand(15),
               new Operand(5),
               new Operator(Operation.ADDITION)
          )));
     }
}
