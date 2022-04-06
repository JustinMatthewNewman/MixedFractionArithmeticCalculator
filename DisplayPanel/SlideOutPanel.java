package DisplayPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.Box;
import javax.swing.SwingConstants;

import GUI.Settings;

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
public class SlideOutPanel
{
  RoundedPanel slideOutPanel;
  TextArea textArea = new TextArea(30, 25);

  /**
   * SlideOut Constructor.
   */
  public SlideOutPanel()
  {
    slideOutPanel = new RoundedPanel(20);
    slideOutPanel.setBackground(Settings.getDisplayColor());
    slideOutPanel.setLayout(new BorderLayout());
    textArea.setEditable(false);
    textArea.setText("");
    Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
    slideOutPanel.add(rigidArea, BorderLayout.NORTH);

    Component rigidArea1 = Box.createRigidArea(new Dimension(20, 20));
    slideOutPanel.add(rigidArea1, BorderLayout.SOUTH);

    Component rigidArea2 = Box.createRigidArea(new Dimension(20, 20));
    slideOutPanel.add(rigidArea2, BorderLayout.WEST);

    Component rigidArea3 = Box.createRigidArea(new Dimension(20, 40));
    slideOutPanel.add(rigidArea3, BorderLayout.EAST);

    slideOutPanel.add(textArea, SwingConstants.CENTER);
  }

  /**
   * 
   * @return the slideOutPanel.
   */
  public RoundedPanel getPanel()
  {
    return slideOutPanel;
  }

  /**
   * 
   * @param text to set in the Text area.
   */
  public void setText(final String text)
  {
    textArea.setText(text);
  }

  /**
   * 
   * @return the textArea.
   */
  public TextArea getTextArea()
  {
    return textArea;
  }

}
