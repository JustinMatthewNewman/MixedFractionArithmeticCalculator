package DisplayPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;

import javax.swing.JPanel;

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
public class RoundedPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  private Color backgroundColor = new Color(.0f,.0f,.0f,.0f );
  private int cornerRadius = 15;

  /**
   * Rounded Panel constructor.
   * @param layout manager
   * @param radius integer
   */
  public RoundedPanel(final LayoutManager layout, final int radius)
  {
    super(layout);
    cornerRadius = radius;
  }

  /**
   * Rounded Panel constructor.
   * @param layout manager
   * @param radius integer
   * @param bgColor color
   */
  public RoundedPanel(final LayoutManager layout, final int radius, final Color bgColor)
  {
    super(layout);
    cornerRadius = radius;
    backgroundColor = bgColor;
  }

  /**
   * Rounded Panel constructor.
   * @param radius integer
   */
  public RoundedPanel(final int radius)
  {
    super();
    cornerRadius = radius;
  }

  /**
   * Rounded Panel constructor.
   * @param radius integer
   * @param bgColor color
   */
  public RoundedPanel(final int radius, final Color bgColor)
  {
    super();
    cornerRadius = radius;
    backgroundColor = bgColor;
  }

  /**
   * 
   */
  @Override
  protected void paintComponent(final Graphics g)
  {
    super.paintComponent(g);
    Dimension arcs = new Dimension(cornerRadius, cornerRadius);
    int width = getWidth();
    int height = getHeight();
    Graphics2D graphics = (Graphics2D) g;
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Draws the rounded panel with borders.
    if (backgroundColor != null)
    {
      graphics.setColor(backgroundColor);
    } else
    {
      graphics.setColor(getBackground());
    }
    graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint
                                                                                  // background
    graphics.setColor(getForeground());
    graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint border
  }
}
