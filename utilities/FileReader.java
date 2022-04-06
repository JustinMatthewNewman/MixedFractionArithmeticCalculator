package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import math.Equation;
import math.MixedNumber;
import math.Rational;

/**
 * The FileReader class is a utility used to read a string into the fragile calculator.
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
public class FileReader
{
  // Read file content into string with - Files.readAllBytes(Path path)

  public static final String PLUS = "+";
  public static final String MINUS = "-";
  public static final String TIMES = "*";
  public static final String DIVIDE = "/";
  public static final String INVERSE = "i";
  public static final String POWER = "^";
  public static final String MEDIANT = "m";
  public static final String FAREY = "f";
  public static final String EQUAL = "=";
  public static final String SPACE = " ";
  public static final String NEWLN = "\n";

  /**
   * Reads in from source path.
   * 
   * @param input The string to be read
   * @return The text document to use in fragile calculator
   * @throws IOException the exception to be thrown
   */
  public String readIn(final String input) throws IOException
  {
    InputStream in = getClass().getResourceAsStream(input);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String st;
    String out = "";
    while ((st = reader.readLine()) != null)
      out = out + st + NEWLN;
    return out;
  }

  /**
   * Reads in a path from the file system and parses it into a string.
   * 
   * @param input the String to be read
   * @return The parsed string to be used in fragile calculator
   * @throws IOException the exception to be thrown
   */
  public String readInPath(final String input) throws IOException
  {
    StringBuilder sb = new StringBuilder();
    try
    {
      File myObj = new File(input);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine())
      {
        String data = myReader.nextLine();
        sb.append(data + NEWLN);
      }
      myReader.close();
    } catch (FileNotFoundException e)
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return sb.toString();
  }

  /**
   * Parses a file and puts the equation objects into a Recording object.
   * 
   * @param input the String to be read into fragile calculator
   * @return A recording object of the recorded Equations
   */
  public Recording parseFile(final String input)
  {
    ArrayList<Equation> a1 = new ArrayList<Equation>();
    Scanner in = new Scanner(input);
    in.useDelimiter(",");
    while (in.hasNext())
    {
      String a = in.next();
      String left = "";
      String center = "";
      String right = "";
      String op = getOp(a);

      if (!op.equals(""))
      {
        String dl = a.replace(op, "");
        left = dl.substring(0, dl.indexOf(SPACE + SPACE)).trim();
        center = dl.substring(dl.indexOf(SPACE + SPACE) + 2, dl.indexOf(EQUAL)).trim();
        right = dl.substring(dl.indexOf(EQUAL) + 2, dl.length()).trim();

        System.out.println(left);
        System.out.println(center);
        System.out.println(right);

        Rational l = new MixedNumber(left.replace(DIVIDE, SPACE).split(SPACE));
        Rational c = new MixedNumber(center.replace(DIVIDE, SPACE).split(SPACE));
        Rational r = new MixedNumber(right.replace(DIVIDE, SPACE).split(SPACE));

        Equation w = new Equation();
        w.getNumbers()[0] = l;
        w.getNumbers()[1] = c;
        w.getNumbers()[2] = r;
        w.setOperator(op);
        a1.add(w);
      }
    }
    System.out.println(a1.toString());
    in.close();
    return new Recording(a1);
  }

  /**
   * Parses the line and gets the operator.
   * 
   * @param line the String to be read
   * @return Returns the operator as a String
   */
  public String getOp(final String line)
  {
    if (line.length() > 3)
    {
      String result = "";
      if (line.contains(PLUS))
      {
        result = PLUS;
      }
      if (line.contains(MINUS))
      {
        result = MINUS;
      }
      if (line.contains(TIMES))
      {
        result = TIMES;
      }
      if (line.contains(MEDIANT))
      {
        result = MEDIANT;
      }
      if (line.contains(FAREY))
      {
        result = FAREY;
      }
      if (line.contains(POWER))
      {
        result = POWER;
      }
      String h = line.substring(0, line.indexOf(EQUAL));
      int count = 0;
      char[] s = h.toCharArray();
      for (int i = 0; i < h.length(); i++)
      {
        if (s[i] == '/')
        {
          count++;
        }
      }
      if (count == 3)
      {
        result = DIVIDE;
      }
      return result;
    }
    return "";
  }
}
