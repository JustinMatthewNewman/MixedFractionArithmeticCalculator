package utilities;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import DisplayPanel.CompositePanel;
import math.Equation;

/**
 * Plays back the the Recording.
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
public class Playback
{

  CompositePanel panel;
  ArrayList<Equation> equations;

  int speed;
  int pointer; // used in the stop function of playback.

  private Recording record;
  private Timer timer;

  /**
   * Explicit Value Constructor for Playback.
   * 
   * @param panel the CompositePanel
   * @param record the Recording object
   */
  public Playback(final CompositePanel panel, final Recording record)
  {
    this.panel = panel;
    this.equations = record.getRecording();
    this.record = record;
    speed = 1000;
    pointer = 0;
  }

  /**
   * Sets the speed of the playback.
   * 
   * @param speed is the desired speed of playback
   */
  public void setSpeed(final int speed)
  {
    this.speed = speed;
  }

  /**
   * Starts the playback.
   * 
   * @throws InterruptedException the Exception
   */
  public void start() throws InterruptedException
  {

    timer = new Timer();

    timer.schedule(new TimerTask()
    {
      public void run()
      {
        panel.setDisplay(equations.get(pointer));
        if (!equations.get(pointer).getNumbers()[1].entered())
        {
          panel.getOperatorPanel().setOperator("");
        }
        if (++pointer == equations.size())
        {
          timer.cancel();
          pointer = 0;
        }
      }
    }, 0, speed);

  }

  /**
   * Stops the playback.
   */
  public void stop()
  { // make go false so run recursion stops
    timer.cancel();
  }

  /**
   * Returns the pointer of the playback class.
   * 
   * @return the pointer.
   */
  public int getPointer()
  {
    return pointer;
  }

  /**
   * Gets the pointer.
   * 
   * @param pointer to set.
   */
  public void setPointer(final int pointer)
  {
    this.pointer = pointer;
  }

  /**
   * Gets the record.
   * 
   * @return the record.
   */
  public Recording getRecord()
  {
    return record;
  }

  /**
   * Sets the record.
   * 
   * @param record the record.
   */
  public void setRecord(final Recording record)
  {
    this.record = record;
  }

  /**
   * Sets the equation array.
   * 
   * @param equation the record of equations.
   */
  public void setEquations(final ArrayList<Equation> equation)
  {
    this.equations = equation;
  }

  /**
   * Gets the record.
   * 
   * @return the array list of all equations
   */
  public ArrayList<Equation> getEquations()
  {
    return this.equations;
  }
}
