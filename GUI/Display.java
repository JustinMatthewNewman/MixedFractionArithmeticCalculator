package GUI;

import java.awt.Image;
import java.awt.TextArea;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DisplayPanel.CompositePanel;
import DisplayPanel.RoundedPanel;

/**
 * Display.
 * 
 * @author justinnewman
 *
 */
public class Display
{
  private static RoundedPanel slideOutPanel;
  private static RoundedPanel backGround;
  private static CompositePanel r;
  private static TextArea textArea = new TextArea(18, 50);

  /**
   * Display constructor.
   * 
   * @param j
   */
  public Display(final JFrame j)
  {
    try
    {
      initialize(j);
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * 
   * @param frame
   * @throws IOException
   */
  private void initialize(final JFrame frame) throws IOException
  {

    RoundedPanel display = new RoundedPanel(10);
    display.setBackground(Settings.getDisplayColor());
    display.setBounds(28, 63, 367, 91);
    display.setBorder(null);
    frame.getContentPane().add(display);
    display.setLayout(null);

    r = new CompositePanel(frame, display);

    slideOutPanel = new RoundedPanel(10);
    slideOutPanel.setBounds(415, 167, 470, 328);
    slideOutPanel.setBackground(Settings.getDisplayColor());

    textArea.setEditable(false);
    textArea.setText("");

    backGround = new RoundedPanel(10);
    backGround.setBackground(Settings.getUi());
    backGround.setBounds(4, 4, 420, 526);

    JPanel logoPanel = new JPanel();
    logoPanel.setBounds(28, 6, 197, 64);
    logoPanel.setBackground(Settings.getUi());
    frame.getContentPane().add(logoPanel);

    ImageIcon icon = Settings.getImg();
    Image image = icon.getImage();
    int[] dimensions = scaleAlgo(icon.getIconWidth(), icon.getIconHeight(),
        logoPanel.getWidth() - 30, logoPanel.getHeight() - 30);
    Image newimg = image.getScaledInstance(dimensions[0], dimensions[1],
        java.awt.Image.SCALE_SMOOTH); // scale it the
    // smooth way
    icon = new ImageIcon(newimg); // transform it back
    JLabel fragileIMG = new JLabel(icon);
    logoPanel.add(fragileIMG);
  }

  /**
   * 
   * Scale the image to fit panel.
   * 
   * @param w width
   * @param h height
   * @param panelW panel width
   * @param panelH panel height
   * @return the array of new dimensions
   */
  private int[] scaleAlgo(final int w, final int h, final int panelW, final int panelH)
  {
    int w2 = w;
    int h2 = h;
    int[] a = new int[2];
    while (w2 > panelW || h2 > panelH)
    {
      w2 = w2 - 15;
      h2 = h2 - 15;
    }
    a[0] = w2;
    a[1] = h2;
    return a;
  }

  /**
   * @return the textArea
   */
  public static TextArea getTextArea()
  {
    return textArea;
  }

  /**
   * @param val the textArea to set
   */
  public static void setTextArea(final String val)
  {
    textArea.setText(val);
  }

  /**
   * 
   * @return the slide out panel.
   */
  public static RoundedPanel getSlideOut()
  {
    return slideOutPanel;
  }

  /**
   * 
   * @return the background.
   */
  public static RoundedPanel getBack()
  {
    return backGround;
  }

  /**
   * 
   */
  public static void reset()
  {
    r.reset();
    textArea.setText("");
  }

  /**
   * 
   * @return the Composite Display panel.
   */
  public CompositePanel getRationalPanel()
  {
    return r;
  }
}

