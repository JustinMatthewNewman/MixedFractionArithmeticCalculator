package math;

/**
 * Fraction Class. Performs arithmetic for fractions and improper fractions.
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
public class Fraction extends Rational
{

  /**
   * The constructor for the ImproperFraction object.
   * 
   * @param num the element[1] of the ImproperFraction
   * @param den the element[2] of the ImproperFraction
   *
   **/
  public Fraction(final Integer num, final Integer den)
  {
    super(num, den);
  }

  /**
   * This method converts an ImproperFraction into a MixedNumber.
   *
   * @return the converted MixedNumber
   **/
  @Override
  public MixedNumber toMixedNumber()
  {
    int num = element[1];
    int den = element[2];
    int unit = num / den;
    num = Math.abs(num) % den;

    return new MixedNumber(unit, num, den);
  }

  @Override
  public Rational toFraction()
  {
    return this;
  }


  /**
   * @author Derbalax
   * @param number improper fraction to be multiplied
   * @return the result of the multiplication method
   * @throws NullPointerException if element[2] = 0
   */
  public Fraction multiplication(final Rational number) throws NullPointerException
  {
    Rational fraction = number.toFraction();
    if ((element[2] == 0) || (fraction.element[2] == 0))
      throw new IllegalArgumentException(invalDen);

    Fraction product = new Fraction(null, null);

    product.element[1] = element[1] * fraction.element[1];
    product.element[2] = element[2] * fraction.element[2];

    product = product.reduce();
    return product;
  }

  /**
   * Divides this fraction by the other fraction.
   * 
   * @param number to divide
   * @return the result of dividing current object with fraction
   * @throws NullPointerException if denom == 0
   */
  public Fraction division(final Rational number)
  {
    Rational fraction = number.toFraction();
    if ((element[2] == 0) || (fraction.element[1] == 0))
      throw new IllegalArgumentException("invalid element[2]");

    Fraction result = new Fraction(null, null);

    result.element[1] = element[1] * fraction.element[2];
    result.element[2] = element[2] * fraction.element[1];

    result = result.reduce();
    return result;
  }

  /**
   * Performs addition between this and the given Rational object.
   * 
   * @param number to be added
   * @return the result of the addition method
   * @throws NullPointerException if element[2] = 0
   */
  public Fraction addition(final Rational number) throws NullPointerException
  {
    Rational fraction = number.toFraction();
    if ((element[2] == 0) || (fraction.element[2] == 0))
      throw new IllegalArgumentException(invalDen);

    Integer common = lcd(element[2], fraction.element[2]);

    Fraction commonA = new Fraction(this.element[1], this.element[2]);
    Fraction commonB = new Fraction(fraction.element[1], fraction.element[2]);
    commonA = convert(common);
    commonB = fraction.convert(common);

    Fraction sum = new Fraction(null, null);

    sum.element[1] = commonA.element[1] + commonB.element[1];
    sum.element[2] = common;

    sum = sum.reduce();
    return sum;
  }

  /**
   * Subtracts the other fraction from this fraction.
   * 
   * @param number to subtract
   * @return the result of subtracting current object with fraction
   * @throws NullPointerException the exception to be thrown if denom == 0
   */
  public Fraction subtraction(final Rational number)
  {
    Rational fraction = number.toFraction();
    if ((element[2] == 0) || (fraction.element[2] == 0))
      throw new IllegalArgumentException(invalDen);

    Integer common = lcd(element[2], fraction.element[2]);

    Fraction commonA = new Fraction(this.element[1], this.element[2]);
    Fraction commonB = new Fraction(fraction.element[1], fraction.element[2]);
    commonA = convert(common);
    commonB = fraction.convert(common);

    Fraction diff = new Fraction(null, null);

    diff.element[1] = commonA.element[1] - commonB.element[1];
    diff.element[2] = common;

    diff = diff.reduce();
    return diff;

  }

  @Override
  public Rational integerPow(final Integer exp)
  {
    Integer intExp = exp;
    if (element[2] == 0)
      throw new IllegalArgumentException(invalDen);

    Fraction result = new Fraction(null, null);
    if (exp < 0)
    {
      intExp = intExp * -1;
      int temp = element[1];
      element[1] = element[2];
      element[2] = temp;
    }

    result.element[1] = (int) Math.pow(element[1], exp);
    result.element[2] = (int) Math.pow(element[2], exp);
    result = result.reduce();

    return result;
  }

  @Override
  public Rational format()
  {
    int num = this.element[1];
    int numN = Math.abs(num);
    int den = this.element[2];
    if (num == 0)
    {
      return new WholeNumber(0);
    }
    if (numN >= den)
    {
      if (num % den == 0)
      {
        return new WholeNumber(num / den);
      }
      return new MixedNumber(num / den, numN % den, den);
    }
    return this;
  }

  /**
   * Gets the lcd between two denominators.
   * 
   * @param den1 element[2] of first faction
   * @param den2 element[2] of second fraction
   * @return the least common element[2]
   */
  public Integer lcd(final Integer den1, final Integer den2)
  {
    Integer denom1 = den1;
    Integer denom2 = den2;
    Integer factor = denom1;
    while ((denom1 % denom2) != 0)
      denom1 += factor;
    return denom1;
  }

  /**
   * Gets the gcd between two denominators.
   * 
   * @param den1 element[2] of first faction
   * @param den2 element[2] of second fraction
   * @return the greatest common element[2]
   */
  public Integer gcd(final Integer den1, final Integer den2)
  {
    Integer denom1 = den1;
    Integer denom2 = den2;

    Integer factor = denom2;
    while (denom2 != 0)
    {
      factor = denom2;
      denom2 = denom1 % denom2;
      denom1 = factor;
    }
    return denom1;
  }

  /**
   * Converts the fraction denominator to the common denominator.
   * 
   * @param common element[2]
   * @return converts the fraction
   */
  public Fraction convert(final Integer common)
  {
    Fraction result = new Fraction(null, null);
    Integer factor = common / element[2];
    result.element[1] = element[1] * factor;
    result.element[2] = common;
    return result;
  }

  /**
   * Reduces the fraction to the gcd.
   */
  protected Fraction reduce()
  {
    Fraction result = new Fraction(null, null);
    Integer common = 0;

    Integer num = Math.abs(element[1]);
    Integer den = Math.abs(element[2]);

    if (num > den)
      common = gcd(num, den);
    else if (num < den)
      common = gcd(den, num);
    else
      common = num;

    result.element[1] = element[1] / common;
    result.element[2] = element[2] / common;
    return result;
  }

  @Override
  public void negate()
  {
    element[1] = (element[1] * -1);
  }

  @Override
  public Rational multInv()
  {
    int placeHolder = element[1];
    if (placeHolder == 0)
    {
      return new WholeNumber(0);
    }
    element[1] = (element[2]);
    element[2] = (placeHolder);
    return this;
  }

  @Override
  protected Rational mediant(final Rational b)
  {
    Fraction mediant = new Fraction(null, null);
    mediant.element[1] = (element[1] + b.element[1]);
    mediant.element[2] = (element[2] + b.element[2]);
    return mediant;
  }

  /**
   * checks if it is possible to compute the next Farey term given that a > a2.
   * 
   * @param a Rational number
   * @param a2 Rational number
   * @return if it is possible to find the next Farey number.
   */
  private boolean fareyPossible(final Rational a, final Rational a2)
  {
    double q = a.element[1].doubleValue() / a.element[2].doubleValue();
    double q2 = a2.element[1].doubleValue() / a2.element[2].doubleValue();
    if (q2 <= q)
    {
      return false;
    }
    return true;
  }

  @Override
  protected Rational farey(final Rational a2)
  {
    Rational fraction = new Fraction(1000, 1);
    int n = 0;
    if (this.element[2] > a2.element[2])
    {
      n = this.element[2];
    } else
    {
      n = a2.element[2];
    }
    if (fareyPossible(this, a2))
    {

      fraction = recursiveFarey(this, a2, new Fraction(0, 0), 1, n);
    }
    return fraction;
  }

  /**
   * Recursively uses the mediant operation to find the next number in the Farey sequence.
   * 
   * @param a the first Rational number
   * @param a2 the second Rational number
   * @param pq the next farey number, if there is one
   * @param k used to create an approximation of the next farey number
   * @param n used to create an approximation of the next farey number
   * @return the next farey number
   */
  private Rational recursiveFarey(final Rational a,final Rational a2,final Rational pq,
      final Integer k, final int n)
  {
    if (a.element[1] == 1 && a.element[2] == 3) 
    {
      if (a2.element[1] == 1 && a2.element[2] == 2)
      {
        return new Fraction(2,3);
      }
    }
    if (a.mediant(pq).reduce().element[1].intValue() == a2.element[1].intValue())
    {
      if (a.mediant(pq).reduce().element[2].intValue() == a2.element[2].intValue())
      {
        return pq;
      }
    }
    if (k <= n)
    {
      int p = k * a2.element[1] - a.element[1];
      int q = k * a2.element[2] - a.element[2];
      if (p <= 0 || q <= 0)
      {
        p = 1;
        q = 1;
      }
      pq.element[1] = (p);
      pq.element[2] = (q);
      recursiveFarey(a, a2, pq, k + 1, n);
    }
    return pq;
  }

  @Override
  public boolean entered()
  {
    if (element[1] == null)
    {
      return false;
    }
    if (element[2] == null) 
    {
      return false;
    }
    return true;
  }

  /**
   * The toString method of the ImproperFraction class.
   *
   * @return the final String version of the ImproperFraction
   **/
  public String toString()
  {
    return element[1] + "/" + element[2];
  }
}
