package HTML;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Fragile Calculator.
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
public class HelpPage
{

  /**
   * 
   * @param i
   * @throws URISyntaxException
   */
  public HelpPage(final int i) throws URISyntaxException
  {
    Desktop desktop = Desktop.getDesktop();
    InputStream in = this.getClass().getResourceAsStream("help.html");
    InputStream in22 = this.getClass().getResourceAsStream("helpFR.html");
    InputStream in23 = this.getClass().getResourceAsStream("helpES.html");

    InputStream in1 = this.getClass().getResourceAsStream("cs-building.jpg");
    InputStream in2 = this.getClass().getResourceAsStream("add.png");
    InputStream in3 = this.getClass().getResourceAsStream("subtract.png");
    InputStream in4 = this.getClass().getResourceAsStream("multiply.png");
    InputStream in5 = this.getClass().getResourceAsStream("divide.png");
    InputStream in6 = this.getClass().getResourceAsStream("exponent.png");
    InputStream in7 = this.getClass().getResourceAsStream("equal.png");
    InputStream in8 = this.getClass().getResourceAsStream("farey.png");
    InputStream in9 = this.getClass().getResourceAsStream("mediant.png");
    InputStream in10 = this.getClass().getResourceAsStream("clear.png");
    InputStream in11 = this.getClass().getResourceAsStream("backspace.png");
    InputStream in12 = this.getClass().getResourceAsStream("focus.png");
    InputStream in13 = this.getClass().getResourceAsStream("inverse.png");
    InputStream in14 = this.getClass().getResourceAsStream("negate.png");
    InputStream in15 = this.getClass().getResourceAsStream("reset.png");

    InputStream in16 = this.getClass().getResourceAsStream("justin.png");
    InputStream in17 = this.getClass().getResourceAsStream("junior.png");
    InputStream in18 = this.getClass().getResourceAsStream("bernstein.png");
    InputStream in19 = this.getClass().getResourceAsStream("dylan.png");
    InputStream in20 = this.getClass().getResourceAsStream("abdallah.png");
    InputStream in21 = this.getClass().getResourceAsStream("easton.png");

    try
    {
      // TODO add your handling code here:
      String tDir = System.getProperty("java.io.tmpdir");
      File file1 = new File(tDir + "/cs-building.jpg");
      Files.copy(in1, file1.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file1.deleteOnExit();

      File file2 = new File(tDir + "/add.png");
      Files.copy(in2, file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file2.deleteOnExit();

      File file3 = new File(tDir + "/subtract.png");
      Files.copy(in3, file3.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file3.deleteOnExit();

      File file4 = new File(tDir + "/multiply.png");
      Files.copy(in4, file4.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file4.deleteOnExit();

      File file5 = new File(tDir + "/divide.png");
      Files.copy(in5, file5.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file5.deleteOnExit();

      File file6 = new File(tDir + "/exponent.png");
      Files.copy(in6, file6.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file6.deleteOnExit();

      File file7 = new File(tDir + "/equal.png");
      Files.copy(in7, file7.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file7.deleteOnExit();

      File file8 = new File(tDir + "/farey.png");
      Files.copy(in8, file8.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file8.deleteOnExit();

      File file9 = new File(tDir + "/mediant.png");
      Files.copy(in9, file9.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file9.deleteOnExit();

      File file10 = new File(tDir + "/clear.png");
      Files.copy(in10, file10.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file10.deleteOnExit();

      File file11 = new File(tDir + "/backspace.png");
      Files.copy(in11, file11.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file11.deleteOnExit();

      File file12 = new File(tDir + "/focus.png");
      Files.copy(in12, file12.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file12.deleteOnExit();

      File file13 = new File(tDir + "/inverse.png");
      Files.copy(in13, file13.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file13.deleteOnExit();

      File file14 = new File(tDir + "/negate.png");
      Files.copy(in14, file14.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file14.deleteOnExit();

      File file15 = new File(tDir + "/reset.png");
      Files.copy(in15, file15.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file15.deleteOnExit();

      File file16 = new File(tDir + "/justin.png");
      Files.copy(in16, file16.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file16.deleteOnExit();

      File file17 = new File(tDir + "/junior.png");
      Files.copy(in17, file17.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file17.deleteOnExit();

      File file18 = new File(tDir + "/bernstein.png");
      Files.copy(in18, file18.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file18.deleteOnExit();

      File file19 = new File(tDir + "/dylan.png");
      Files.copy(in19, file19.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file19.deleteOnExit();

      File file20 = new File(tDir + "/abdallah.png");
      Files.copy(in20, file20.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file20.deleteOnExit();

      File file21 = new File(tDir + "/easton.png");
      Files.copy(in21, file21.toPath(), StandardCopyOption.REPLACE_EXISTING);
      file21.deleteOnExit();

      Path tempOutput = null;
      String tempFile = "myFile";
      tempOutput = Files.createTempFile(tempFile, ".html");
      tempOutput.toFile().deleteOnExit();

      if (i == 1)
      {
        Files.copy(in, tempOutput, StandardCopyOption.REPLACE_EXISTING);
      }
      if (i == 2)
      {
        Files.copy(in23, tempOutput, StandardCopyOption.REPLACE_EXISTING);
      }
      if (i == 3)
      {
        Files.copy(in22, tempOutput, StandardCopyOption.REPLACE_EXISTING);
      }

      if (Desktop.isDesktopSupported())
      {
        if (desktop.isSupported(Desktop.Action.OPEN))
        {
          desktop.open(tempOutput.toFile());
        }
      }
    } catch (IOException ex)
    {
    }
  }
}
