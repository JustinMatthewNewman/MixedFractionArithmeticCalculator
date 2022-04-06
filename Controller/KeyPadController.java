package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import GUI.AnimatedPanel;
import GUI.Display;
import GUI.KeyPad;
import math.Equation;
import utilities.Playback;

/**
 * Fragile Calculator Keypad Controls.
 * 
 * Dr. David Bernstein, MIT, Princeton, JMU. Ph.D., University of Pennsylvania, 1990 M.P.A.,
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
public class KeyPadController extends Controller implements ActionListener
{
  
  public static final String LESS = "<";
  public static final String MORE = ">";
  private static AnimatedPanel slider;

  /**
   * 
   * @param equation
   * @param frame
   * @param panel
   * @param in
   * @param playback
   */
  public KeyPadController(final Equation equation, final JFrame frame, final Display panel,
      final JTextField in, final Playback playback)
  {
    super(equation, panel, frame, in, playback);
  }

  /**
   * Action.
   */
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    switch (e.getActionCommand()) 
    {
      case (POSNEG):
        posNeg();
        break;
      case (CLEAR):
        clear();
        break;
      case (BACK):
        removeDigit();
        break;
      case ("1"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("2"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("3"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("4"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("5"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("6"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("7"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("8"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("9"):
        setDigit(e.getActionCommand().toString());
        break;
      case ("0"):
        setDigit(e.getActionCommand().toString());
        break;
      case (FOCUS):
        focus();
        break;
      case (PLUS):
        operator(PLUS, PLUS);
        break;
      case (MINUS):
        operator(MINUS, MINUS);
        break;
      case (TIMES):
        operator(TIMES, "*");
        break;
      case (DIVIDE):
        operator(DIVIDE, "/");
        break;
      case (INVERSE):
        playback.getRecord().add(equation);
        String a = equation.getOperator();
        equation.setOperator("i");
        inv();
        equation.setOperator(a);
        playback.getRecord().add(equation);
        break;
      case (POWER):
        operator(POWER, POWER);
        break;
      case (MEDIANT):
        operator(MEDIANT, "m");
        break;
      case (FAREY):
        operator(FAREY, "f");
        break;
      case (EQUAL):
        equalButton();
        break;
      case (RESET):
        reset();
        break;
      case (LESS):
        KeyPad.getExpandButton().setText(MORE);
        slider.close();
        break;
      case (MORE):
        expandSteps();
        break;
      default:
    }
    keyInput.requestFocusInWindow();
  }

  /**
   * 
   */
  private void expandSteps()
  {
    KeyPad.getExpandButton().setText(LESS);

    slider = new AnimatedPanel(FragileController.getSteps().getPanel(), frame, 2);
    slider.showAt(frame.getX() + 444, frame.getY() + 572);
    // HANDLE MINIMIZING WINDOW
    frame.addWindowStateListener(new WindowStateListener()
    {
      boolean c = true;

      public void windowStateChanged(final WindowEvent arg0)
      {
        if (c)
        {
          slider.componentHidden(arg0);
          c = false;
        } else
        {
          slider.componentShown(arg0);
          c = true;
        }
      }
    });
    frame.addComponentListener(slider);
  }

  /**
   * Flips the sign of the current term.
   */
  private void posNeg()
  {
    int operand = equation.getOperandFocus();
    if (operand == 0)
    {
      equation.getNumbers()[0].negate();
      list[0].negate();
    } else
    {
      equation.getNumbers()[1].negate();
      list[1].negate();
    }
  }



}
