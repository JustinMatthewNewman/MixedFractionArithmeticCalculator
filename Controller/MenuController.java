
package Controller;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import DisplayPanel.SlideOutPanel;
import GUI.About;
import GUI.AnimatedPanel;
import GUI.Display;
import GUI.FragileMenu;
import GUI.PieChartDisplayer;
import HTML.HelpPage;
import IntermediateValues.EnglishSteps;
import IntermediateValues.FrenchSteps;
import IntermediateValues.SpanishSteps;
import math.Equation;
import utilities.FileReader;
import utilities.Playback;
import utilities.Printer;
import utilities.Record;
import utilities.SliderHandler;

/**
 * Fragile Calculator Menu Controls.
 * 
 * Dr. David Bernstein, MIT, Princeton, JMU Ph.D., University of Pennsylvania, 1990 M.P.A.,
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
public class MenuController extends Controller implements ActionListener
{

  public static final String EXIT = "Exit";
  public static final String SIMPLIFIED = "Simplified";
  public static final String IRREDUCED = "Irreduced";
  public static final String BAR = "bar";
  public static final String SLASH = "slash";
  public static final String SOLIDUS = "solidus";
  

  private AnimatedPanel slider2 = 
      new AnimatedPanel(FragileController.getHistory().getPanel(), frame, 1);
  private boolean closed = true;

  /**
   * 
   * @param equation is the object holding reference to the fraction rational objects.
   * @param frame is the main frame.
   * @param panel is the display panel
   * @param in is the textfield for keylistener
   * @param playback
   */
  public MenuController(final Equation equation, final JFrame frame, final Display panel,
      final JTextField in, final Playback playback)
  {
    super(equation, panel, frame, in, playback);
  }

  /**
   * 
   */
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    switch (e.getActionCommand()) 
    {
      case ("New"):
      case ("Nuevo"):
      case ("Nouveau"):
        reset();
        break;
      case (EXIT):
      case ("Salida"):
      case ("Sortir"):
        System.exit(0);
        break;
      case ("Bar"):
        list[0].setStyle(BAR);
        list[1].setStyle(BAR);
        break;
      case ("Slash"):
      case ("Barra oblicua"):
      case ("Sabrer"):
        list[0].setStyle(SLASH);
        list[1].setStyle(SLASH);
        break;
      case ("Solidus"):
        list[0].setStyle(SOLIDUS);
        list[1].setStyle(SOLIDUS);
        break;
      case (SIMPLIFIED):
      case ("Simplificado"):
      case ("Simplifie"):
        if (FragileController.getMode() == 0)
        {
          setSimple();
          simple = true;
        }
        break;
      case (IRREDUCED):
      case ("Irreducido"):
      case ("Irreduit"):
        setIrreduced();
        simple = false;
        break;
      case ("About"):
      case ("Sobre"):
      case ("Sur"):
        new About(e.getActionCommand());
        break;
      case ("English"):
      case ("Ingles"):
      case ("Anglais"):
        FragileController.setLang(1);
        iv = new EnglishSteps(equation);
        FragileMenu.setLanguage(FragileController.getLang());
        break;
      case ("Spanish"):
      case ("Espanol"):
      case ("Espagnol"):
        FragileController.setLang(2);
        iv = new SpanishSteps(equation);
        FragileMenu.setLanguage(FragileController.getLang());
        break;
      case ("French"):
      case ("Frances"):
      case ("Francais"):
        FragileController.setLang(3);
        iv = new FrenchSteps(equation);
        FragileMenu.setLanguage(FragileController.getLang());
        break;
  
      case ("Launch Our Help Page"):
        try
        {
          new HelpPage(1);
        } catch (URISyntaxException e1)
        {
          e1.printStackTrace();
        }
        break;
      case ("Inicie Nuestra Pagina De Ayuda"):
        try
        {
          new HelpPage(2);
        } catch (URISyntaxException e1)
        {
          e1.printStackTrace();
        }
        break;
      case ("Lancer Notre Page D'Aide"):
        try
        {
          new HelpPage(3);
        } catch (URISyntaxException e1)
        {
          e1.printStackTrace();
        }
        break;
      case ("Print"):
      case ("Impresion"):
      case ("Imprimer"):
        new Printer(playback).actionPerformed(e);
        break;
      case ("Pie Chart"):
        new PieChartDisplayer(equation);
        break;
      case ("History"):
      case ("Historia"):
      case ("Histoire"):
        historyWindow();
        break;
      case (".PNG"):
        imageRender("png");
        break;
      case (".JPG"):
        imageRender("jpg");
        break;
      case (".TXT"):
        try
        {
          new Record("txt", playback);
        } catch (IOException e2)
        {
          e2.printStackTrace();
        }
        break;
      case (".FRA"):
        try
        {
          new Record("fra", playback);
        } catch (IOException e2)
        {
          e2.printStackTrace();
        }
        break;
      case ("Mixed Number"):
      case ("Numero mixto"):
      case ("Numero mixte"):
        setMode(0);
        break;
      case ("Fraction"):
      case ("Fraccion"):
        setMode(1);
        break;
      case ("Copy"):
      case ("Dupdo"):
      case ("Copie"):
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String text = FragileController.getHistory().getTextArea().getSelectedText();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
        break;
      case ("Paste"):
      case ("Pegar"):
      case ("La Colle"):
        paste();
        break;
      case ("Start"):
      case ("Debut"):
        try
        {
          playback.start();
        } catch (InterruptedException e1)
        {
          e1.printStackTrace();
        }
        break;
      case ("Stop"):
      case ("Parada"):
      case ("Arreter"):
        playback.stop();
        break;
      case ("Controls"):
      case ("Les Controles"):
        sliderDriver(playback);
        break;
      case("Import"):
        try
        {
          importer();
        } catch (IOException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        break;
      default:
    }
    keyInput.requestFocusInWindow();
  }

  private void importer() throws IOException
  {
    JFrame f;
    f = new JFrame();
    f.setSize(400, 200);
    JFileChooser jfc;
    jfc = new JFileChooser();
    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    jfc.showOpenDialog(f);
    String set = new FileReader().readInPath(jfc.getSelectedFile().getAbsolutePath());
    FragileController.getHistory().setText(set);
    playback.setEquations(new FileReader().parseFile(set).getRecording());
  }

  private void imageRender(final String string)
  {
    PieChartDisplayer pie2 = new PieChartDisplayer(equation);
    BufferedImage image2 = new BufferedImage(pie2.getMainPanel().getWidth(),
        pie2.getMainPanel().getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = image2.createGraphics();
    pie2.getMainPanel().printAll(g2);
    g2.dispose();
    try
    {
      JFrame f;
      f = new JFrame();
      f.setSize(400, 200);
      JFileChooser jfc;
      jfc = new JFileChooser();
      jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      jfc.showOpenDialog(f);
      ImageIO.write(image2, string,
          new File(jfc.getSelectedFile().toString() + "/PieChart." + string));
    } catch (IOException exp)
    {
      exp.printStackTrace();
    }
  }

  /**
   * Launch history window.
   */
  private void historyWindow()
  {
    FragileController.getHistory().setText(playback.getRecord().getStorageString());
    if (closed)
    {
      slider2.showAt(frame.getX(), frame.getY() + 572);
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
      frame.addComponentListener(slider2);
      closed = false;
    } else
    {
      slider2.close();
      closed = true;
    }
  }

  /**
   * 
   * @param playback
   */
  private void sliderDriver(final Playback playback)
  {
    Container contentPane;
    JFrame frame;
    JSlider slider;
    frame = new JFrame("Playback speed");
    // Get the content pane
    contentPane = frame.getContentPane();
    contentPane.setLayout(null);
    // Construct the widgets/components
    slider = new JSlider(1, 101, 50);
    // Layout the content pane
    contentPane.add(slider);
    slider.setBounds(60, 20, 290, 30);
    // Setup the observer
    SliderHandler handler = new SliderHandler(playback);
    slider.addChangeListener(handler);
    frame.setSize(400, 100);
    frame.setVisible(true);
  }

  /**
   * 
   * @param i
   */
  private void setMode(final int i)
  {
    FragileController.setMode(i);
    equation.setMode(FragileController.getMode());
    list[equation.getOperandFocus()].setMode(FragileController.getMode());
  }

  /**
   * Gets the slide out panel.
   * 
   * @return the slide out panel
   */
  public SlideOutPanel getSp2()
  {
    return FragileController.getHistory();
  }


  /**
   * Gets the animated panel.
   * 
   * @return the animated panel
   */
  public AnimatedPanel getSlider2()
  {
    return slider2;
  }

  /**
   * Sets the animated panel.
   * 
   * @param slider2 the animated panel to set
   */
  public void setSlider2(final AnimatedPanel slider2)
  {
    this.slider2 = slider2;
  }
}

