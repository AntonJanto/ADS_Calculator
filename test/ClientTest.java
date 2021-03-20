import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

          ArrayList<Token> tokens = generateTokens(15, 20, Operation.ADDITION);

          var result = client.evaluateExpression(tokens);
          assertEquals(35, result);
     }

     private ArrayList<Token> generateTokens(Object... objects)
     {
          ArrayList<Token> tokenList = new ArrayList<>();
          for (Object obj : objects) {
               if (obj instanceof Integer)
                    tokenList.add(new Operand((Integer) obj));
               else if (obj instanceof Operation)
                    tokenList.add(new Operator((Operation) obj));
          }
          return tokenList;
     }

}