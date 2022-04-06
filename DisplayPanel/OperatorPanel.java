package DisplayPanel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GUI.Settings;

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
public class OperatorPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  private JTextField operatorLabel;

  /**
   * Operator panel contructor.
   * 
   * @param panel to be added to.
   */
  public OperatorPanel(final JPanel panel)
  {
    super();
    setBackground(Settings.getDisplayColor());
    panel.add(this);
    setLayout(new GridLayout(0, 1, 0, 0));
    operatorLabel = new JTextField("");
    operatorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
    operatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
    operatorLabel.setBorder(null);
    operatorLabel.setEditable(false);
    operatorLabel.setBackground(Settings.getDisplayColor());
    operatorLabel.setRequestFocusEnabled(false);
    add(operatorLabel);
  }

  /**
   * Set the operator.
   * 
   * @param a is the String to set (EX. + - * / ^ Inv)
   */
  public void setOperator(final String a)
  {
    operatorLabel.setText(a);
  }

  /**
   * Clear the operator text in composite panel.
   */
  void clear()
  {
    operatorLabel.setText("");
  }

  /**
   * reset the operator panel.
   */
  public void reset()
  {
    clear();
  }

}
