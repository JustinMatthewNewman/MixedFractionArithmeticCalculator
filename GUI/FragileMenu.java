package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Controller.MenuController;

/**
 * Menu Bar.
 * 
 * @author justinnewman
 *
 */
public class FragileMenu
{

  private static JMenu menu;
  private static JMenu subMenu1;
  private static JMenu subMenu2;
  private static JMenuItem item;
  private static JFrame frame;
  private static MenuController controller;
  
  private static String start = "Start";
  private static String png = ".PNG";
  private static String jpg = ".JPG";
  private static String txt = ".TXT";
  private static String fra = ".FRA";
  private static String controls = "Controls";
  private static String mode = "Mode";
  private static String fraction = "Fraction";
  
  private static String bar = "Bar";
  private static String slash = "Slash";
  private static String solidus = "Solidus";

  /**
   * Menu Constructor.
   * 
   * @param frame
   * @param controller
   */
  public FragileMenu(final JFrame frame, final MenuController controller)
  {
    FragileMenu.controller = controller;
    FragileMenu.frame = frame;
    setLanguage(1);
  }

  /**
   * 
   * @param a is the language to set.
   * 
   * 1 = English
   * 2 = Spanish
   * 3 = French
   * 
   */
  public static void setLanguage(final int a)
  {
    if (a == 1)
    {
      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);

      // FILE
      menu = new JMenu("File");
      menuBar.add(menu);
      item = new JMenuItem("New");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("Print");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("Import");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      subMenu1 = new JMenu("Export");
      subMenu2 = new JMenu("PieChart");
      item = new JMenuItem(png);
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem(jpg);
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu1.add(subMenu2);
      subMenu1.addSeparator();
      item = new JMenuItem(txt);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(fra);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      menu.add(subMenu1);
      menu.addSeparator();
      item = new JMenuItem("Exit");
      item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
      item.addActionListener(controller);
      menu.add(item);
      // EDIT
      menu = new JMenu("Edit");
      menuBar.add(menu);
      item = new JMenuItem("Copy");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("Paste");
      item.addActionListener(controller);
      menu.add(item);
      // VIEW
      menu = new JMenu("View");
      menuBar.add(menu);
      subMenu1 = new JMenu("Playback");
      item = new JMenuItem(start);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem("Stop");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(controls);
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);
      // SETTINGS
      menu = new JMenu("Settings");
      menuBar.add(menu);
      subMenu1 = new JMenu(mode);
      item = new JMenuItem("Mixed Number");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(fraction);
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);

      menu.addSeparator();
      subMenu1 = new JMenu("Type Format");
      item = new JMenuItem(bar);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(slash);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(solidus);
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);
      menu.addSeparator();
      subMenu2 = new JMenu("Result Value");
      item = new JMenuItem("Simplified");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("Irreduced");
      item.addActionListener(controller);
      subMenu2.add(item);
      menu.add(subMenu2);
      menu.addSeparator();
      subMenu2 = new JMenu("Language");
      item = new JMenuItem("English");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("French");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("Spanish");
      item.addActionListener(controller);
      subMenu2.add(item);
      menu.add(subMenu2);
      // WINDOW
      menu = new JMenu("Window");
      menuBar.add(menu);
      item = new JMenuItem("Pie Chart");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("History");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("About");
      item.addActionListener(controller);
      menu.add(item);
      // HELP
      menu = new JMenu("Help");
      menuBar.add(menu);
      item = new JMenuItem("Launch Our Help Page");
      item.addActionListener(controller);
      menu.add(item);
    }
    if (a == 2)
    {
      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);

      // FILE
      menu = new JMenu("Expediente");
      menuBar.add(menu);
      item = new JMenuItem("Nuevo");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("Impresion");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      subMenu1 = new JMenu("Exportar");
      subMenu2 = new JMenu("GraficoCircular");
      item = new JMenuItem(png);
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem(jpg);
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu1.add(subMenu2);
      subMenu1.addSeparator();
      item = new JMenuItem(txt);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(fra);
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);
      menu.addSeparator();
      item = new JMenuItem("Salida");
      item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
      item.addActionListener(controller);
      menu.add(item);
      // EDIT
      menu = new JMenu("Editar");
      menuBar.add(menu);
      item = new JMenuItem("Dupdo");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("Pegar");
      item.addActionListener(controller);
      menu.add(item);
      // VIEW
      menu = new JMenu("Vista");
      menuBar.add(menu);
      subMenu1 = new JMenu("Reproduccion");
      item = new JMenuItem(start);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem("Parada");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(controls);
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);
      // SETTINGS
      menu = new JMenu("Ajustes");
      menuBar.add(menu);
      subMenu1 = new JMenu("Modo");
      item = new JMenuItem("Numero mixto");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem("Fraccion");
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);

      menu.addSeparator();
      subMenu1 = new JMenu("Formato de tipo");
      item = new JMenuItem(bar);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(slash);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem("Barra oblicua");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(solidus);
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);
      menu.addSeparator();
      subMenu2 = new JMenu("Valor de resultado");
      item = new JMenuItem("Simplificado");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("Irreducido");
      item.addActionListener(controller);
      subMenu2.add(item);
      menu.add(subMenu2);
      menu.addSeparator();
      subMenu2 = new JMenu("Idioma");
      item = new JMenuItem("Ingles");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("Frances");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("Espanol");
      item.addActionListener(controller);
      subMenu2.add(item);
      menu.add(subMenu2);
      // WINDOW
      menu = new JMenu("Ventana");
      menuBar.add(menu);
      item = new JMenuItem("Historia");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("Sobre");
      item.addActionListener(controller);
      menu.add(item);
      // HELP
      menu = new JMenu("Ayudar");
      menuBar.add(menu);
      item = new JMenuItem("Inicie Nuestra Pagina De Ayuda");
      item.addActionListener(controller);
      menu.add(item);
    }
    if (a == 3)
    {
      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);

      // FILE
      menu = new JMenu("Deposer");
      menuBar.add(menu);
      item = new JMenuItem("Nouveau");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("Imprimer");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      subMenu1 = new JMenu("Exportation");
      subMenu2 = new JMenu("DiagrammeCirculaire");
      item = new JMenuItem(png);
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem(jpg);
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu1.add(subMenu2);
      subMenu1.addSeparator();
      item = new JMenuItem(txt);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(fra);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      menu.add(subMenu1);
      menu.addSeparator();
      item = new JMenuItem("Sortir");
      item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
      item.addActionListener(controller);
      menu.add(item);
      // EDIT
      menu = new JMenu("editer");
      menuBar.add(menu);
      item = new JMenuItem("Copie");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("La Colle");
      item.addActionListener(controller);
      menu.add(item);
      // VIEW
      menu = new JMenu("Vue");
      menuBar.add(menu);
      subMenu1 = new JMenu("Relecture");
      item = new JMenuItem("Debut");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem("Arreter");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem("Les Controles");
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);
      // SETTINGS
      menu = new JMenu("Parametres");
      menuBar.add(menu);
      subMenu1 = new JMenu(mode);
      item = new JMenuItem("Numero mixte");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(fraction);
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);

      menu.addSeparator();
      subMenu1 = new JMenu("Type de format");
      item = new JMenuItem(bar);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(slash);
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem("Sabrer");
      item.addActionListener(controller);
      subMenu1.add(item);
      subMenu1.addSeparator();
      item = new JMenuItem(solidus);
      item.addActionListener(controller);
      subMenu1.add(item);
      menu.add(subMenu1);
      menu.addSeparator();
      subMenu2 = new JMenu("Valeur Du Resultat");
      item = new JMenuItem("Simplifie");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("Irreduit");
      item.addActionListener(controller);
      subMenu2.add(item);
      menu.add(subMenu2);
      menu.addSeparator();
      subMenu2 = new JMenu("Langue");
      item = new JMenuItem("Anglais");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("Francais");
      item.addActionListener(controller);
      subMenu2.add(item);
      subMenu2.addSeparator();
      item = new JMenuItem("Espagnol");
      item.addActionListener(controller);
      subMenu2.add(item);
      menu.add(subMenu2);
      // WINDOW
      menu = new JMenu("Fenetre");
      menuBar.add(menu);
      item = new JMenuItem("Histoire");
      item.addActionListener(controller);
      menu.add(item);
      menu.addSeparator();
      item = new JMenuItem("Sur");
      item.addActionListener(controller);
      menu.add(item);
      // HELP
      menu = new JMenu("Aider");
      menuBar.add(menu);
      item = new JMenuItem("Lancer Notre Page D'Aide");
      item.addActionListener(controller);
      menu.add(item);
    }
  }
}
