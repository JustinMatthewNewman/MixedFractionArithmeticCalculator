package GUI;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

/**
 * Fragile Calculator.
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
public class About extends JFrame implements ActionListener
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  String san = "Sans Serif";
  Font small = new Font(san, Font.PLAIN, 10);
  Font large = new Font(san, Font.BOLD, 16);
  String buttonText = "OK";

  /**
   * 
   * @param language to use.
   */
  public About(final String language)
  {
    super();
    instantiate(language);
  }


  /**
   * 
   * @param language to use.
   */
  private void instantiate(final String language)
  {
    GridBagConstraints gbc;
    GridBagLayout gbl;
    JButton button;
    JLabel label;
    JTextArea text;

    setBounds(200, 200, 400, 200);
    setResizable(false);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    getContentPane().setLayout(null);
    setVisible(true);
    gbl = new GridBagLayout();
    setLayout(gbl);

    label = new JLabel("Fragile", JLabel.CENTER);
    label.setFont(large);
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 100;
    gbc.weighty = 0;
    gbl.setConstraints(label, gbc);
    add(label);

    text = new JTextArea(20, 20);
    text.setEditable(false);
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.gridheight = 3;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.weightx = 100;
    gbc.weighty = 100;
    gbl.setConstraints(text, gbc);

    String aboutText = null;
    switch (language) 
    {
      case ("About"):
        aboutText = "Fragile was created by SagaciousMedia. "
            + "SagaciousMedia is a business\ncommitted to"
            + " creating quality educational products. Designed to excite\nand educate students,"
            + " to inspite and assist instructors, and to help\nadministrators.";
        // Talk about the features for a little bit
        break;
      case ("Sobre"):
        aboutText = "Sp";
        break;
      case ("Sur"):
        aboutText = "Fr";
        break;
      default:
    }

    text.append(aboutText);
    add(text);

    label = new JLabel("Copyright, Fragile by SagaciousMedia");
    label.setFont(small);
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.WEST;
    gbl.setConstraints(label, gbc);
    add(label);

    button = new JButton(buttonText);
    button.addActionListener(this);
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.EAST;
    gbl.setConstraints(button, gbc);
    add(button);

  }

  /**
   * Action performed after pressing OK button.
   * @param evt is the event.
   */
  public void actionPerformed(final ActionEvent evt)
  {
    String command;

    command = evt.getActionCommand();
    if (command.equals(buttonText))
      setVisible(false);
  }

}
