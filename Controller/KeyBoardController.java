package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import GUI.Display;
import math.*;
import utilities.Playback;

/**
 * Fragile Calculator Keyboard controls.
 * 
 * Owner Dr. David Bernstein, MIT, Princeton, JMU Ph.D., University of Pennsylvania, 1990 M.P.A.,
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
public class KeyBoardController extends Controller
{
  public static final String STAR = "*";

  /**
   * 
   * @param equation
   * @param frame
   * @param panel
   * @param in
   * @param playback
   * 
   */
  public KeyBoardController(final Equation equation, final JFrame frame, final Display panel,
      final JTextField in, final Playback playback)
  {
    super(equation, panel, frame, in, playback);
    frame.add(keyInput);
    KeyListener listener = new KeyListener()
    {
      @Override
      public void keyPressed(final KeyEvent event)
      {
        int keyCode = event.getKeyCode();
        switch (keyCode) 
        {
          case KeyEvent.VK_R:
            reset();
            break;
          case KeyEvent.VK_1:
          case KeyEvent.VK_NUMPAD1:
            setDigit(1 + "");
            break;
          case KeyEvent.VK_2:
          case KeyEvent.VK_NUMPAD2:
            setDigit(2 + "");
            break;
          case KeyEvent.VK_3:
          case KeyEvent.VK_NUMPAD3:
            setDigit(3 + "");
            break;
          case KeyEvent.VK_4:
          case KeyEvent.VK_NUMPAD4:
            setDigit(4 + "");
            break;
          case KeyEvent.VK_5:
          case KeyEvent.VK_NUMPAD5:
            setDigit(5 + "");
            break;
          case KeyEvent.VK_6:
          case KeyEvent.VK_NUMPAD6:
            if (event.isShiftDown())
            {
              operator(POWER, POWER);
            } else
            {
              setDigit(6 + "");
            }
            break;
          case KeyEvent.VK_7:
          case KeyEvent.VK_NUMPAD7:
            setDigit(7 + "");
            break;
          case KeyEvent.VK_8:
          case KeyEvent.VK_NUMPAD8:
            if (event.isShiftDown())
            {
              operator(TIMES, STAR);
            } else
            {
              setDigit(8 + "");
            }
            break;
          case KeyEvent.VK_9:
          case KeyEvent.VK_NUMPAD9:
            setDigit(9 + "");
            break;
          case KeyEvent.VK_BACK_SPACE:
          case KeyEvent.VK_DELETE:
            removeDigit();
            break;
          case KeyEvent.VK_PERIOD:
          case KeyEvent.VK_SPACE:
            focus();
            break;
          case KeyEvent.VK_MINUS:
          case KeyEvent.VK_SUBTRACT:
            operator(MINUS, MINUS);
            break;
          case KeyEvent.VK_SLASH:
          case KeyEvent.VK_DIVIDE:
            operator(DIVIDE, "/");
            break;
          case KeyEvent.VK_MULTIPLY:
            operator(TIMES, STAR);
            break;
          case KeyEvent.VK_F:
            operator(FAREY, "f");
            break;
          case KeyEvent.VK_M:
            operator(MEDIANT, "m");
            break;
          case KeyEvent.VK_I:
            String a = equation.getOperator();
            equation.setOperator("i");
            inv();
            equation.operandFocusForward();
            equation.setOperator(a);
            break;
          case KeyEvent.VK_PLUS:
            operator(PLUS, PLUS);
            break;
          case KeyEvent.VK_ENTER:
          case KeyEvent.VK_EQUALS:
            if (event.isShiftDown())
            {
              operator(PLUS, PLUS);
            } else
            {
              equalButton();
            }
            break;
          case KeyEvent.VK_V:
            if (event.isControlDown())
            {
              paste();
            }
            break;
          default:
            if (!event.isShiftDown() && !event.isControlDown())
              setDigit(0 + "");
        }
        keyInput.requestFocusInWindow();
      };

      @Override
      public void keyReleased(final KeyEvent event)
      {
        // do nothing
      }

      @Override
      public void keyTyped(final KeyEvent event)
      {
        // do nothing
      }
    };
    keyInput.addKeyListener(listener);
  }
}
