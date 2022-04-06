package GUI;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;

import utilities.FileReader;

/**
 * Fragile Calculator.
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
public class Settings
{
  private static ImageIcon img;
  private static Color ui;
  private static Color displayColor;
  private String logo = "LOGO =";
  private String display = "DISPLAY =";
  private String defaultPath = "/icons/" + "Fragile_Logo.png";
  private String newLine = "\n";

  /**
   * 
   */
  public Settings()
  {
    String settings = "";
    try
    {
      settings = new FileReader().readIn("/jarStream/" + "file.txt");
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (!settings.contains(logo))
    {
      URL url = this.getClass().getResource(defaultPath);
      img = new ImageIcon(url);
    } else
    {
      try
      {
        parseLogo(settings);
      } catch (IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    if (!settings.contains(display))
    {
      displayColor = new Color(230, 248, 250);
      ui = new Color(238, 238, 238);
    } else
    {
      parseSettings(settings);
    }

  }

  /**
   * 
   * @param actual
   */
  private void parseSettings(final String actual)
  {
    String right = "]";
    String left = "[";
    
    Scanner in = new Scanner(actual);
    in.useDelimiter(newLine);
    while (in.hasNext())
    {
      String a = in.next();
      if (a.contains("UI ="))
      {
        String line = (a.substring(a.indexOf(left) + 1, a.indexOf(right)));
        try
        {
          ui = parseColor(line);
        } catch (NumberFormatException w)
        {
          ui = new Color(238, 238, 238);
        }
      }
      if (a.contains(display))
      {
        String line = (a.substring(a.indexOf(left) + 1, a.indexOf(right)));
        try
        {
          displayColor = parseColor(line);
        } catch (NumberFormatException w)
        {
          displayColor = new Color(230, 248, 250);
        }
      }
    }
    in.close();
  }

  private Color parseColor(final String line)
  {
    String r = "r";
    String g = "g";
    String b = "b";
    int r1 = Integer.parseInt(line.substring(line.indexOf(r) + 2, line.indexOf(g) - 1));
    int g1 = Integer.parseInt(line.substring(line.indexOf(g) + 2, line.indexOf(b) - 1));
    int b1 = Integer.parseInt(line.substring(line.indexOf(b) + 2, line.length()));
    return new Color(r1, g1, b1);
  }

  private void parseLogo(final String file) throws IOException
  {
    Scanner in = new Scanner(file);
    String path = defaultPath;
    in.useDelimiter(newLine);
    while (in.hasNext())
    {
      String p = in.next();
      if (p.contains(logo))
      {
        path = p.substring(p.indexOf("=") + 1, p.length());
      }
    }
    img = new ImageIcon(path);
    in.close();
  }



  /**
   * 
   * @return display Color.
   */
  public static Color getDisplayColor()
  {
    return displayColor;
  }

  /**
   * 
   * @return UI color.
   */
  public static Color getUi()
  {
    return ui;
  }

  /**
   * 
   * @return image Icon.
   */
  public static ImageIcon getImg()
  {
    return img;
  }
}
