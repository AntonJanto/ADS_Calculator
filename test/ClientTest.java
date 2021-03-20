import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest
{
     private Client client;

     @BeforeEach
     private void setUp()
     {
          client = new Client();
     }

     @Test
     public void zeroTokens()
     {
          ArrayList<Token> tokens = TestTools.generateTokens();
          var result = client.evaluateExpression(tokens);

          assertEquals(0, result);
     }

     @Test
     public void oneTokenOperand() {
          ArrayList<Token> tokens = TestTools.generateTokens(15);
          var result = client.evaluateExpression(tokens);

          assertEquals(15, result);
     }


     @Test
     public void oneTokenOperator() {
          ArrayList<Token> tokens = TestTools.generateTokens(Operation.ADDITION);
          var result = client.evaluateExpression(tokens);

          assertEquals(0, result);
     }

     //As there are no operations the expected result is the last operand
     @Test
     public void manyTokensOperands() {
          var tokens = TestTools.generateTokens(15, 20, 25);
          var result = client.evaluateExpression(tokens);

          assertEquals(25, result);
     }

     @Test
     public void manyTokensOperators() {
          var tokens = TestTools.generateTokens(Operation.ADDITION, Operation.MULTIPLICATION);
          var result = client.evaluateExpression(tokens);

          //Client handles errors and solves them with returning 0
          assertEquals(0, result);
     }

     @Test
     public void manyTokensOperandsAndOperators() {
          var tokens = TestTools.generateTokens(20, 25, Operation.ADDITION, 15, Operation.SUBTRACTION);
          var result = client.evaluateExpression(tokens);

          assertEquals(30, result);
     }
}