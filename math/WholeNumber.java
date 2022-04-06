package math;

/**
 * WholeNumber Class.
 * 
 * @author AbdallahDerbala, justinnewman
 **/
public class WholeNumber extends Rational
{

  /**
   * Explicit Value Constructor for the WholeNumber object.
   * 
   * @param number the whole number
   **/
  public WholeNumber(final Integer number)
  {
    super(number);
  }
  
  /**
   * Explicit Value Constructor for the WholeNumber object.
   * 
   * @param text to parse as whole.
   */
  public WholeNumber(final String[] text) 
  {
    super(text);
  }
  
  @Override
  public Rational toFraction()
  {
    return new Fraction(getElement()[0], 1);
  }

  @Override
  public Rational toMixedNumber()
  {
    return new MixedNumber(getElement()[0], 0, 1);
  }

  @Override
  public Rational multiplication(final Rational number) throws NullPointerException
  {
    return this.toFraction().multiplication(number.toFraction());
  }

  @Override
  public Rational division(final Rational number)
  {
    return this.toFraction().division(number.toFraction());
  }
  
  @Override
  public Rational addition(final Rational number) throws NullPointerException
  {
    return this.toFraction().addition(number.toFraction());
  }
  
  @Override
  public Rational subtraction(final Rational number)
  {
    return this.toFraction().subtraction(number.toFraction());
  }

  @Override
  public Rational integerPow(final Integer exp)
  {

    return this.toFraction().integerPow(exp);
  }

  @Override
  public Rational format()
  {
    return new WholeNumber(getElement()[0]);
  }

  @Override
  public Fraction convert(final Integer common)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void negate()
  {
    getElement()[0] = (getElement()[0] * -1);
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

  @Override
  public boolean entered()
  {
    if (getElement()[0] == null)
    {
      return false;
    }
    return true;
  }

  @Override
  protected Rational reduce()
  {
    return this;
  }

  /**
   * The method to get the whole number (unit) of this MixedNumber.
   * 
   * @return the whole number (unit) integer of this MixedNumber
   **/
  public String toString()
  {
    return getElement()[0] + "";
  }
}
