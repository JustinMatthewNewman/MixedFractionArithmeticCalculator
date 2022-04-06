package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * Fragile Calculator.
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
public class AnimatedPanel extends Object implements ComponentListener
{

  protected static final int ANIMATION_TIME = 800;
  protected static final float ANIMATION_TIME_F = (float) ANIMATION_TIME;
  protected static final int ANIMATION_DELAY = 50;

  JDialog window;
  JComponent contents;
  AnimatingSheet animatingSheet;
  Rectangle desktopBounds;
  Dimension tempWindowSize;
  Timer animationTimer;
  JFrame frame;
  int showX, showY, startX, startY;
  int type;
  long animationStart;
  int dx;
  boolean opening;

  /**
   * 
   */
  public AnimatedPanel()
  {
    initDesktopBounds();

  }

  /**
   * 
   * @param contents
   * @param frame
   * @param type
   */
  public AnimatedPanel(final JComponent contents, final JFrame frame, final int type)
  {
    this();
    setContents(contents);
    this.type = type;
    this.frame = frame;
    if (type == 1)
    {
      dx = -245;
    } else
    {
      dx = 444;
    }
  }

  /**
   * 
   */
  protected void initDesktopBounds()
  {
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    desktopBounds = env.getMaximumWindowBounds();
  }

  /**
   * 
   * @param contents
   */
  public void setContents(final JComponent contents)
  {
    this.contents = contents;
    JWindow tempWindow = new JWindow();
    tempWindow.getContentPane().add(contents);
    tempWindow.pack();
    tempWindowSize = tempWindow.getSize();
    tempWindow.getContentPane().removeAll();
    window = new JDialog();
    window.setUndecorated(true);
    animatingSheet = new AnimatingSheet();
    animatingSheet.setSource(contents);
    window.getContentPane().add(animatingSheet);
  }

  /**
   * 
   */
  public void close()
  {
    window.dispose();
  }

  /**
   * 
   * @param x
   * @param y
   */
  public void showAt(final int x, final int y)
  {
    // create a window with an animating sheet
    // copy over its contents from the temp window
    // animate it
    // when done, remove animating sheet and add real contents

    showX = x;
    startY = y;

    ActionListener animationLogic = new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        // frame.setAlwaysOnTop(true);

        // RIGHT TO LEFT
        if (type == 1)
        {
          long elapsed = System.currentTimeMillis() - animationStart;
          if (elapsed > ANIMATION_TIME)
          {
            // put real contents in window and show
            window.getContentPane().removeAll();
            window.getContentPane().add(contents);
            window.setLocation(showX - 247, startY - window.getSize().height);
            window.setVisible(true);
            window.repaint();
            animationTimer.stop();
            animationTimer = null;
          } else
          {

            // calculate % done
            float progress = (float) elapsed / ANIMATION_TIME_F;
            // get height to show
            int animatingHeight = (int) (tempWindowSize.getHeight());
            animatingSheet.setAnimatingHeight(animatingHeight);

            int animatingW = (int) (progress * tempWindowSize.getWidth());
            animatingW = Math.max(animatingW, 1);
            animatingSheet.setAnimatingWidth(animatingW);

            window.pack();
            window.setLocation(showX - animatingW, startY - window.getSize().height);
            window.setVisible(true);
            window.repaint();
          }
        } else
        { // LEFT TO RIGHT
          long elapsed = System.currentTimeMillis() - animationStart;
          if (elapsed > ANIMATION_TIME)
          {
            // put real contents in window and show
            window.getContentPane().removeAll();
            window.getContentPane().add(contents);
            window.setLocation(showX, startY - window.getSize().height);
            window.setVisible(true);
            window.repaint();
            animationTimer.stop();
            animationTimer = null;
          } else
          {
            // calculate % done
            float progress = (float) elapsed / ANIMATION_TIME_F;
            // get height to show
            int animatingHeight = (int) (tempWindowSize.getHeight());
            animatingSheet.setAnimatingHeight(animatingHeight);

            int animatingW = (int) (progress * tempWindowSize.getWidth());
            animatingW = Math.max(animatingW, 1);
            animatingSheet.setAnimatingWidth(animatingW);

            window.pack();
            window.setLocation(showX, startY - window.getHeight());
            window.setVisible(true);
            window.repaint();
          }
        }
      }

    };
    animationTimer = new Timer(ANIMATION_DELAY, animationLogic);
    animationStart = System.currentTimeMillis();
    animationTimer.start();
  }

  /**
   * 
   * @author justinnewman
   *
   */
  class AnimatingSheet extends JPanel
  {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Dimension animatingSize = new Dimension(0, 1);
    JComponent source;
    BufferedImage offscreenImage;

    /**
     * 
     */
    public AnimatingSheet()
    {
      super();
      setOpaque(false);
    }

    /**
     * 
     * @param animatingW
     */
    public void setAnimatingWidth(final int animatingW)
    {
      animatingSize.width = animatingW;
      setSize(animatingSize);

    }

    /**
     * 
     * @param source
     */
    public void setSource(final JComponent source)
    {
      this.source = source;
      animatingSize.width = source.getWidth();
      makeOffscreenImage(source);
    }

    /**
     * 
     * @param height
     */
    public void setAnimatingHeight(final int height)
    {
      animatingSize.height = height;
      setSize(animatingSize);
    }

    /**
     * 
     * @param sourceOf the component.
     */
    private void makeOffscreenImage(final JComponent sourceOf)
    {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsConfiguration gfxConfig = ge.getDefaultScreenDevice().getDefaultConfiguration();
      offscreenImage = gfxConfig.createCompatibleImage(sourceOf.getWidth(), sourceOf.getHeight());
      Graphics2D offscreenGraphics = (Graphics2D) offscreenImage.getGraphics();
      // windows workaround
      offscreenGraphics.setColor(sourceOf.getBackground());
      offscreenGraphics.fillRect(0, 0, sourceOf.getWidth(), sourceOf.getHeight());
      // paint from source to offscreen buffer
      source.paint(offscreenGraphics);
    }

    /**
     * @return the preferred Size.
     */
    public Dimension getPreferredSize()
    {
      return animatingSize;
    }

    /**
     * @return the minimum size.
     */
    public Dimension getMinimumSize()
    {
      return animatingSize;
    }

    /**
     * @return the max size.
     */
    public Dimension getMaximumSize()
    {
      return animatingSize;
    }

    /**
     * @param g is the graphics object.
     */
    public void update(final Graphics g)
    {
      // override to eliminate flicker from
      // unneccessary clear
      paint(g);
    }

    /**
     * @param g is the graphics object.
     */
    public void paint(final Graphics g)
    {
      // get the top-most n pixels of source and
      // paint them into g, where n is height
      // (different from sheet example, which used bottom-most)
      BufferedImage fragment = offscreenImage.getSubimage(source.getX(), source.getY(),
          source.getWidth(), animatingSize.height);
      g.drawImage(fragment, 0, 0, this);
    }

  }

  /**
   * @param e is the component event.
   */
  @Override
  public void componentResized(final ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  /**
   * @param e is the component event.
   */
  @Override
  public void componentMoved(final ComponentEvent e)
  {
    Point p = frame.getLocation();
    p.x = p.x + dx;
    p.y = frame.getY() + 67;
    window.setLocation(p);

  }

  /**
   * @param e is the component event.
   */
  @Override
  public void componentShown(final ComponentEvent e)
  {
    window.setVisible(true);
  }

  /**
   * @param e is the component event.
   */
  @Override
  public void componentHidden(final ComponentEvent e)
  {
    window.setVisible(false);
  }
}
