package Controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import DisplayPanel.CompositePanel;
import DisplayPanel.LeafPanel;
import GUI.AnimatedPanel;
import GUI.Display;
import IntermediateValues.*;
import math.Equation;
import math.MixedNumber;
import math.Rational;
import utilities.Playback;

/**
 * Controller of fragile.
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
public abstract class Controller
{
  public static final String POSNEG = "\u00B1";
  public static final String CLEAR = "C";
  public static final String BACK = "\u2190";
  public static final String FOCUS = "|";
  public static final String PLUS = "+";
  public static final String MINUS = "-";
  public static final String TIMES = "\u00D7";
  public static final String DIVIDE = "\u00F7";
  public static final String EQUAL = "=";
  public static final String RESET = "R";
  public static final String INVERSE = "Inv";
  public static final String POWER = "^";
  public static final String MEDIANT = "\u21B9";
  public static final String FAREY = "\u211A";
  public static final String SPACE = " ";
  public static final String NULL = "null";

  protected CompositePanel compositePanel;
  protected JTextField keyInput;
  protected boolean simple = true;
  protected IntermediateValues iv;
  protected Display displayPanel;
  protected AnimatedPanel slider;
  protected JFrame frame;
  protected LeafPanel[] list;
  protected Equation equation;
  protected Playback playback;

  /**
   * 
   * Controller Constructor.
   * 
   * @param equation => the Equation object holding reference to all back end arithmetic
   * @param panel => the JPanel holding reference to all front end display entry
   * @param frame => the JFrame passed in from Application construction.
   * @param in => textField listening for all text input.
   * @param playback => the object holding reference to entry data for play back
   */
  public Controller(final Equation equation, final Display panel, final JFrame frame,
      final JTextField in, final Playback playback)
  {
    // Assign references
    this.frame = frame;
    this.displayPanel = panel;
    this.compositePanel = panel.getRationalPanel();
    this.slider = new AnimatedPanel();

    this.keyInput = in;
    keyInput.setBounds(0, 0, 0, 0);

    this.iv = new EnglishSteps(equation);
    this.list = compositePanel.getList();
    this.equation = equation;
    this.playback = playback;

    list[equation.getOperandFocus()].setHighLight(equation.getIndividualFocus());
  }

  /**
   * 
   * operator method for handling the result of pressing an operator button.
   * 
   * @param a is the symbol in the display
   * @param a2 is operator equation class.
   */
  protected void operator(final String a, final String a2)
  {
    if (equation.getNumbers()[0].entered())
    {
      // increment the focus to left side
      equation.operandFocusForward();
      // set the operator in memory
      equation.setOperator(a2);
      // set the operator in the display
      compositePanel.getOperatorPanel().setOperator(a);
      // set the focus to the unit of the fraction we are editing
      equation.setIndividualFocus(FragileController.getMode());
      // set the border of the current focus
      list[equation.getOperandFocus()].setHighLight(FragileController.getMode());
      // remove the previous border from the last component
      list[0].clearFocus();
      playback.getRecord().add(equation);
    }
  }

  /**
   * Set the calculator based on the side (left/right).
   * 
   * @param side 0 is left, side 1 is right.
   * @param result is the result of the computation
   */
  public void setCalculator(final int side, final Rational result)
  {
    // set the math in memory
    equation.getNumbers()[side].getElement()[0] = (result.getElement()[0]);
    equation.getNumbers()[side].getElement()[1] = (result.getElement()[1]);
    equation.getNumbers()[side].getElement()[2] = (result.getElement()[2]);
    // set the display
    String unit = "" + result.getElement()[0];
    String num = "" + result.getElement()[1];
    String den = "" + result.getElement()[2];
    list[side].getIndividual()[0].setText(unit);
    list[side].getIndividual()[1].setText(num);
    list[side].getIndividual()[2].setText(den);
    setNulltoBlank(unit, num, den, side);
  }

  /**
   * 
   * Display the result of an equation.
   * 
   */
  protected void displayResult()
  {
    // store the irreduced computed result in memory.
    Rational result = equation.computation();
    FragileController.setResult(result);
    // add the record to the registry
    playback.getRecord().add(equation);
    playback.getRecord().addString(equation);
    FragileController.getHistory().setText(playback.getRecord().getStorageString());
    // reset the components of the display.
    Display.reset();
    equation.setIndividualFocus(FragileController.getMode());
    equation.setOperandFocus(0);
    // check if the result was computed.
    if (FragileController.getResult() != null)
    {
      setLanguage();
      equation.clear();
      list[0].setHighLight(FragileController.getMode());
      setCalculator(0, result);
      resetFocus();
      playback.getRecord().add(equation);
    }
    if (simple)
    {
      setSimple();
    }
    // Set the mode of display
    if (FragileController.getMode() > 0)
    {
      setIrreduced();
    }
  }

  /**
   * Sets the current operand as the individual being visited.
   * 
   * @author Easton R
   * 
   * @param number
   * @param individual
   * @param operand
   * @param a
   */
  private void setIndividual(final Rational number, final int individual, final int operand,
      final String a)
  {
    list[operand].setHighLight(individual);
    list[operand].getIndividual()[individual]
        .setText((list[operand].getIndividual()[individual].getText() + a));
    if (number.getElement()[individual] == null)
    {
      number.getElement()[individual] = Integer.parseInt(a);
    } else
    {
      number.getElement()[individual] = Integer.parseInt("" + number.getElement()[individual] + a);
    }
    if (individual != 0)
    {
      list[operand].setBar();
    }
  }

  /**
   * Remove the digit.
   */
  public void removeDigit()
  {
    int individual = equation.getIndividualFocus();
    int operand = equation.getOperandFocus();
    if (operand == 0)
    {
      backspaceHelp(equation.getNumbers()[0], individual, operand);
    } else
    {
      backspaceHelp(equation.getNumbers()[1], individual, operand);
    }
    list[equation.getOperandFocus()].setHighLight(equation.getIndividualFocus());
  }

  /**
   * 
   * @author Easton R.
   * 
   * @param number
   * @param individual
   * @param operand
   */
  public void backspaceHelp(final Rational number, final int individual, final int operand)
  {
    list[operand].setHighLight(individual);
    String var = "";
    Boolean exp = list[operand].getIndividual()[individual].getText() == null
        || list[operand].getIndividual()[individual].getText().length() == 0
        || list[operand].getIndividual()[individual].getText().equals(SPACE);
    if (!exp)
    {
      var = list[operand].getIndividual()[individual].getText()
          .substring(0, list[operand].getIndividual()[individual].getText().length() - 1).trim();
    }
    if (individual == 0)
    { // whole number
      if (exp)
      {
        equation.individualFocusBackward();
      } else
      {
        list[operand].getIndividual()[individual].setText(var);
        if (var != null && !var.equals(""))
        {
          number.getElement()[individual] = (Integer.parseInt(var));
        } else
        {
          number.getElement()[individual] = (null);
        }
      }
    } else if (individual == 1)
    { // numerator
      helper(number, individual, operand, 2, exp, var);
    } else if (individual == 2)
    { // denominator
      helper(number, individual, operand, 1, exp, var);
    }
  }

  /**
   * BackspaceHelper helper method.
   * 
   * @author Easton R.
   * 
   * @param number
   * @param individual
   * @param operand
   * @param x
   * @param exp
   * @param var
   */
  private void helper(final Rational number, final int individual, final int operand, final int x,
      final Boolean exp, final String var)
  {
    if (exp)
    {
      equation.individualFocusBackward();
      if (list[operand].getIndividual()[x].getText() == null
          || list[operand].getIndividual()[x].getText().equals(""))
      {
        list[operand].clearBar();
      }
    } else
    {
      list[operand].getIndividual()[individual].setText(var);
      list[operand].setBar();
      if (var != null && !var.equals(""))
      {
        number.getElement()[individual] = (Integer.parseInt(var));
      } else
      {
        number.getElement()[individual] = (null);
        if (list[operand].getIndividual()[x].getText() == null
            || list[operand].getIndividual()[x].getText().equals(""))
        {
          list[operand].clearBar();
        }
      }
    }
  }

  /**
   * Set the language.
   */
  private void setLanguage()
  {
    // pass results to intermediate values.
    if (FragileController.getLang() == 1)
      iv = new EnglishSteps(equation);
    if (FragileController.getLang() == 2)
      iv = new SpanishSteps(equation);
    if (FragileController.getLang() == 3)
      iv = new FrenchSteps(equation);
  }

  /**
   * Set to Irreduced.
   */
  public void setIrreduced()
  {
    equation.clear();
    list[0].setHighLight(FragileController.getMode());
    Rational r = FragileController.getResult();
    setCalculator(0, r);
  }

  /**
   * Set to Simplified.
   */
  protected void setSimple()
  {
    Rational r = FragileController.getResult().format();
    equation.clear();
    list[0].setHighLight(FragileController.getMode());
    setCalculator(0, r);
  }

  /**
   * Checks if the components of the fraction are null sets them to blank if so.
   * 
   * @param unit
   * @param num
   * @param den
   * @param i
   */
  protected void setNulltoBlank(final String unit, final String num, final String den, final int i)
  {
    if (unit.contains(NULL))
    {
      list[i].getIndividual()[0].setText(SPACE);
    }
    if (num.contains(NULL) || den.contains(NULL))
    {
      list[i].getIndividual()[1].setText(SPACE);
      list[i].getIndividual()[2].setText(SPACE);
      list[i].clearBar();
    } else
    {
      list[i].setBar();
    }
  }

  /**
   * Sets the focus of the left and right fractions.
   * 
   * sets the focus of the individual component of the fraction (unit, num, den)
   * 
   * sets the border to the left fraction
   */
  public void resetFocus()
  {
    equation.setOperandFocus(0);
    equation.setIndividualFocus(FragileController.getMode());
    list[0].setHighLight(FragileController.getMode());
  }

  /**
   * Used to clear the current display.
   */
  protected void clear()
  {
    list[equation.getOperandFocus()].clear();
    if (equation.getOperandFocus() == 0)
    {
      reset();
    } else
    {
      equation.getNumbers()[1].getElement()[0] = (null);
      equation.getNumbers()[1].getElement()[1] = (null);
      equation.getNumbers()[1].getElement()[2] = (null);
      equation.setIndividualFocus(FragileController.getMode());
    }
  }

  /**
   * Updates the focus.
   */
  public void focus()
  {
    equation.individualFocusForward();
    list[equation.getOperandFocus()].setHighLight(equation.getIndividualFocus());
  }

  /**
   * resets both the display and the equation.
   */
  protected void reset()
  {
    Display.reset();
    resetFocus();
    equation.clear();
    playback.getRecord().clear();
    
  }

  /**
   * Checks if second fraction is in and then checks if first fraction is in.
   */
  protected void equalButton()
  {
    if (equation.getNumbers()[1].entered())
    {
      if (equation.getNumbers()[0].entered())
      {
        displayResult();
      }
    }
  }

  /**
   * Used to initiate inverse.
   */
  protected void inv()
  {
    Rational code = equation.computation();
    FragileController.setResult(code);
    if (equation.getOperandFocus() == 0)
    {
      setCalculator(0, code);
    } else
    {
      setCalculator(1, code);
    }
    FragileController.setResult(null);
  }

  /**
   * Set the digit.
   * 
   * @param a is the digit being set to
   */
  public void setDigit(final String a)
  {
    if (!a.equals(NULL))
    {
      int individual = equation.getIndividualFocus();
      int operand = equation.getOperandFocus();
      if (operand == 0)
      {
        setIndividual(equation.getNumbers()[0], individual, operand, a);
      } else
      {
        setIndividual(equation.getNumbers()[1], individual, operand, a);
      }
    }
  }

  /**
   * This method returns the desired JTextField.
   * 
   * @return the textField
   */
  public JTextField getTextField()
  {
    return keyInput;
  }

  /**
   * Paste the current clipboard item.
   * 
   *
   */
  public void paste()
  {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    DataFlavor flavor = DataFlavor.stringFlavor;
    if (clipboard.isDataFlavorAvailable(flavor))
    {
      try
      {
        String text = (String) clipboard.getData(flavor);

        text = text.trim();
        text = text.replace("/", SPACE);
        String[] userInputArray = text.split(SPACE);
        MixedNumber pastedFraction = new MixedNumber(userInputArray);
        if (equation.getNumbers()[equation.getOperandFocus()].getElement()[0] == null)
        { // checks if unit is null
          if (equation.getNumbers()[equation.getOperandFocus()].getElement()[1] == null)
          { // checks if num is null
            // when no unit and no numerator
            equation.setIndividualFocus(0);
            setDigit(pastedFraction.getElement()[0] + "");
            focus();
            setDigit(pastedFraction.getElement()[1] + "");
            focus();
            setDigit(pastedFraction.getElement()[2] + "");
          } else
          {
            // no unit but has a numerator
            equation.setIndividualFocus(0);
            setDigit(pastedFraction.getElement()[0] + "");

          }
        } else
        {
          if (equation.getNumbers()[equation.getOperandFocus()].getElement()[1] == null)
          {
            // has unit but no numerator
            equation.setIndividualFocus(1);
            setDigit(pastedFraction.getElement()[1] + "");
            focus();
            setDigit(pastedFraction.getElement()[2] + "");
          } else
          {
            // has unit and numerator
            if (userInputArray.length == 3)
            {
              clear();
              equation.setIndividualFocus(0);
              setDigit(pastedFraction.getElement()[0] + "");
              focus();
              setDigit(pastedFraction.getElement()[1] + "");
              focus();
              setDigit(pastedFraction.getElement()[2] + "");
            } else if (userInputArray.length == 2)
            {
              equation.setIndividualFocus(1);
              equation.getNumbers()[equation.getOperandFocus()].getElement()[1] = (null);
              equation.getNumbers()[equation.getOperandFocus()].getElement()[2] = (null);
              list[equation.getOperandFocus()].getIndividual()[1].setText(SPACE);
              list[equation.getOperandFocus()].getIndividual()[2].setText(SPACE);

              setDigit(pastedFraction.getElement()[1] + "");
              focus();
              setDigit(pastedFraction.getElement()[2] + "");
            } else
            {
              equation.setIndividualFocus(0);
              list[equation.getOperandFocus()].getIndividual()[0].setText(SPACE);
              equation.getNumbers()[equation.getOperandFocus()].getElement()[0] = (null);
              setDigit(pastedFraction.getElement()[0] + "");
            }
          }
        }
      } catch (NumberFormatException e)
      {
      }

      catch (UnsupportedFlavorException e)
      {
      } catch (IOException e)
      {
      }
    }
  }
}
