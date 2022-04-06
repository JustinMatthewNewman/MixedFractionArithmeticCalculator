package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import math.Fraction;
import math.MixedNumber;
import math.Rational;
import math.WholeNumber;

/**
 * In depth testing of the Fragile Arithmetic.
 * 
 * @author justinnewman
 *
 */
class FractionsTest
{
  // Mixed Numbers
  Rational mixed = new MixedNumber(1, 1, 2);
  Rational negMixed = new MixedNumber(-1, 1, 2);

  // Whole Numbers
  Rational whole = new WholeNumber(1);
  Rational zed = new WholeNumber(0);
  Rational neg = new WholeNumber(-1);

  // Fractions (Improper and proper)
  Rational half = new Fraction(1, 2);
  Rational neghalf = new Fraction(-1, 2);
  Rational imp = new Fraction(3, 2);
  Rational imp2 = new Fraction(-5, 2);

  @Test
  void testIntPower()
  {
    // Exponent > 0(Positive)
    // 2^2 = 4
    Rational two = new WholeNumber(2);
    assertEquals(new WholeNumber(4).format().toString(),
        two.integerPow(two.getElement()[0]).format().toString());

    // (1 1/2) ^ 2 =
    Rational answer = new MixedNumber(2, 1, 4);
    assertEquals(answer.format().toString(),
        mixed.integerPow(two.getElement()[0]).format().toString());

    // (-1) ^ 2 = 1
    assertEquals(new WholeNumber(1).format().toString(),
        neg.integerPow(two.getElement()[0]).format().toString());

    // (0) ^ 2 = 0
    assertEquals(new WholeNumber(0).format().toString(),
        zed.integerPow(two.getElement()[0]).format().toString());

    // Exponent = 0
    // 2 ^ 0 = 1
    assertEquals(new WholeNumber(1).format().toString(), two.integerPow(0).format().toString());

    // (1 1/2) ^ 0 = 1
    assertEquals(new WholeNumber(1).format().toString(), mixed.integerPow(0).format().toString());

  }

  @Test
  void testMixedAndMixed()
  {
    // 1 1/2 + 1 1/2 = 3
    assertEquals(new WholeNumber(3).format().toString(), mixed.addition(mixed).format().toString());
    // 1 1/2 - 1 1/2 = 0
    assertEquals(zed.format().toString(), mixed.subtraction(mixed).format().toString());
    // 1 1/2 * 1 1/2 = 2 1/4
    assertEquals(new MixedNumber(2, 1, 4).format().toString(),
        mixed.multiplication(mixed).format().toString());
    // 1 1/2 / 1 1/2 = 1
    assertEquals(new WholeNumber(1).format().toString(), mixed.division(mixed).format().toString());

    // 1 1/2 + -1 1/2 = 0
    assertEquals(zed.format().toString(), mixed.addition(negMixed).format().toString());
  }

  @Test
  void testFracAndMixed()
  {
    // 1/2 - 1 1/2 = -1
    assertEquals(new WholeNumber(-1).format().toString(),
        half.subtraction(mixed).format().toString());
    // 3/2 - 1 1/2 = 0
    assertEquals(new WholeNumber(0).format().toString(),
        imp.subtraction(mixed).format().toString());
    // 3/2 + 1 1/2 = 3
    assertEquals(new WholeNumber(3).format().toString(), imp.addition(mixed).format().toString());
    // - 1/2 + 1 1/2 = 1
    assertEquals(new WholeNumber(1).format().toString(),
        neghalf.addition(mixed).format().toString());
    // 1/2 + 1 1/2 = 2
    assertEquals(new WholeNumber(2).format().toString(), half.addition(mixed).format().toString());
  }

  @Test
  void testMixedAndFrac()
  {
    // 1 1/2 + 1/2 = 2
    assertEquals(new WholeNumber(2).format().toString(), mixed.addition(half).format().toString());
    // 1 1/2 + 3/2 = 3
    assertEquals(new WholeNumber(3).format().toString(), mixed.addition(imp).format().toString());
    // 1 1/2 + -5/3 = -1
    assertEquals(new WholeNumber(-1).format().toString(), mixed.addition(imp2).format().toString());
    // 1 1/2 + -1/2 = 1
    assertEquals(new WholeNumber(1).format().toString(),
        mixed.addition(neghalf).format().toString());
    // 1 1/2 - 3/2 = 0
    assertEquals(new WholeNumber(0).format().toString(),
        mixed.subtraction(imp).format().toString());
    // 1 1/2 * 3/2 = 2 1/4
    assertEquals(new MixedNumber(2, 1, 4).format().toString(),
        mixed.multiplication(imp).format().toString());

    // - 1 1/2 + 1/2 = -1
    assertEquals(new WholeNumber(-1).format().toString(),
        negMixed.addition(half).format().toString());

  }

  @Test
  void testFracAndFrac()
  {
    // 1/2 + 1/2 = 1
    assertEquals(new WholeNumber(1).format().toString(), half.addition(half).format().toString());
    // 1/2 - 1/2 = 0
    assertEquals(new WholeNumber(0).format().toString(),
        half.subtraction(half).format().toString());
    // 3/2 + 3/2 = 3
    assertEquals(new WholeNumber(3).format().toString(), imp.addition(imp).format().toString());

  }

  @Test
  void testWholeAndMixed()
  {
    // 1 - 1 1/2 = -1/2
    assertEquals(new Fraction(-1, 2).format().toString(),
        whole.subtraction(mixed).format().toString());
    // 1 + 1 1/2 = 2 1/2
    assertEquals(new MixedNumber(2, 1, 2).format().toString(),
        whole.addition(mixed).format().toString());
    // 1 * 1 1/2 = 1 1/2
    assertEquals(new MixedNumber(1, 1, 2).format().toString(),
        whole.multiplication(mixed).format().toString());
    // 1 / 1 1/2 = 2/3
    assertEquals(new Fraction(2, 3).format().toString(), whole.division(mixed).format().toString());
    // -1 + 1 1/2 = 1/2
    assertEquals(new Fraction(1, 2).format().toString(), neg.addition(mixed).format().toString());

  }

  @Test
  void testMixedAndWhole()
  {
    // 1 1/2 - 1 = 1/2
    assertEquals(new Fraction(1, 2).format().toString(),
        mixed.subtraction(whole).format().toString());
    // 1 1/2 + 1 = 2 1/2
    assertEquals(new MixedNumber(2, 1, 2).format().toString(),
        mixed.addition(whole).format().toString());
    // 1 1/2 * 1 = 1 1/2
    assertEquals(new MixedNumber(1, 1, 2).format().toString(),
        mixed.multiplication(whole).format().toString());
    // 1 1/2 / 1 = 1 1/2
    assertEquals(new MixedNumber(1, 1, 2).format().toString(),
        mixed.division(whole).format().toString());

  }

  @Test
  void testWholeAndWhole()
  {
    // 1 * 1 = 1
    assertEquals(new WholeNumber(1).format().toString(),
        whole.multiplication(whole).format().toString());
    // 1 - 1 = 0
    assertEquals(new WholeNumber(0).format().toString(),
        whole.subtraction(whole).format().toString());

    // 1 + 1 = 2
    assertEquals(new WholeNumber(2).format().toString(), whole.addition(whole).format().toString());
    // 4 / 2 = 2
    assertEquals(new WholeNumber(2).format().toString(),
        new WholeNumber(4).division(new WholeNumber(2)).format().toString());

  }

}
