package utilities;

import java.util.ArrayList;

import math.Equation;
import math.MixedNumber;

/**
 * Records all operations performs.
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
public class Recording
{
  private static final String SPACE = " ";
  private ArrayList<Equation> recording;
  private String storageString;

  /**
   * Default Constructor for Recording.
   */
  public Recording()
  {
    recording = new ArrayList<Equation>();
    storageString = SPACE;
  }

  /**
   * This is the constructor for passing an array lsit straight into a recording object.
   * 
   * @param a1
   */
  public Recording(final ArrayList<Equation> a1)
  {
    recording = a1;
    storageString = SPACE;
  }

  /**
   * This method gets the arraylist of equations.
   * 
   * @return the list of equations
   */
  public ArrayList<Equation> getRecording()
  {
    return recording;
  }

  /**
   * This method gets the string form of the arraylist of equations.
   * 
   * @return the list of equations as a string
   */
  public String getStorageString()
  {
    return storageString;
  }

  /**
   * Add method to add equations to the running recording. Will send true is item was added or false
   * if it was not.
   * 
   * @param eq the equation to add
   * @return boolean if the equation was added correctly
   */
  public boolean add(final Equation eq)
  {
    Equation eqTest = new Equation();
    MixedNumber a = new MixedNumber(eq.getNumbers()[0].getElement()[0],
        eq.getNumbers()[0].getElement()[1], eq.getNumbers()[0].getElement()[2]);
    String b = eq.getOperator();
    MixedNumber c = new MixedNumber(eq.getNumbers()[1].getElement()[0],
        eq.getNumbers()[1].getElement()[1], eq.getNumbers()[1].getElement()[2]);
    MixedNumber r = new MixedNumber(eq.getNumbers()[2].getElement()[0],
        eq.getNumbers()[2].getElement()[1], eq.getNumbers()[2].getElement()[2]);

    eqTest.getNumbers()[0] = a;
    eqTest.setOperator(b);
    eqTest.getNumbers()[1] = c;
    eqTest.getNumbers()[2] = r;
    recording.add(eqTest);
    return true;
  }

  /**
   * Clears the storage string.
   */
  public void clear()
  {
    recording.clear();
    storageString = "";
  }

  /**
   * Adds the equation toString to the storage string.
   * 
   * @param eq the Equation
   */
  public void addString(final Equation eq)
  {

    storageString = storageString + "\n" + eq.toString() + ",";

  }
}
