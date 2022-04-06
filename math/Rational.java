package math;

/**
 * Arithmetic Class.
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
 **/
public abstract class Rational
{
  protected String dBZE = "Divide by 0 error";
  protected String invalDen = "invalid denominator";

  protected Integer[] element;



  /**
   * Explicit Value Constructor for the Rational class.
   * 
   * @param unit the whole number
   * @param num the numerator of the Denominator
   * @param den the denominator of the Fraction
   *
   **/
  public Rational(final Integer unit, final Integer num, final Integer den)
  {
    this.element = new Integer[3];
    this.element[0] = unit;
    this.element[1] = num;
    this.element[2] = den;
  }

  /**
   * The constructor for the Rational class.
   * 
   * @param text a String array containing the unit, numerator, and denominator
   */
  public Rational(final String[] text) 
  {
    this.element = new Integer[3];
    String[] userInputArray = text;
    if (userInputArray.length == 3)// is mixed fraction
    { 
      this.element[0] = Integer.parseInt(userInputArray[0]);
      this.element[1] = Integer.parseInt(userInputArray[1]);
      this.element[2] = Integer.parseInt(userInputArray[2]);
    }
    else if (userInputArray.length == 2) // is proper or improper fraction
    { 
      this.element[0] = null;
      this.element[1] = Integer.parseInt(userInputArray[0]);
      this.element[2] = Integer.parseInt(userInputArray[1]);

    } 
    else if (userInputArray.length == 1)
    {
      this.element[0] = Integer.parseInt(userInputArray[0]);
      this.element[1] = null;
      this.element[2] = null;
    }

  }
  /**
   * The constructor for the Rational class.
   * 
   * 
   * @param num the numerator of the Denominator
   * @param den the denominator of the Fraction
   *
   **/
  public Rational(final Integer num, final Integer den)
  {
    this.element = new Integer[3];
    this.element[0] = null;
    this.element[1] = num;
    this.element[2] = den;
  }

  /**
   * The constructor for the Rational class.
   * 
   * @param unit the whole number
   *
   **/
  public Rational(final Integer unit)
  {
    this.element = new Integer[3];
    this.element[0] = unit;
    this.element[1] = null;
    this.element[2] = null;
  }

  /**
   * Gets the array of elements.
   * 
   * @return the element
   */
  public Integer[] getElement()
  {
    return element;
  }
  /**
   * Writes the Rational as a string without null or zero values.
   * 
   * @return the string accounting for null or zero values
   */
  public String str()
  {
    if (this != null && (element[0] == null || element[0] == 0))
    {
      return toFraction().toString();
    }
    if (this != null && (element[1] == null || element[1] == 0))
    {
      return element[0] + "";
    }
    return toString();
  }

  /**
   * Converts a Rational to a fraction.
   * 
   * @return converts to a fraction
   */
  public abstract Rational toFraction();

  /**
   * Converts a Rational to a mixed number.
   * 
   * @return converts to a mixed number
   */
  public abstract Rational toMixedNumber();

  /**
   * Performs the multiplication for the Rational number.
   * 
   * @param number
   * @return result of the multiplication method
   * @throws NullPointerException
   */
  public abstract Rational multiplication(final Rational number) throws NullPointerException;

  /**
   * Performs the division for the Rational number.
   * 
   * @param number
   * @return result of the division method
   */
  public abstract Rational division(final Rational number);

  /**
   * Performs the addition for the Rational number.
   * 
   * @param number
   * @return result of the addition method
   * @throws NullPointerException
   */
  public abstract Rational addition(final Rational number) throws NullPointerException;

  /**
   * Performs the subtraction for the Rational number.
   * 
   * @param number
   * @return result of the subtraction method
   */
  public abstract Rational subtraction(final Rational number);

  /**
   * Performs the integer power for the Rational number.
   * 
   * @param exp
   * @return result of integer power method
   */
  public abstract Rational integerPow(final Integer exp);

  /**
   * Formats the Rational number.
   * 
   * @return formats to a fraction
   */
  public abstract Rational format();

  /**
   * Converts to the common denominator.
   * 
   * @param common the common denominator
   * @return converts common denominator
   */
  public abstract Fraction convert(Integer common);

  /**
   * Negates the value.
   */
  public abstract void negate();

  /**
   * Performs the multiplicative inverse.
   * 
   * @return returns multiplicative inverse of Rational Number.
   */
  public abstract Rational multInv();

  /**
   * Performs the mediant operation.
   * 
   * @param b the other Rational number
   * @return fraction as a string
   */
  protected abstract Rational mediant(Rational b);
  
  /**
   * Finds the next farey number in the sequence.
   * 
   * @param b the other Rational
   * @return the next farey number in the sequence
   */
  protected abstract Rational farey(Rational b);
  
  /**
   * Checks if the enter button was used before an operation button was used.
   * 
   * @return if the enter button was used before an operation button was used
   */
  public abstract boolean entered();
  
  /**
   * Reduces a fraction.
   * 
   * @return the reduced fraction
   */
  protected abstract Rational reduce();
  
  /**
   * Turns a Rational Number to a String.
   * 
   * @return A String representation of a Rational Number
   */
  @Override
  public abstract String toString();
}
