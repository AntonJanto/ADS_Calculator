public class CalculatorVisitor implements Calculator, Visitor
{
     private final LinkedStack<Token> tokenStack;
     private boolean malformed;

     public CalculatorVisitor()
     {
          this.tokenStack = new LinkedStack<>();
          this.malformed = false;
     }

     private void pushOperand(Operand operand)
     {
          tokenStack.push(operand);
     }

     private void performOperation(Operation operation)
     {
          if (tokenStack.isEmpty())
          {
               malformed = true;
               return;
          }

          var right = popOperand();
          var left = popOperand();

          int result;

          switch (operation)
          {
               case ADDITION:
                    result = left + right;
                    break;
               case SUBTRACTION:
                    result = left - right;
                    break;
               case MULTIPLICATION:
                    result = left * right;
                    break;
               case DIVISION:
                    result = left / right;
                    break;
               default:
                    result = 0;
                    malformed = true;
                    break;
          }

          tokenStack.push(new Operand(result));
     }

     private int popOperand()
     {
          if (!tokenStack.isEmpty())
          {
               var top = tokenStack.pop();
               if (top instanceof Operand) {
                    return ((Operand) top).getValue();
               }
          }
          malformed = true;
          return 0;
     }

     @Override
     public int getResult() throws MalformedExpressionException
     {
          if (malformed) {
               malformed = false;
               throw new MalformedExpressionException();
          }
          else {
               var top = popOperand();
               malformed = false;
               return top;
          }
     }

     @Override
     public void visit(Operand operand)
     {
          pushOperand(operand);
     }

     @Override
     public void visit(Operator operator)
     {
          performOperation(operator.getOperation());
     }
}
