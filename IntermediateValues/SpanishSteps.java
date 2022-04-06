package IntermediateValues;

import math.Equation;
import math.Fraction;
import math.Rational;

/**
 * Dislays English Steps for Intermediate Values.
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
public class SpanishSteps extends IntermediateValues
{
  
  final String w = "W";
  final String f = "F";
  final String convert = "Convertir ";
  final String toAFrac = " a una fraccion:\n";
  final String findCommonDenom = "Encuentra el denominador comun:\n";
  final String simplifyTheFrac = "Simplifica la fraccion:\n";
  final String simplifyIfPossible = "Simplifique si es posible:\n";
  final String multiplyFirstNum = "Multiplica el primer numero por el segundo numero:\n";
  final String multiplyDenom = "Multiplica el primer denominador por el segundo denominador:\n";
  final String coloca = "Coloca el numerador resultante sobre el denominador resultante:\n";
  final String plus = " + ";
  final String equal = " = ";
  final String multiply = " * ";
  final String divide = " / ";
  final String subtract = " - ";
  final String putResultNum = "Multiplica el primer numerador por el segundo numerador:\n";
  final String dividee = "/";
  final String newLine = ":\n";
  final String exponent = "^";
  final String nn = "\n\n";

  
  /**
   * Explicit Value Constructor for EnglishSteps
   * 
   * @param equation the current Equation
   */
  public SpanishSteps(final Equation equation)
  {
    super(equation);
  }

  @Override
  public String intermediateValues(final Equation equation)
  {
    String output = "";

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
        output += str(numberA) + nn;
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
        output += str(numberB) + nn;
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
        output += str(numberB) + nn;
        instanceB = f;
      }

      if (instanceB.equals(f) && instanceA.equals(w))
      {
        numberA.getElement()[1] = (0);
        numberA.getElement()[2] = (1);
        output += convert + str(numberA) + toAFrac;
        numberA = numberA.toFraction();
        output += str(numberA) + nn;
        instanceA = f;
      }

      switch (equation.getOperator()) 
      {
        case PLUS:
          if (bothWhole)
          {
            output += "Suma los numeros:\n" + numberA.getElement()[0] + plus
                + numberB.getElement()[0] + equal + str(numberD);
          } else
          {
            int lcd = 1;
            if (numberA.getElement()[2] != numberB.getElement()[2])
            {
              lcd = ((Fraction) numberA.toFraction()).lcd(numberA.getElement()[2],
                  numberB.getElement()[2]);
              output += findCommonDenom + numberD.getElement()[2] + nn;
            }
            output += "Los denominadores son iguales, suman fracciones:\n"
                + str(numberA.toFraction().convert(lcd)) + plus
                + str(numberB.toFraction().convert(lcd)) + equal + str(numberC) + nn;
            output += simplifyTheFrac + str(numberC);
          }
          break;
        case MINUS:
          if (bothWhole)
          {
            output += "Resta los numeros:\n" + numberA.getElement()[0] + subtract
                + numberB.getElement()[0] + equal + str(numberD);
          } else
          {
            int lcd = 1;
            if (numberA.getElement()[2] != numberB.getElement()[2])
            {
              lcd = ((Fraction) numberA.toFraction()).lcd(numberA.getElement()[2],
                  numberB.getElement()[2]);
              output += findCommonDenom + numberD.getElement()[2] + nn;
            }
            output += "Los denominadores son iguales, restan fracciones:\n"
                + str(numberA.toFraction().convert(lcd)) + subtract
                + str(numberB.toFraction().convert(lcd)) + equal + str(numberC) + nn;
            output += simplifyTheFrac + str(numberC);
          }
          break;
        case TIMES:
          if (bothWhole)
          {
            output += multiplyFirstNum 
              + numberA.getElement()[0]
                + multiply + numberB.getElement()[0] + equal + str(numberD);
          } else
          {
            output += putResultNum
                + numberA.getElement()[1] + multiply + numberB.getElement()[1] + equal
                + (numberA.getElement()[1] * numberB.getElement()[1]) + nn;
            output += multiplyDenom
                + numberA.getElement()[2] + multiply + numberB.getElement()[2] + equal
                + (numberA.getElement()[2] * numberB.getElement()[2]) + nn;
            output += coloca
                + (numberA.getElement()[1] * numberB.getElement()[1]) + dividee
                + (numberA.getElement()[2] * numberB.getElement()[2]) + nn;
            output += simplifyTheFrac + str(numberC.toFraction());
          }
          break;
        case DIVIDE:
          if (bothWhole)
          {
            output += "Dividir el primer numero por el segundo numero:\n" + numberA.getElement()[0]
                + divide + numberB.getElement()[0] + equal + numberA.getElement()[0] + dividee
                + numberB.getElement()[0] + nn;
            output += simplifyIfPossible + str(numberC.toFraction());
          } else
          {
            output += putResultNum
                + numberA.getElement()[1] + multiply + numberB.getElement()[2] + equal
                + (numberA.getElement()[1] * numberB.getElement()[2]) + nn;
            output += multiplyDenom
                + numberA.getElement()[2] + multiply + numberB.getElement()[1] + equal
                + (numberA.getElement()[2] * numberB.getElement()[1]) + nn;
            output += coloca
                + (numberA.getElement()[1] * numberB.getElement()[2]) + dividee
                + (numberA.getElement()[2] * numberB.getElement()[1]) + nn;
            output += simplifyIfPossible + str(numberC.toFraction());
          }
          break;
        case INVERSE:
          if (instanceA.equals(w))
          {
            output += "Da la vuelta al numerador y al denominador:\n1/" + str(numberA);
          } else
          {
            output += "Da la vuelta al numerador y al denominador:\n" + str(numberC.toFraction());
          }
          break;
        case POWER:
          int power = numberB.toMixedNumber().getElement()[0];
          if (instanceA.equals(w))
          {
            output += "Sube el numero a la potencia de " 
              + power + newLine + str(numberA) + exponent + power
                + equal + str(numberD);
          } else
          {
            int powA = (int) Math.pow(numberA.getElement()[1], power);
            int powB = (int) Math.pow(numberA.getElement()[2], power);
            output += "Eleva el numerador y el denominador a la potencia de " + power + newLine
                + numberA.getElement()[1] + exponent + power + dividee 
                + numberA.getElement()[2] + exponent + power
                + equal + powA + dividee + powB + nn;
            output += simplifyTheFrac + str(numberC);
          }
          break;
        case MEDIANT:
          output += "Encuentra el numero mas pequeno y simplificado entre los dos numeros";
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
          output += "Orden de Farey: " + n + nn;
          output += "Encuentra el siguiente numero en la secuencia";
          break;
        default:
      }

      if (numberD != null && !str(numberC).equals(str(numberD))
          && (numberC.getElement()[1] != numberD.getElement()[0]))
      {
        output += "\n\nConvertir de nuevo a un numero mixto:\n" + str(numberD);
      }
    } catch (NullPointerException e)
    {
    }

    return output;
  }
}
