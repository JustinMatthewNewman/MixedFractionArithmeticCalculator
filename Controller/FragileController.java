package Controller;

import javax.swing.JFrame;
import javax.swing.JTextField;

import DisplayPanel.SlideOutPanel;
import GUI.Display;
import GUI.FragileMenu;
import GUI.KeyPad;
import math.Equation;
import math.Rational;
import utilities.Playback;
import utilities.Recording;

/**
 * Fragile Controller.
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
public class FragileController
{
  // EQUATION RESULT
  protected static Rational result;
  // LANG SETTING
  protected static int lang = 1;
  // MODE SELECTION SETTING
  protected static int mode = 0;
  protected static Recording record = new Recording();
  protected static Playback playback;

  private static SlideOutPanel steps;
  private static SlideOutPanel history;

  /**
   * Constructor of the Fragile Controller Class.
   * 
   * @param frame
   */
  public FragileController(final JFrame frame)
  {
    // HOLD EQUATION IN MEMORY
    Equation eq = new Equation();
    // SET UP DISPLAY PANEL
    Display panel = new Display(frame);
    playback = new Playback(panel.getRationalPanel(), record);
    // SET UP TEXTFIELD FOR KEYBOARD INPUT
    JTextField in = new JTextField();
    // CREATE A KEYBOARD CONTOLLER WITH REFERENCE TO EQUATION
    steps = new SlideOutPanel();
    history = new SlideOutPanel();
    // MAIN FRAME, DISPLAY PANEL, AND KEY INPUT FIELD
    new KeyBoardController(eq, frame, panel, in, playback);
    // CREATE A KEYPAD CONTOLLER FOR BUTTONS WITH REFERENCE TO EQUATION
    // MAIN FRAME, DISPLAY PANEL, AND KEY INPUT FIELD
    KeyPadController keypadController = new KeyPadController(eq, frame, panel, in, playback);
    // CREATE A MENU CONTOLLER WITH REFERENCE TO EQATION
    // MAIN FRAME, DISPLAY PANEL, AND KEY INPUT FIELD
    MenuController menuController = new MenuController(eq, frame, panel, in, playback);
    // SETUP BUTTONS AND MENU IN THE GUI
    new KeyPad(frame, keypadController);
    frame.getContentPane().add(Display.getBack());
    new FragileMenu(frame, menuController);
  }

  /**
   * Gets the slide out panel.
   * 
   * @return the slide out panel
   */
  public static SlideOutPanel getSteps()
  {
    return steps;
  }

  /**
   * Gets the history slide out panel.
   * 
   * @return the history slide out panel
   */
  public static SlideOutPanel getHistory()
  {
    return history;
  }
  
  /**
   * 
   * @param a
   */
  public static void setResult(final Rational a)
  {
    result = a;
  }

  /**
   * Returns the result of a calculation.
   * 
   * @return the result of a calculation
   */
  public static Rational getResult()
  {
    return result;
  }

  /**
   * Returns the language to be used.
   * 
   * @return the lang
   */
  public static int getLang()
  {
    return lang;
  }

  /**
   * Sets the language to use.
   * 
   * @param lang the lang to set
   */
  public static void setLang(final int lang)
  {
    FragileController.lang = lang;
  }

  /**
   * Returns the mode currently being used.
   * 
   * @return the mode
   */
  public static int getMode()
  {
    return mode;
  }

  /**
   * Sets the current mode.
   * 
   * @param mode the mode to set
   */
  public static void setMode(final int mode)
  {
    FragileController.mode = mode;
  }
}
