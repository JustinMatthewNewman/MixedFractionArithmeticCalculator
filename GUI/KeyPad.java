package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.KeyPadController;


/**
 * KeyPad for all Buttons.
 * @author justinnewman
 *
 */
public class KeyPad extends JPanel
{ 
  private static final long serialVersionUID = 1L;
  private static JButton expandButton;
  private static final Font BUTTON_FONT = new Font("DejaVu Sans", Font.PLAIN, 12);
  private ActionListener controller;
  

  /**
   * 
   * @param j
   * @param c
   */
  public KeyPad(final JFrame j, final KeyPadController c)
  {
    this.controller = c;
    initialize(j);
  }

  /**
   * 
   * @param frame
   */
  private void initialize(final JFrame frame)
  {
    setLayout(null);
    setBounds(28, 161, 348, 345);
    frame.getContentPane().add(this);
    setupLayoutNumberPad();
    setupLayoutOperatorsPanel();
    setupLayoutZedPanel();
    setupLayoutExpandStepsPanel(frame);
    this.setBackground(Settings.getUi());
  }
  

  /**
   * 
   * @param text
   * @param a
   * @param j
   */
  private void addButton(final String text, final Color a, final JPanel j)
  {
    JButton button;
    button = new JButton(text);
    button.setFont(BUTTON_FONT);
    button.setForeground(a);
    button.addActionListener(controller);
    j.add(button);
  }

  /**
   * Setup and layout this NumberPad.
   */
  private void setupLayoutNumberPad()
  {
    JPanel numberpad = new JPanel();
    numberpad.setBounds(0, 0, 208, 276);
    add(numberpad);
    numberpad.setLayout(new GridLayout(4, 3));
    numberpad.setBackground(Settings.getUi());
    Color gold = new Color(205, 133, 63);
    addButton("\u00B1", gold, numberpad);
    addButton("C", gold, numberpad);
    addButton("\u2190", gold, numberpad);
    for (int i = 1; i <= 9; i++)
      addButton(String.format("%1d", i), Color.BLACK, numberpad);

  }

  /**
   * 
   */
  private void setupLayoutOperatorsPanel()
  {
    Color blue = new Color(30, 144, 255);
    JPanel operatorsPanel = new JPanel();
    operatorsPanel.setBounds(210, 0, 139, 345);
    add(operatorsPanel);
    operatorsPanel.setLayout(new GridLayout(5, 2));
    operatorsPanel.setBackground(Settings.getUi());
    addButton("+", blue, operatorsPanel);
    addButton("R", blue, operatorsPanel);
    addButton("-", blue, operatorsPanel);
    addButton("Inv", blue, operatorsPanel);
    addButton("\u00D7", blue, operatorsPanel);
    addButton("^", blue, operatorsPanel);
    addButton("\u00F7", blue, operatorsPanel);
    addButton("\u21B9", blue, operatorsPanel);
    addButton("=", blue, operatorsPanel);
    addButton("\u211A", blue, operatorsPanel);
  }

  /**
   * 
   */
  private void setupLayoutZedPanel()
  {
    JPanel focusZed = new JPanel();
    focusZed.setLayout(null);
    focusZed.setBounds(0, 277, 208, 69);
    focusZed.setBackground(Settings.getUi());
    add(focusZed);
    JButton btnNewButton0 = new JButton("0");
    btnNewButton0.setBounds(0, 0, 139, 69);
    btnNewButton0.addActionListener(controller);
    focusZed.add(btnNewButton0);
    JButton focus = new JButton("|");
    focus.setBounds(139, 0, 69, 69);
    focus.addActionListener(controller);
    focusZed.add(focus);
  }

  /**
   * 
   * @param frame
   */
  private void setupLayoutExpandStepsPanel(final JFrame frame)
  {
    String checkStyleBS = ">";
    JPanel expandButonPanel = new JPanel();
    expandButonPanel.setBackground(Settings.getUi());
    expandButonPanel.setBounds(382, 301, 32, 64);
    frame.getContentPane().add(expandButonPanel);
    expandButonPanel.setLayout(new BorderLayout(0, 0));
    expandButton = new JButton(checkStyleBS);
    getExpandButton().setForeground(new Color(211, 211, 211));
    expandButonPanel.add(getExpandButton(), BorderLayout.CENTER);
    getExpandButton().addActionListener(controller);
  }

  /**
   * 
   * @return the expansion button.
   */
  public static JButton getExpandButton()
  {
    return expandButton;
  }

}

