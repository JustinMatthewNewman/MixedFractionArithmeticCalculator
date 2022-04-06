package app;

import java.awt.Color;
import java.lang.reflect.*;

import javax.swing.*;

import Controller.FragileController;
import GUI.Settings;


/**
 * Fragile Calculator Application.
 * 
 * Dr. David Bernstein, MIT, Princeton, JMU
 * Ph.D., University of Pennsylvania, 1990
 * M.P.A., Princeton University, 1983
 * B.A., State University of New York at Binghamton, 1981
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
public class Fragile implements Runnable
{

  /**
   * Explicit Value Constructor.
   * 
   * @param args The command-line arguments
   */
  public Fragile(final String[] args)
  {
  }

  /**
   * The entry point of the application.
   * 
   * @param args The command-line arguments (which are ignored)
   * @throws InterruptedException If the system is interrupted
   * @throws InvocationTargetException If there is a problem starting the system
   */
  public static void main(final String[] args)
      throws InterruptedException, InvocationTargetException
  {
    // Perform all of the setup activities in the event dispatch thread
    SwingUtilities.invokeAndWait(new Fragile(args));
  }

  /**
   * Runs the application and set up components.
   */
  public void run()
  {
    setLookAndFeel();
    // SET UP APP FRAME
    JFrame frame = new JFrame("Fragile");
    frame.setBounds(400, 100, 444, 595);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    // READ IN SETTINGS FROM JAR WIZARD
    new Settings();
    // SET UP APP CONTROL AND LOGIC
    new FragileController(frame);
    // MAKE FRAGILE VISIBLE
    frame.setVisible(true);
  }

  /**
   * Set the look and feel for the application.
   */
  private void setLookAndFeel()
  {
    String nb = "nimbusBase";
    String nbg = "nimbusBlueGrey";
    String c = "control";
    // Setup the look and feel
    boolean done = false;
    try
    {
      // Use Nimbus if it is available
      UIManager.LookAndFeelInfo[] lfs = UIManager.getInstalledLookAndFeels();
      for (int i = 0; i < lfs.length && !done; i++)
      {
        if ("Nimbus".equals(lfs[i].getName()))
        {
          UIManager.setLookAndFeel(lfs[i].getClassName());
          UIManager.put(nb, new Color(238, 238, 238));
          UIManager.put(nbg, new Color(238, 238, 238));
          UIManager.put(c, new Color(238, 238, 238));
          done = true;
        }
      }

      // If Nimbus isn't available, use the system look and feel
      if (!done)
      {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        UIManager.put(nb, new Color(238, 238, 238));
        UIManager.put(nbg, new Color(238, 238, 238));
        UIManager.put(c, new Color(238, 238, 238));
      }
    } catch (ClassNotFoundException cnfe)
    {
      // Use the default look and feel
    } catch (IllegalAccessException iae)
    {
      // Use the default look and feel
    } catch (InstantiationException ie)
    {
      // Use the default look and feel
    } catch (UnsupportedLookAndFeelException ulale)
    {
      // Use the default look and feel
    }
  }
}
