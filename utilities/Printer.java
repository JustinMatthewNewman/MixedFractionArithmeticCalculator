package utilities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Scanner;

/**
 * Printer prints to a nearby printer.
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
public class Printer implements Printable, ActionListener
{

  Playback playback;

  /**
   * Constructor for the Printer class.
   * 
   * @param playback
   */
  public Printer(final Playback playback)
  {
    this.playback = playback;
  }

  /**
   * Prints the number of pages to print.
   * 
   * @return an integer based on the success of print.
   * @param g is the graphics
   * @param pf is the page Format
   * @param page is the integer page
   */
  public int print(final Graphics g, final PageFormat pf, final int page) throws PrinterException
  {

    if (page > 0)
    { /* We have only one page, and 'page' is zero-based */
      return NO_SUCH_PAGE;
    }

    /*
     * User (0,0) is typically outside the imageable area, so we must translate by the X and Y
     * values in the PageFormat to avoid clipping
     */
    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    /* Now we perform our rendering */
    Scanner in = new Scanner(playback.getRecord().getStorageString());
    int i = 10;
    in.useDelimiter(",");
    while (in.hasNext())
    {
      String out = in.next();
      i = i + 25;
      g.drawString(out, 100, 100 + i);
    }
    // g.drawString(playback.getRecord().getStorageString(), 100, 100);

    /* tell the caller that this page is part of the printed document */
    return PAGE_EXISTS;
  }

  /**
   * This is the method that controls what happens when an action is performed.
   * 
   * @param e is the event taking place.
   */
  public void actionPerformed(final ActionEvent e)
  {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(this);
    boolean ok = job.printDialog();
    if (ok)
    {
      try
      {
        job.print();
      } catch (PrinterException ex)
      {
        /* The job did not successfully complete */
      }
    }
  }
}
