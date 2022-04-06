package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import math.Equation;
import math.Rational;

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
public class PieChartDisplayer extends JFrame
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private JPanel mainPanel;
  private Font font = new Font("Lucida Grande", Font.PLAIN, 21);
  private Border border = BorderFactory.createEtchedBorder();

  /**
   * 
   * @param equation holding fractions in memory.
   */
  public PieChartDisplayer(final Equation equation)
  {
    super();

    setBounds(840, 100, 805, 330);
    setResizable(false);
    getContentPane().setLayout(new GridLayout(1, 0));

    setLayout(new BorderLayout(0, 0));

    // MAIN PANEL
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout(0, 0));

    Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
    mainPanel.add(rigidArea, BorderLayout.WEST);

    Component rigidArea1 = Box.createRigidArea(new Dimension(20, 20));
    mainPanel.add(rigidArea1, BorderLayout.EAST);

    Component rigidArea2 = Box.createRigidArea(new Dimension(20, 20));
    mainPanel.add(rigidArea2, BorderLayout.NORTH);

    Component rigidArea3 = Box.createRigidArea(new Dimension(20, 20));
    mainPanel.add(rigidArea3, BorderLayout.SOUTH);

    JPanel insideMainPanel = new JPanel();
    mainPanel.add(insideMainPanel, BorderLayout.CENTER);
    insideMainPanel.setLayout(new GridLayout(0, 5, 0, 0));

    // LEFT PANEL
    JPanel leftPanel = new JPanel();
    leftPanel.setBorder(border);
    insideMainPanel.add(leftPanel);
    leftPanel.setLayout(new BorderLayout(0, 0));

    Component rigidArea4 = Box.createRigidArea(new Dimension(20, 20));
    leftPanel.add(rigidArea4, BorderLayout.WEST);

    Component rigidArea5 = Box.createRigidArea(new Dimension(20, 20));
    leftPanel.add(rigidArea5, BorderLayout.EAST);

    Component rigidArea6 = Box.createRigidArea(new Dimension(20, 20));
    leftPanel.add(rigidArea6, BorderLayout.NORTH);

    Component rigidArea7 = Box.createRigidArea(new Dimension(20, 20));
    leftPanel.add(rigidArea7, BorderLayout.SOUTH);

    JPanel innerLeftPanel = new JPanel();
    leftPanel.add(innerLeftPanel, BorderLayout.CENTER);
    innerLeftPanel.setLayout(new GridLayout(2, 0, 0, 0));

    JPanel leftPie = new JPanel();
    leftPie.setLayout(new GridLayout(1, 0, 0, 0));
    innerLeftPanel.add(leftPie);

    JPanel leftDotArray = new JPanel();
    innerLeftPanel.add(leftDotArray);
    leftDotArray.setLayout(new GridLayout(1, 0, 0, 0));

    // OPERATOR PANEL
    JPanel operatorPanel = new JPanel();
    insideMainPanel.add(operatorPanel);
    operatorPanel.setLayout(new BorderLayout(0, 0));

    JPanel innerOpPanel = new JPanel();
    operatorPanel.add(innerOpPanel, BorderLayout.CENTER);
    innerOpPanel.setLayout(new BorderLayout(0, 0));

    JLabel operatorLabel = new JLabel(equation.getOperator());
    operatorLabel.setFont(font);
    operatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
    innerOpPanel.add(operatorLabel, BorderLayout.CENTER);

    // CENTER PANEL
    JPanel centerPanel = new JPanel();
    centerPanel.setBorder(border);
    insideMainPanel.add(centerPanel);
    centerPanel.setLayout(new BorderLayout(0, 0));

    Component rigidArea16 = Box.createRigidArea(new Dimension(20, 20));
    centerPanel.add(rigidArea16, BorderLayout.NORTH);

    Component rigidArea17 = Box.createRigidArea(new Dimension(20, 20));
    centerPanel.add(rigidArea17, BorderLayout.WEST);

    Component rigidArea18 = Box.createRigidArea(new Dimension(20, 20));
    centerPanel.add(rigidArea18, BorderLayout.EAST);

    Component rigidArea19 = Box.createRigidArea(new Dimension(20, 20));
    centerPanel.add(rigidArea19, BorderLayout.SOUTH);

    JPanel innerCenterPanel = new JPanel();
    centerPanel.add(innerCenterPanel, BorderLayout.CENTER);
    innerCenterPanel.setLayout(new GridLayout(2, 0, 0, 0));

    JPanel centerPie = new JPanel();
    centerPie.setLayout(new GridLayout(1, 0, 0, 0));
    innerCenterPanel.add(centerPie);

    JPanel centerDotArray = new JPanel();
    innerCenterPanel.add(centerDotArray);
    centerDotArray.setLayout(new GridLayout(1, 0, 0, 0));

    // EQUAL PANEL
    JPanel equalPanel = new JPanel();
    insideMainPanel.add(equalPanel);
    equalPanel.setLayout(new BorderLayout(0, 0));

    JPanel innerEqualPanel = new JPanel();
    equalPanel.add(innerEqualPanel, BorderLayout.CENTER);
    innerEqualPanel.setLayout(new BorderLayout(0, 0));

    JLabel equalLabel = new JLabel("=");
    equalLabel.setFont(font);
    equalLabel.setHorizontalAlignment(SwingConstants.CENTER);
    innerEqualPanel.add(equalLabel, BorderLayout.CENTER);

    // RIGHT PANEL
    JPanel rightPanel = new JPanel();
    rightPanel.setBorder(border);
    insideMainPanel.add(rightPanel);
    rightPanel.setLayout(new BorderLayout(0, 0));

    Component rigidArea26 = Box.createRigidArea(new Dimension(20, 20));
    rightPanel.add(rigidArea26, BorderLayout.NORTH);

    Component rigidArea27 = Box.createRigidArea(new Dimension(20, 20));
    rightPanel.add(rigidArea27, BorderLayout.WEST);

    Component rigidArea28 = Box.createRigidArea(new Dimension(20, 20));
    rightPanel.add(rigidArea28, BorderLayout.EAST);

    Component rigidArea29 = Box.createRigidArea(new Dimension(20, 20));
    rightPanel.add(rigidArea29, BorderLayout.SOUTH);

    JPanel innerRightPanel = new JPanel();
    rightPanel.add(innerRightPanel, BorderLayout.CENTER);
    innerRightPanel.setLayout(new GridLayout(2, 0, 0, 0));

    JPanel rightPie = new JPanel();
    rightPie.setLayout(new GridLayout(1, 0, 0, 0));
    innerRightPanel.add(rightPie);

    JPanel rightDotArray = new JPanel();
    innerRightPanel.add(rightDotArray);

    getContentPane().add(mainPanel, BorderLayout.CENTER);

    Rational result;
    if (equation.computation().getElement()[1] > equation.computation().getElement()[2])
    {
      result = equation.computation().format();
    } else
    {
      result = equation.computation();
    }

    Integer op1unit = equation.getNumbers()[0].getElement()[0];
    Integer op1num = equation.getNumbers()[0].getElement()[1];
    Integer op1den = equation.getNumbers()[0].getElement()[2];

    Integer op2unit = equation.getNumbers()[1].getElement()[0];
    Integer op2num = equation.getNumbers()[1].getElement()[1];
    Integer op2den = equation.getNumbers()[1].getElement()[2];

    Integer resUnit = result.getElement()[0];
    Integer resNum = result.getElement()[1];
    Integer resDen = result.getElement()[2];

    if (op1num != null && op1den != null && op1num != 0)
    {
      leftPie.add(new MyComponent((double) op1num / op1den, leftPie.getBounds()));
    } else if (op1unit != null && op1unit != 0)
    {
      leftPie.add(new MyComponent(1, leftPie.getBounds()));
      op1unit--;
    }
    if (op2num != null && op2den != null && op2num != 0)
    {
      centerPie.add(new MyComponent((double) op2num / op2den, centerPie.getBounds()));
    } else if (op2unit != null && op2unit != 0)
    {
      centerPie.add(new MyComponent(1, centerPie.getBounds()));
      op2unit--;
    }

    if (resNum != null && resDen != null && resNum != 0)
    {
      rightPie.add(new MyComponent((double) resNum / resDen, rightPie.getBounds()));
    } else if (resUnit != null && resUnit != 0)
    {
      rightPie.add(new MyComponent(1, rightPie.getBounds()));
      resUnit--;
    }

    if (op1unit != null && op1unit != 0)
    {
      int length = (int) Math.sqrt(op1unit);

      if (op1unit > Math.pow(length, 2))
      {
        length++;
      }

      leftDotArray.setLayout(new GridLayout(length, length, 0, 0));
      for (int i = 0; i < op1unit; i++)
      {
        CirclePanel cp = new CirclePanel(op1unit, leftDotArray);
        leftDotArray.add(cp);
      }
    }

    if (op2unit != null && op2unit != 0)
    {
      int length = (int) Math.sqrt(op2unit);

      if (op2unit > Math.pow(length, 2))
      {
        length++;
      }

      centerDotArray.setLayout(new GridLayout(length, length, 0, 0));
      for (int i = 0; i < op2unit; i++)
      {
        CirclePanel cp = new CirclePanel(op2unit, centerDotArray);
        centerDotArray.add(cp);
      }
    }

    if (resUnit != null && resUnit != 0)
    {
      int length = (int) Math.sqrt(resUnit);

      if (resUnit > Math.pow(length, 2))
      {
        length++;
      }

      rightDotArray.setLayout(new GridLayout(length, length, 0, 0));
      for (int i = 0; i < resUnit; i++)
      {
        CirclePanel cp = new CirclePanel(resUnit, rightDotArray);
        rightDotArray.add(cp);
      }
    }
    setVisible(true);
  }

  /**
   * @return the mainPanel
   */
  public JPanel getMainPanel()
  {
    return mainPanel;
  }

  class Slice
  {
    double value;
    Color color;

    /**
     * 
     * @param v
     * @param c
     */
    public Slice(final double v, final Color c)
    {
      value = v;
      color = c;
    }
  }

  class MyComponent extends JComponent
  {
    /**
     * 
     */
    private static final long serialVersionUID = 8478272999609459063L;
    Slice[] slices;

    MyComponent(final double value, final Rectangle r)
    {
      slices = new Slice[2];
      slices[0] = new Slice(value * 100, Color.black);
      slices[1] = new Slice((1 - value) * 100, new Color(140, 7, 7));

      setBounds(r);
    }

    public void paint(final Graphics g)
    {
      drawPie((Graphics2D) g, getBounds(), slices);
    }

    void drawPie(final Graphics2D g, final Rectangle area, final Slice[] slicesPie)
    {
      double total = 0.0D;

      for (int i = 0; i < slicesPie.length; i++)
      {
        total += slicesPie[i].value;
      }
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slicesPie.length; i++)
      {
        startAngle = (int) (curValue * 360 / total);
        int arcAngle = (int) (slicesPie[i].value * 360 / total);
        g.setColor(slicesPie[i].color);
        g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
        curValue += slicesPie[i].value;
      }
    }
  }
}

class CirclePanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  Rectangle r;
  int n;

  /**
   * 
   * @param num
   * @param p
   */
  public CirclePanel(final int num, final JPanel p)
  {
    n = num;
    r = p.getBounds();
    setPreferredSize(new Dimension(r.width / n, r.height / n));
  }

  /**
   * @param gr is the graphics object.
   */
  public void paintComponent(final Graphics gr)
  {
    super.paintComponent(gr);

    // Determine the center of the panel
    int cntrX = getWidth() / 2;
    int cntrY = getHeight() / 2;

    // Calculate the radius
    int radius = getWidth() / 4;

    // Draw the Circle
    gr.setColor(new Color(140, 7, 7));
    gr.fillOval(cntrX - radius, cntrY - radius, 80 / n, 80 / n);
    gr.setColor(Color.black);
    gr.drawOval(cntrX - radius, cntrY - radius, 80 / n, 80 / n);
  }
}
