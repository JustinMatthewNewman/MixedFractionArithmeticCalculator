package IntermediateValues;

import Controller.FragileController;
import math.Equation;
import math.Rational;

/**
 * Displays Intermediate Values.
 * 
 * Dr. David Bernstein, MIT, Princeton, JMU Ph.D., University of Pennsylvania, 1990 M.P.A.,
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
public abstract class IntermediateValues
{
  public static final String PLUS = "+";
  public static final String MINUS = "-";
  public static final String TIMES = "*";
  public static final String DIVIDE = "/";
  public static final String INVERSE = "i";
  public static final String POWER = "^";
  public static final String MEDIANT = "m";
  public static final String FAREY = "f";

  /**
   * Explicit Value Constructor for Intermediate Values.
   * 
   * @param equation the current Equation
   */
  public IntermediateValues(final Equation equation)
  {
    if (FragileController.getSteps() != null)
    {
      FragileController.getSteps().setText(intermediateValues(equation));
    }
  }

  protected abstract String intermediateValues(Equation equation);

  /**
   * Writes the Rational number without null or zero values.
   * 
   * @param a the Rational number
   * @return String of rational
   */
  public String str(final Rational a)
  {
    if (a != null && (a.getElement()[0] == null || a.getElement()[0] == 0))
    {
      return a.toFraction().toString();
    }
    if (a != null && (a.getElement()[1] == null || a.getElement()[1] == 0))
    {
      return a.getElement()[0] + "";
    }
    return a.toString();
  }
}
