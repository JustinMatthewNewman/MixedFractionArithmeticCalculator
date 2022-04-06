package jarStream;

import javax.swing.*;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.Box;

import javax.swing.JButton;
import java.awt.GridLayout;

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
public class JarExport extends JFrame implements ActionListener
{
  static JProgressBar b;
  private static final long serialVersionUID = 1L;
  
  String targetPath = null;
  private String dot = ".";

  /**
   * 
   * @throws IOException
   */
  public JarExport() throws IOException
  {
    PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(
        new java.io.File(dot).getAbsolutePath() + "/bin/jarStream/" + "file.txt")), true);

    System.setOut(out);

    setTitle("Fragile.jar Product owner export");
    setBounds(100, 100, 610, 140);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
    add(rigidArea, BorderLayout.WEST);

    Component rigidArea1 = Box.createRigidArea(new Dimension(20, 20));
    add(rigidArea1, BorderLayout.EAST);

    Component rigidArea2 = Box.createRigidArea(new Dimension(20, 20));
    add(rigidArea2, BorderLayout.NORTH);

    Component rigidArea3 = Box.createRigidArea(new Dimension(20, 20));
    add(rigidArea3, BorderLayout.SOUTH);

    JPanel panel = new JPanel();
    add(panel, BorderLayout.CENTER);
    panel.setLayout(null);

    JPanel panel1 = new JPanel();
    panel1.setBounds(10, 30, 540, 40);
    panel.add(panel1);
    panel1.setLayout(new GridLayout(1, 0, 0, 0));

    JButton logo = new JButton("LOGO");
    panel1.add(logo);
    logo.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        JFrame f;
        int retval;
        JFileChooser jfc;

        f = new JFrame();
        f.setSize(400, 200);

        jfc = new JFileChooser();
        retval = jfc.showOpenDialog(f);

        if (retval == JFileChooser.APPROVE_OPTION)
        {
          System.out.println("LOGO =" + jfc.getSelectedFile().getAbsolutePath());
        }
        b.setValue(b.getValue() + 20);

      }
    });

    JButton color = new JButton("COLOR");
    panel1.add(color);
    color.addActionListener(new ActionListener()
    {

      public void actionPerformed(final ActionEvent e)
      {
        JFrame f;
        Color color;

        f = new JFrame();
        f.setSize(400, 200);

        color = JColorChooser.showDialog(f, "Choose a color for the UI", new Color(255, 255, 255));

        if (color != null)
        {
          System.out.println("UI =" + color);
          // Display.setColor1(color);
        }

        JFrame f2;
        Color color2;

        f2 = new JFrame();
        f2.setSize(400, 200);

        color2 = JColorChooser.showDialog(f, "Choose a color for the Display Field",
            new Color(255, 255, 255));

        if (color2 != null)
        {
          System.out.println("DISPLAY =" + color2);
          // Display.setColor2(color2);
        }
        b.setValue(b.getValue() + 20);
      }
    });

    JButton location = new JButton("LOCATION");
    panel1.add(location);
    location.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        JFrame f;
        int retval;
        JFileChooser jfc;

        f = new JFrame();
        f.setSize(400, 200);

        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        retval = jfc.showOpenDialog(f);

        if (retval == JFileChooser.APPROVE_OPTION)
        {
          System.out.println("EXPORT =" + jfc.getSelectedFile());
          targetPath = jfc.getSelectedFile().toString() + "/Fragile.jar";
        }
        b.setValue(b.getValue() + 20);

      }
    });

    JButton export = new JButton("EXPORT");
    panel1.add(export);

    JPanel imagePanel = new JPanel();
    imagePanel.setBounds(7, 7, 540, 20);
    panel.add(imagePanel);
    imagePanel.setLayout(new BorderLayout(0, 0));

    Component rigidArea7 = Box.createRigidArea(new Dimension(20, 20));
    imagePanel.add(rigidArea7, BorderLayout.WEST);

    Component rigidArea8 = Box.createRigidArea(new Dimension(20, 20));
    imagePanel.add(rigidArea8, BorderLayout.EAST);

    export.addActionListener(this);

    JPanel p = new JPanel();

    // create a progressbar
    b = new JProgressBar();
    b.setPreferredSize(new Dimension(400, 15));
    // set initial value
    b.setValue(0);

    b.setStringPainted(true);

    // add progressbar
    p.add(b);

    // add panel
    imagePanel.add(p, BorderLayout.SOUTH);

    setVisible(true);
  }


  /**
   * Increase progress.
   */
  public static void fill()
  {
    int i = b.getValue();
    while (i <= 100)
    {
      // fill the menu bar
      b.setValue(i + 1);
      i += 1;
    }
  }

  /**
   * 
   * @param args cmd
   */
  public static void main(final String[] args)
  {
    try
    {
      new JarExport();
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * @param e event.
   */
  public void actionPerformed(final ActionEvent e)
  {
    String file1ToCompile = "src" + java.io.File.separator + "app" + java.io.File.separator
        + "Fragile.java";
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    int compilationResult = compiler.run(null, null, null, file1ToCompile);
    if (compilationResult == 0)
    {
      System.out.println("Compilation is successful");
    } else
    {
      System.out.println("Compilation Failed");
    }
    Manifest manifest = new Manifest();
    manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
    manifest.getMainAttributes().put(Attributes.Name.CLASS_PATH, dot);
    manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, "app.Fragile");
    try
    {
      JarOutputStream target = new JarOutputStream(new FileOutputStream(targetPath), manifest);
      String path = new java.io.File(dot).getCanonicalPath() + "/bin";
      walk(path, target);
      target.close();
    } catch (IOException ex)
    {
      return;
    }
    fill();
    JFrame frame = new JFrame();
    frame.setBounds(200, 200, 95, 70);
    JPanel jp = new JPanel(new BorderLayout());
    jp.add(new JLabel("      Success!"), BorderLayout.NORTH);
    JButton bt = new JButton("ok");
    bt.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        frame.dispose();
        dispose();
      }
    });
    jp.add(bt, BorderLayout.CENTER);
    frame.add(jp);
    frame.setVisible(true);
    frame.setResizable(false);
  }

  /**
   * 
   * @param path
   * @param target
   * @throws IOException
   */
  public void walk(final String path, final JarOutputStream target) throws IOException
  {

    File root = new File(path);
    File[] list = root.listFiles();

    if (list == null)
      return;

    for (File f : list)
    {
      if (f.isDirectory())
      {
        walk(f.getAbsolutePath(), target);
      } else
      {
        add(f.getAbsoluteFile(), target);

      }
    }
  }

  /**
   * 
   * @param source
   * @param target
   * @throws IOException
   */
  private void add(final File source, final JarOutputStream target) throws IOException
  {
    BufferedInputStream in = null;
    try
    {
      if (source.isDirectory())
      {
        String name = source.getPath().replace("\\", java.io.File.separator);
        if (!name.isEmpty())
        {
          if (!name.endsWith(java.io.File.separator))
            name += java.io.File.separator;
          JarEntry entry = new JarEntry(name);
          entry.setTime(source.lastModified());
          target.putNextEntry(entry);
          target.closeEntry();
        }
        for (File nestedFile : source.listFiles())
          add(nestedFile, target);
        return;
      }

      JarEntry entry = null;
      String ap = source.getParent();
      String parentDirectoy = ap.substring(ap.indexOf("bin/") + 4, ap.length());
      entry = new JarEntry(parentDirectoy + java.io.File.separator + source.getName());
      entry.setTime(source.lastModified());
      target.putNextEntry(entry);
      in = new BufferedInputStream(new FileInputStream(source));
      byte[] buffer = new byte[1024];
      while (true)
      {
        int count = in.read(buffer);
        if (count == -1)
          break;
        target.write(buffer, 0, count);
      }
      target.closeEntry();
    } finally
    {
      if (in != null)
        in.close();
    }
  }
}
