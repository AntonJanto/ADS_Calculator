import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorVisitorTest
{
     CalculatorVisitor calculatorVisitor;

     @BeforeEach
     void setUp()
     {
          calculatorVisitor = new CalculatorVisitor();
     }

     @Test
     public void addZeroTokens() {
          try {
               var result = calculatorVisitor.getResult();
               assertEquals(0, result);
          }
          catch (MalformedExpressionException e) {
               fail();
          }
     }

     @Test
     public void oneTokenOperand() {
          ArrayList<Token> tokens = TestTools.generateTokens(15);
          TestTools.calculatorAcceptTokens(calculatorVisitor, tokens);
          try {
               var result = calculatorVisitor.getResult();
               assertEquals(15, result);
          }
          catch (MalformedExpressionException e) {
               fail();
          }
     }

     @Test
     public void oneTokenOperator() {
          ArrayList<Token> tokens = TestTools.generateTokens(Operation.ADDITION);
          TestTools.calculatorAcceptTokens(calculatorVisitor, tokens);
          assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
     }

     //As there are no operations the expected result is the last operand
     @Test
     public void manyTokensOperands() {
          ArrayList<Token> tokens = TestTools.generateTokens(15, 25, 30);
          TestTools.calculatorAcceptTokens(calculatorVisitor, tokens);
          try {
               var result = calculatorVisitor.getResult();
               assertEquals(30, result);
          }
          catch (MalformedExpressionException e) {
               fail();
          }
     }

     @Test
     public void manyTokensOperators() {
          var tokens = TestTools.generateTokens(Operation.ADDITION, Operation.MULTIPLICATION);
          TestTools.calculatorAcceptTokens(calculatorVisitor, tokens);
          assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
     }

     @Test
     public void manyTokensOperandsAndOperators() {
          var tokens = TestTools.generateTokens(20, 25, Operation.ADDITION, 15, Operation.SUBTRACTION);
          TestTools.calculatorAcceptTokens(calculatorVisitor, tokens);
          try {
               var result = calculatorVisitor.getResult();
               assertEquals(30, result);
          }
          catch (MalformedExpressionException e) {
               fail();
          }
     }
}