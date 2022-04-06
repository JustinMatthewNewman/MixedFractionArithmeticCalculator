package DisplayPanel;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.Settings;
import math.Equation;

/**
 * 
 * @author justinnewman
 *
 */
public class CompositePanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  private LeafPanel[] list;
  private LeafPanel leftFraction;
  private OperatorPanel operatorPanel;
  private LeafPanel rightFraction;

  /**
   * 
   * @param j
   * @param p
   */
  public CompositePanel(final JFrame j, final RoundedPanel p)
  {
    super();
    this.leftFraction = new LeafPanel(this);
    this.operatorPanel = new OperatorPanel(this);
    this.rightFraction = new LeafPanel(this);
    list = new LeafPanel[2];
    initialize(j, p);
  }

  /**
   * 
   * @param frame
   * @param display
   */
  private void initialize(final JFrame frame, final RoundedPanel display)
  {
    setBackground(Settings.getDisplayColor());
    setBounds(3, 3, 359, 84);
    display.add(this);
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    list[0] = leftFraction;
    list[1] = rightFraction;

  }

  /**
   * @return the leftFraction
   */
  public LeafPanel getLeftFraction()
  {
    return leftFraction;
  }

  /**
   * @return the operatorPanel
   */
  public OperatorPanel getOperatorPanel()
  {
    return operatorPanel;
  }

  /**
   * @return the rightFraction
   */
  public LeafPanel getRightFraction()
  {
    return rightFraction;
  }

  /**
   * 
   * @return the list of leaf panels in display
   */
  public LeafPanel[] getList()
  {
    return list;
  }

  /**
   * 
   */
  public void reset()
  {
    leftFraction.reset();
    operatorPanel.reset();
    rightFraction.reset();
  }

  /**
   * 
   * @param a is the left side operand
   * @param b is the right side operand
   */
  public void setStyle(final LeafPanel a, final LeafPanel b)
  {
    this.leftFraction = a;
    this.rightFraction = b;
    list[0] = leftFraction;
    list[1] = rightFraction;

  }

  /**
   * 
   * @param equation
   */
  public void setDisplay(final Equation equation)
  {
    if (equation.getNumbers()[0].getElement()[0] == null)
    {
      list[0].getIndividual()[0].setText("");
    } else
    {
      list[0].getIndividual()[0].setText(equation.getNumbers()[0].getElement()[0] + "");
    }
    if (equation.getNumbers()[0].getElement()[1] == null)
    {
      list[0].getIndividual()[1].setText("");
      list[0].clearBar();
    } else
    {
      list[0].getIndividual()[1].setText(equation.getNumbers()[0].getElement()[1] + "");
      list[0].setBar();
    }
    if (equation.getNumbers()[0].getElement()[2] == null)
    {
      list[0].getIndividual()[2].setText("");
    } else
    {
      list[0].getIndividual()[2].setText(equation.getNumbers()[0].getElement()[2] + "");
    }
    if (equation.getOperator() == null)
    {
      equation.setOperator("");
    } else
    {
      operatorPanel.setOperator(equation.getOperator());
    }
    if (equation.getNumbers()[1].getElement()[0] == null)
    {
      list[1].getIndividual()[0].setText("");
    } else
    {
      list[1].getIndividual()[0].setText(equation.getNumbers()[1].getElement()[0] + "");
    }
    if (equation.getNumbers()[1].getElement()[1] == null)
    {
      list[1].getIndividual()[1].setText("");
      list[1].clearBar();
    } else
    {
      list[1].getIndividual()[1].setText(equation.getNumbers()[1].getElement()[1] + "");
      list[1].setBar();
    }
    if (equation.getNumbers()[1].getElement()[2] == null)
    {
      list[1].getIndividual()[2].setText("");
    } else
    {
      list[1].getIndividual()[2].setText(equation.getNumbers()[1].getElement()[2] + "");
    }
  }
}
