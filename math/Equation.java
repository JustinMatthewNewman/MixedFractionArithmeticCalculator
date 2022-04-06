package math;

/**
 * Equation object of fragile. Stores the array of Rational objects as the Equation as
 * well as the operator for the equation.
 * 
 * @author Dr. David Bernstein, MIT, Princeton, JMU Ph.D., University of Pennsylvania, 1990 M.P.A.,
 * Princeton University, 1983 B.A., State University of New York at Binghamton, 1981
 * 
 * @author Justin Matthew Newman, Sagacious Media
 * @author Abdallah Derbala, Sagacious Media
 * @author Easton Rupe, Sagacious Media
 * @author Dylan Ballard, Sagacious Media
 * @author Junior Garmendia, Sagacious Media
 * 
 * @version Sprint3 12/7/2021
 * 
 */
public class Equation
{
  public static final String SPACE = " ";
  public static final String INV = "i";
  private String operator;
  private int mode;
  private int individualFocus;
  private int operandFocus;
  private Rational[] number;


  /**
   * Equation constructor.
   * 
   * 0 = left operand 1 = right operand 2 = result
   */
  public Equation()
  {
    this.operator = SPACE;
    this.individualFocus = 0;
    this.operandFocus = 0;
    this.number = new Rational[3];
    number[0] = new MixedNumber(null, null, null);
    number[1] = new MixedNumber(null, null, null);
    number[2] = new MixedNumber(null, null, null);
  }
  /**
   * Performs the operation then returns the result.
   * 
   * @return Result of computation
   */
  public Rational computation()
  {
    Rational result = null;
    switch (operator)
    {
      case ("+"):
        number[2] = (number[0].addition(number[1]).format());
        result = number[0].addition(number[1]);
        break;
      case ("-"):
        number[2] = (number[0].subtraction(number[1]).format());
        result = number[0].subtraction(number[1]);
        break;
      case ("*"):
        number[2] = (number[0].multiplication(number[1]).format());
        result = number[0].multiplication(number[1]);
        break;
      case ("/"):
        number[2] = (number[0].division(number[1]).format());
        result = number[0].division(number[1]);
        break;
      case ("^"):
        number[2] = (number[0].integerPow(number[1].getElement()[0]).format());
        result =  number[0].integerPow(number[1].getElement()[0]);
        break;
      case ("f"):
        number[2] = (number[0].farey(number[1]).format());
        result =  number[0].farey(number[1]);
        break;
      case ("m"):
        number[2] = (number[0].mediant(number[1]).format());
        result =  number[0].mediant(number[1]);
        break;
      case (INV):
        if (operandFocus == 0)
        {
          number[2] = (number[0].multInv().format());
          result = number[0].multInv();
        } else
        {
          number[2] = (number[1].multInv().format());
          result =  number[1].multInv();
        }
        break;
      default:
        result = number[0];
    }
    return result;
  }

  /**
   * Clears the Equation.
   */
  public void clear()
  {
    number[0].getElement()[0] = null;
    number[0].getElement()[1] = null;
    number[0].getElement()[2] = null;
    number[1].getElement()[0] = null;
    number[1].getElement()[1] = null;
    number[1].getElement()[2] = null;
    number[2].getElement()[0] = null;
    number[2].getElement()[1] = null;
    number[2].getElement()[2] = null;
  }
  /**
   * Sets the mode to the given selection.
   * 
   * @param a10 the desired mode to be in
   */
  public void setMode(final int a10)
  {
    mode = a10;
    setIndividualFocus(mode);
  }

  /**
   * move the individual Focus forward by one or wrap around.
   */
  public void individualFocusForward()
  {
    if (mode == 0)
    {
      individualFocus++;
      if (individualFocus > 2)
      {
        individualFocus = 0;
      }
    } else
    {
      individualFocus++;
      if (individualFocus > 2)
      {
        individualFocus = 1;
      }
    }
  }

  /**
   * move the individual Focus backward by one or wrap around.
   */
  public void individualFocusBackward()
  {
    if (mode == 0)
    {
      individualFocus--;
      if (individualFocus < 0)
      {
        individualFocus = 2;
      }
    } else
    {
      individualFocus--;
      if (individualFocus < 1)
      {
        individualFocus = 2;
      }
    }

  }

  /**
   * set the operand Focus to desired operand position.
   * 
   * @param place The panel you want the focus to be set.\
   */
  public void setOperandFocus(final int place)
  {
    operandFocus = place;
  }
  /**
   * Moves the operand focus forward from the left side to the right side of the equation.
   */
  public void operandFocusForward()
  {
    operandFocus++;
    if (operandFocus > 1)
    {
      operandFocus = 1;
    }
  }

  /**
   * Sets the operator.
   * 
   * @param operator the operator to set
   */
  public void setOperator(final String operator)
  {
    this.operator = operator;
  }

  /**
   * Gets the operator of the equation.
   * 
   * @return operator returns the operator
   */
  public String getOperator()
  {
    return operator;
  }

  /**
   * Get individual focus.
   * 
   * @return individualFocus the focus on a operand
   */
  public int getIndividualFocus()
  {
    return individualFocus;
  }

  /**
   * Set the operand Focus to desired panel position.
   * 
   * @param place The index of the panel position
   */
  public void setIndividualFocus(final int place)
  {
    individualFocus = place;
  }

  /**
   * Gets the operand focus.
   * 
   * @return operandFocus The position in the equation. Left or right side
   */
  public int getOperandFocus()
  {
    return operandFocus;
  }

  /**
   * Gets each Rational object from the array in the Equation.
   * 
   * @return the array of Rational objects
   */
  public Rational[] getNumbers()
  {
    return number;
  }

  /**
   * Prints the equation as a string.
   * 
   * @return equation A String for of the equation
   */
  public String toString()
  {
    String equation = "";

    if (!operator.equals(INV))
    {
      equation += number[0].str() + SPACE + operator + SPACE + number[1].str() + " = "
          + number[2].str();
    }
    return equation;
  }


}
