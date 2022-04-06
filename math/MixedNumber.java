package math;

/**
 * MixedNumber Class. Performs arithmetic for Mixed Numbers.
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
 * 
 * @author EastonRupe
 *
 **/
public class MixedNumber extends Rational
{

  /**
   * The constructor for the MixedNumber object.
   * 
   * @param unit the whole number associated with this MixedNumber
   * @param num the numerator of the ImproperFraction
   * @param den the denominator of the ImproperFraction
   *
   **/
  public MixedNumber(final Integer unit, final Integer num, final Integer den)
  {
    super(unit, num, den);
  }
  /**
   * The constructor for the MixedNumber object when user is using copy and paste.
   * @param userInputArray a string array with each number copied.
   */
  public MixedNumber(final String[] userInputArray) 
  {
    super(userInputArray);
  }
  /**
   * Converts the Mixed Number to a fraction.
   */
  @Override
  public Rational toFraction()
  {
    Integer num = this.element[1];
    Integer den = this.element[2];
    Integer unit = this.element[0];

    if (unit == null && den == null && num == null)
    {
      return new WholeNumber(0);
    }

    if (num == null || den == null)
    {
      return new Fraction(unit, 1);
    }
    if (unit == null)
    {
      return new Fraction(num, den);
    }

    Fraction frac = new Fraction(0, 0);
    if (unit < 0)
    {
      unit *= -1;
      num = num + (unit * den);
      num *= -1;
      frac = new Fraction(num, den);
    } else
    {
      num = num + (unit * den);
      frac = new Fraction(num, den);
    }
    return frac;
  }

  @Override
  public Rational toMixedNumber()
  {
    return this;
  }

  @Override
  public Rational format()
  {
    if (this.element[1] == 0)
    {
      if (element[0] != null)
      {
        return new WholeNumber(element[0] + 1);
      } else
      {
        return new WholeNumber(1);
      }
    } else
    {
      return this;
    }
  }


  /**
   * Multiplication for the MixedNumber class, converts to improper fraction, does the 
   * multiplication, then
   * converts back to a MixedNumber.
   * 
   * @param number to multiply to current object
   * @return the resulting Rational number
   */
  @Override
  public Rational multiplication(final Rational number) throws NullPointerException
  {
    return this.toFraction().multiplication(number.toFraction());

  }

  /**
   * Division for the MixedNumber class, converts to improper fraction, does the division, then
   * converts back to a MixedNumber.
   * 
   * @param number to division to current object
   * @return the resulting fraction
   */
  @Override
  public Rational division(final Rational number)
  {
    return this.toFraction().division(number.toFraction());
  }

  /**
   * Addition for the MixedNumber class, converts to improper fraction, does the addition,
   * then converts back to a MixedNumber.
   * 
   * @param number to add to current object
   * @return the resulting fraction
   */
  @Override
  public Rational addition(final Rational number) throws NullPointerException
  {
    return this.toFraction().addition(number.toFraction());
  }

  /**
   * Subtraction for the MixedNumber class, converts to improper fraction, does the subtraction,
   * then converts back to a MixedNumber.
   * 
   * @param number to subtract to current object
   * @return the resulting fraction
   */
  @Override
  public Rational subtraction(final Rational number)
  {
    return this.toFraction().subtraction(number.toFraction());
  }

  /**
   * Raising by a power for the Mixed number class, converts to improper fraction, rasies numerator
   * and denominator by an integer exponent, converts back to a MixedNumber.
   * 
   * @param exp The integer exponent
   * @return The resulting fraction
   */
  public Rational integerPow(final Integer exp)
  {
    return this.toFraction().integerPow(exp);
  }

  @Override
  public Fraction convert(final Integer common)
  {
    return null;
  }

  @Override
  public void negate()
  {
    if (element[0] == null)
    {
      element[1] = (element[1] * -1);
    } else
    {
      element[0] = (element[0] * -1);
    }
  }

  @Override
  public Rational multInv()
  {
    Rational a = this.toFraction();
    return a.multInv();
  }

  @Override
  protected Rational mediant(final Rational b)
  {
    return this.toFraction().mediant(b.toFraction());
  }

  @Override
  protected Rational farey(final Rational b)
  {
    return this.toFraction().farey(b.toFraction());
  }

  /**
   * Returns true if the components of the mixed number have been entered.
   */
  @Override
  public boolean entered()
  {
    if (element[0] == null && element[1] == null && element[2] == null)
    {
      return false;
    }
    if (element[0] != null && element[1] != null && element[2] == null)
    {
      return false;
    }
    if (element[0] != null && element[1] == null && element[2] != null)
    {
      return false;
    }
    return true;
  }

  @Override
  protected Rational reduce()
  {
    return null;
  }

  /**
   * The toString method of the class.
   * 
   * the MixedNumber to be converted into a string
   *
   * @return the final String version of the MixedNumber
   *
   **/
  public String toString()
  {
    return element[0] + " " + element[1] + "/" + element[2];
  }
}
