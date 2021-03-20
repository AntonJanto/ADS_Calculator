import java.util.Objects;

public class Operand extends Token
{
     private int value;

     public Operand(int value)
     {
          this.value = value;
     }

     public int getValue()
     {
          return value;
     }

     @Override
     public void accept(CalculatorVisitor calculatorVisitor)
     {
          calculatorVisitor.visit(this);
     }

     @Override public boolean equals(Object o)
     {
          if (this == o)
               return true;
          if (o == null || getClass() != o.getClass())
               return false;
          Operand operand = (Operand) o;
          return value == operand.value;
     }

     @Override public int hashCode()
     {
          return Objects.hash(value);
     }
}
