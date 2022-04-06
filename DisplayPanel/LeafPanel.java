package DisplayPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import GUI.Settings;

/**
 * Fragile Calculator Leaf Rational panel.
 * 
 *  Dr. David Bernstein, MIT, Princeton, JMU
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
public class LeafPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  String tnr = "Times New Roman";
  Font bigFont = new Font(tnr, Font.BOLD, 16);
  Font smallFont = new Font(tnr, Font.PLAIN, 13);
  
  String bar = "bar";
  String slash = "slash";
  String solidus = "solidus";
  String space = " ";
  String sl = "/";
  String hyphen = "-";

  
  private String style;
  private JLabel[] individual;
  private JPanel fractionalPane;
  private JPanel unitPanel;
  private Border border = BorderFactory.createEtchedBorder();
  private int mode = 0;

  /**
   * UNIT = 0, NUMERATOR = 1, DENOMINATOR = 2, BAR = 3.
   * 
   * @param panel to add the leaf to.
   */
  public LeafPanel(final JPanel panel)
  {
    setBackground(Settings.getDisplayColor());
    panel.add(this);
    setLayout(new GridLayout(0, 2, 0, 0));
    this.individual = new JLabel[4];
    unitPanel = new JPanel();
    unitPanel.setBackground(Settings.getDisplayColor());
    add(unitPanel);
    unitPanel.setLayout(new BorderLayout(0, 0));
    individual[0] = new JLabel(space);
    individual[0].setHorizontalAlignment(SwingConstants.CENTER);
    individual[0].setBorder(null);
    individual[0].setBackground(Settings.getDisplayColor());
    individual[0].setFont(bigFont);
    unitPanel.add(individual[0], BorderLayout.CENTER);
    fractionalPane = new JPanel();
    fractionalPane.setBackground(Settings.getDisplayColor());
    add(fractionalPane);
    fractionalPane.setLayout(null);
    JPanel numPane = new JPanel();
    numPane.setBackground(Settings.getDisplayColor());
    fractionalPane.add(numPane);
    numPane.setLayout(new BorderLayout(0, 0));
    individual[1] = new JLabel(space);
    individual[1].setBorder(null);
    individual[1].setBackground(Settings.getDisplayColor());
    individual[1].setFont(smallFont);
    numPane.add(individual[1], BorderLayout.CENTER);
    JPanel barSlashPanel = new JPanel();
    barSlashPanel.setBackground(Settings.getDisplayColor());
    fractionalPane.add(barSlashPanel);
    barSlashPanel.setLayout(new BorderLayout(0, 0));
    individual[3] = new JLabel(space);
    individual[3].setHorizontalAlignment(SwingConstants.CENTER);
    individual[3].setBorder(null);
    individual[3].setBackground(Settings.getDisplayColor());
    barSlashPanel.add(individual[3], BorderLayout.CENTER);
    JPanel denPanel = new JPanel();
    denPanel.setBackground(Settings.getDisplayColor());
    fractionalPane.add(denPanel);
    denPanel.setLayout(new BorderLayout(0, 0));
    individual[2] = new JLabel(space);
    individual[2].setBorder(null);
    individual[2].setBackground(Settings.getDisplayColor());
    individual[2].setFont(smallFont);
    denPanel.add(individual[2], BorderLayout.CENTER);
    style = bar;
    setStyle(style);
    clearBar();
  }

  /**
   * 
   * Sets the style of panel, for example Bar style, Solidus style, Slash style.
   * 
   * @param style2 is the string style
   */
  public void setStyle(final String style2)
  {
    this.style = style2;
    if (style.equals(bar))
    {
      fractionalPane.setLayout(new GridLayout(3, 1, 0, 0));
      individual[1].setHorizontalAlignment(SwingConstants.CENTER);
      individual[2].setHorizontalAlignment(SwingConstants.CENTER);
      setBar();
    }
    if (style.equals(solidus))
    {
      fractionalPane.setLayout(new GridLayout(3, 1, 0, 0));
      individual[1].setHorizontalAlignment(SwingConstants.LEFT);
      individual[2].setHorizontalAlignment(SwingConstants.RIGHT);
      setBar();
    }
    if (style.equals(slash))
    {
      fractionalPane.setLayout(new GridLayout(1, 3, 0, 0));
      individual[1].setHorizontalAlignment(SwingConstants.LEFT);
      individual[2].setHorizontalAlignment(SwingConstants.RIGHT);
      setBar();
    }

  }

  /**
   * Set the bar depending on the current style.
   */
  public void setBar()
  {
    if (!individual[1].getText().equals(space) && !individual[2].getText().equals(space))
    {
      if (style.equals(bar))
      {
        individual[3].setText(hyphen);
      }
      if (style.equals(solidus))
      {
        individual[3].setText(sl);
      }
      if (style.equals(slash))
      {
        individual[3].setText(sl);
      }
    } else
    {
      individual[3].setText(space);
    }

  }

  /**
   * set the highlight as focus indication.
   * 
   * @param a is the index of element in focus (for example: unit = 0, numerator = 1)
   */
  public void setHighLight(final int a)
  {
    // clear all borders.
    individual[0].setBorder(null);
    individual[1].setBorder(null);
    individual[2].setBorder(null);
    // mode is fraction/Mixednumber mode
    // mode 0 is mixedNumber mode
    if (mode == 0)
    {
      if (a == 0)
      {
        individual[0].setBorder(border);
      }
      if (a == 1)
      {
        individual[1].setBorder(border);
      }
      if (a == 2)
      {
        individual[2].setBorder(border);
      }
    } else
    { // mode 1 is fraction mode.
      if (a == 0)
      {
        individual[0].setBorder(null);
        individual[1].setBorder(border);
      }
      if (a == 1)
      {
        individual[1].setBorder(border);
      }
      if (a == 2)
      {
        individual[2].setBorder(border);
      }
    }
  }

  /**
   * Clear the border, also known as the focus.
   */
  public void clearFocus()
  {
    individual[0].setBorder(null);
    individual[1].setBorder(null);
    individual[2].setBorder(null);
  }

  /**
   * Clear the whole leaf panel.
   */
  public void clear()
  {
    individual[0].setText(space);
    individual[1].setText(space);
    individual[3].setText(space);
    individual[2].setText(space);
    setHighLight(0);
  }

  /**
   * reset the whole panel and clear the focus border.
   * 
   * used by Composite Rational panel.
   * 
   */
  public void reset()
  {
    clear();
    clearFocus();
  }

  /**
   * 
   */
  public void clearBar()
  {
    individual[3].setText(space);
  }

  /**
   * 
   */
  public void negate()
  {
    if (individual[0].getText().contains(hyphen))
    {
      individual[0]
          .setText((individual[0].getText().substring(1, individual[0].getText().length())));
    } else
    {
      individual[0].setText((hyphen + individual[0].getText()));
    }
  }

  /**
   * @return the individual
   */
  public JLabel[] getIndividual()
  {
    return individual;
  }

  /**
   * 
   * @param mode
   */
  public void setMode(final int mode)
  {
    this.mode = mode;
    setHighLight(mode);
  }

}
