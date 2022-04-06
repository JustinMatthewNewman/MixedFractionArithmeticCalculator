package IntermediateValues;

import math.Equation;
import math.Fraction;
import math.Rational;

/**
 * Displays the French Steps for Intermediate Values.
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
public class FrenchSteps extends IntermediateValues
{

  final String w = "W";
  final String f = "F";
  final String convert = "Convertir ";
  final String toAFrac = " en fraction:\n";
  final String findCommonDenom = "Trouver un denominateur commun:\n";
  final String simplifyTheFrac = "Simplifier la fraction:\n";
  final String multiplyFirstNum = "Multiplier le premier nombre par le deuxieme nombre:\n";
  final String plus = " + ";
  final String equal = " = ";
  final String multiply = " * ";
  final String divide = " / ";
  final String subtract = " - ";
  final String putResultNum = "Mettez le numerateur resultant sur le denominateur resultant:\n";
  final String dividee = "/";
  final String newLine = ":\n";
  final String exponent = "^";
  
  /**
   * Explicit Value Constructor for FrenchSteps
   * 
   * @param equation the current Equation
   */
  public FrenchSteps(final Equation equation)
  {
    super(equation);
  }

  @Override
  public String intermediateValues(final Equation equation)
  {
    String output = "";
    String a1 = "\n\n";
    try
    {
      Rational numberA = equation.getNumbers()[0];
      Rational numberB = equation.getNumbers()[1];
      Rational numberC = equation.getNumbers()[2].toFraction();
      Rational numberD = null;
      if (numberB.entered())
      {
        numberD = numberC.toMixedNumber();
      }

      String instanceA = "";
      String instanceB = "";

      boolean bothWhole;

      if (numberA.getElement()[0] != null && numberA.getElement()[1] != null
          && numberA.getElement()[2] != null)
      {
        output += convert + str(numberA) + toAFrac;
        numberA = numberA.toFraction();
        output += str(numberA) + a1;
        instanceA = f;
      } else if (numberA.getElement()[0] != null && numberA.getElement()[1] == null
          && numberA.getElement()[2] == null)
      {
        instanceA = w;
      } else if (numberA.getElement()[0] == null && numberA.getElement()[1] != null
          && numberA.getElement()[2] != null)
      {
        instanceA = f;
      }

      if (numberB.getElement()[0] != null && numberB.getElement()[1] != null
          && numberB.getElement()[2] != null)
      {
        output += convert + str(numberB) + toAFrac;
        numberB = numberB.toFraction();
        output += str(numberB) + a1;
        instanceB = f;
      } else if (numberB.getElement()[0] != null && numberB.getElement()[1] == null
          && numberB.getElement()[2] == null)
      {
        instanceB = w;
      } else if (numberB.getElement()[0] == null && numberB.getElement()[1] != null
          && numberB.getElement()[2] != null)
      {
        instanceB = f;
      }

      bothWhole = instanceA.equals(w) && instanceB.equals(w);

      if (instanceA.equals(f) && instanceB.equals(w))
      {
        numberB.getElement()[1] = (0);
        numberB.getElement()[2] = (1);
        output += convert + str(numberB) + toAFrac;
        numberB = numberB.toFraction();
        output += str(numberB) + a1;
        instanceB = f;
      }

      if (instanceB.equals(f) && instanceA.equals(w))
      {
        numberA.getElement()[1] = (0);
        numberA.getElement()[2] = (1);
        output += convert + str(numberA) + toAFrac;
        numberA = numberA.toFraction();
        output += str(numberA) + a1;
        instanceA = f;
      }

      switch (equation.getOperator()) 
      {
        case PLUS:
          if (bothWhole)
          {
            output += "Additionner les nombres:\n" + numberA.getElement()[0] + plus
                + numberB.getElement()[0] + equal + str(numberD);
          } else
          {
            int lcd = 1;
            if (numberA.getElement()[2] != numberB.getElement()[2])
            {
              lcd = ((Fraction) numberA.toFraction()).lcd(numberA.getElement()[2],
                  numberB.getElement()[2]);
              output += findCommonDenom + numberD.getElement()[2] + a1;
            }
            output += "Les denominateurs sont egaux, ajoutez des fractions: \n"
                + str(numberA.toFraction().convert(lcd)) + plus
                + str(numberB.toFraction().convert(lcd)) + equal + str(numberC) + a1;
            output += simplifyTheFrac + str(numberC);
          }
          break;
        case MINUS:
          if (bothWhole)
          {
            output += "Soustraire les nombres:\n" + numberA.getElement()[0] + subtract
                + numberB.getElement()[0] + equal + str(numberD);
          } else
          {
            int lcd = 1;
            if (numberA.getElement()[2] != numberB.getElement()[2])
            {
              lcd = ((Fraction) numberA.toFraction()).lcd(numberA.getElement()[2],
                  numberB.getElement()[2]);
              output += findCommonDenom + numberD.getElement()[2] + a1;
            }
            output += "Les denominateurs sont egaux, ajoutez des fractions:\n"
                + str(numberA.toFraction().convert(lcd)) + subtract
                + str(numberB.toFraction().convert(lcd)) + equal + str(numberC) + a1;
            output += simplifyTheFrac + str(numberC);
          }
          break;
        case TIMES:
          if (bothWhole)
          {
            output += multiplyFirstNum
                + numberA.getElement()[0] + multiply + numberB.getElement()[0] 
                    + equal + str(numberD);
          } else
          {
            output += "Multiplier le premier numerateur par le deuxieme numerateur:\n"
                + numberA.getElement()[1] + multiply + numberB.getElement()[1] + equal
                + (numberA.getElement()[1] * numberB.getElement()[1]) + a1;
            output += "Multiplier le premier denominateur par le deuxieme denominateur:\n"
                + numberA.getElement()[2] + multiply + numberB.getElement()[2] + equal
                + (numberA.getElement()[2] * numberB.getElement()[2]) + a1;
            output += putResultNum
                + (numberA.getElement()[1] * numberB.getElement()[1]) + dividee
                + (numberA.getElement()[2] * numberB.getElement()[2]) + a1;
            output += simplifyTheFrac + str(numberC.toFraction());
          }
          break;
        case DIVIDE:
          if (bothWhole)
          {
            output += "Diviser le premier nombre par le deuxieme nombre:\n" 
              + numberA.getElement()[0]
                + divide + numberB.getElement()[0] + equal + numberA.getElement()[0] + dividee
                + numberB.getElement()[0] + a1;
            output += "Simplifier si possible:\n" + str(numberC.toFraction());
          } else
          {
            output += "Multiplier le premier numerateur par le deuxieme denominateur:\n"
                + numberA.getElement()[1] + multiply + numberB.getElement()[2] + equal
                + (numberA.getElement()[1] * numberB.getElement()[2]) + a1;
            output += "Multiplier le premier denominateur par le deuxieme numerateur:\n"
                + numberA.getElement()[2] + multiply + numberB.getElement()[1] + equal
                + (numberA.getElement()[2] * numberB.getElement()[1]) + a1;
            output += putResultNum
                + (numberA.getElement()[1] * numberB.getElement()[2]) + dividee
                + (numberA.getElement()[2] * numberB.getElement()[1]) + a1;
            output += simplifyTheFrac + str(numberC.toFraction());
          }
          break;
        case INVERSE:
          if (instanceA.equals(w))
          {
            output += "Retourner le numerateur et le denominateur:\n1/" + str(numberA);
          } else
          {
            output += "Retourner le numerateur et le denominateur:\n" + str(numberC.toFraction());
          }
          break;
        case POWER:
          int power = numberB.toMixedNumber().getElement()[0];
          if (instanceA.equals(w))
          {
            output += "elever le nombre a la puissance de " + power + newLine 
                + str(numberA) + exponent + power + equal + str(numberD);
          } else
          {
            int powA = (int) Math.pow(numberA.getElement()[1], power);
            int powB = (int) Math.pow(numberA.getElement()[2], power);
            output += "elever le numerateur et le denominateur a la puissance de " + power + newLine
                + numberA.getElement()[1] + exponent + power 
                + dividee + numberA.getElement()[2] + exponent + power
                + equal + powA + dividee + powB + a1;
            output += simplifyTheFrac + str(numberC);
          }
          break;
        case MEDIANT:
          output += "Trouvez le nombre le plus petit et le plus simplifie entre les deux nombres";
          break;
        case FAREY:
          int n;
          if (numberA.getElement()[2] >= numberB.getElement()[2])
          {
            n = numberA.getElement()[2];
          } else
          {
            n = numberB.getElement()[2];
          }
          output += "Ordre de Farey: " + n + a1;
          output += "Trouver le numero suivant dans la sequence";
          break;
        default:
      }

      if (numberD != null && !str(numberC).equals(str(numberD))
          && (numberC.getElement()[1] != numberD.getElement()[0]))
      {
        output += "\n\nReconvertir en un nombre mixte:\n" + str(numberD);
      }
    } catch (NullPointerException e)
    {
    }

    return output;
  }
}
