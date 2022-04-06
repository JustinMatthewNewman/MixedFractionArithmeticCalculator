package utilities;

/**
 * The history class creates a written and viewable history of fragile calculators past equations
 * and operations.
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
public class History
{
  private Recording historyRecord;

  /**
   * This method sets the recording object of this class.
   * 
   * @param recording is the recording object to use
   */
  public History(final Recording recording)
  {
    historyRecord = recording;
  }

  /**
   * This method will display the storage string version of the recording present.
   * 
   * @return the stored history as a string
   */
  public String displayHistory()
  {

    return historyRecord.getStorageString();
  }
}
