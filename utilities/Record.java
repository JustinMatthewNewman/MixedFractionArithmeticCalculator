package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * Creates a File that is the Recording of the history and exports the File.
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
public class Record extends Recording
{
  Playback p;

  /**
   * Record constructor.
   * 
   * @param filetype is gthe file type the user has chosen.
   * @param p the playback being used
   * @throws IOException
   */
  public Record(final String filetype, final Playback p) throws IOException
  {
    this.p = p;
    record(filetype);
  }

  /**
   * Records the information of fragile calculator in a document with the users chosen file type.
   * 
   * @param filetype
   * @throws IOException
   */
  public void record(final String filetype) throws IOException
  {

    BufferedWriter bw = null;
    try
    {
      JFrame f;
      f = new JFrame();
      f.setSize(400, 200);
      JFileChooser jfc;
      jfc = new JFileChooser();
      jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      jfc.showOpenDialog(f);

      String mycontent = p.getRecord().getStorageString();
      // Specify the file name and path here
      File file = new File(jfc.getSelectedFile().toString() + "/fragile." + filetype);

      /*
       * This logic will make sure that the file gets created if it is not present at the specified
       * location
       */
      if (!file.exists())
      {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter(file);
      bw = new BufferedWriter(fw);
      bw.write(mycontent);

    } catch (IOException ioe)
    {
      ioe.printStackTrace();
    } finally
    {
      try
      {
        if (bw != null)
          bw.close();
      } catch (IOException ex)
      {
      }
    }
  }
}
