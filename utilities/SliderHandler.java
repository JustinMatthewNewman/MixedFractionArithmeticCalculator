package utilities;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Controls speed of Playback.
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
public class SliderHandler implements ChangeListener
{

  private Playback playback;

  /**
   * This is the constructor for SliderHnadler and initializes a playback object with the given
   * playback.
   * 
   * @param playback
   */
  public SliderHandler(final Playback playback)
  {

    this.playback = playback;
  }

  /**
   * This is the method that deals with slider changes.
   * 
   * @param event change event
   */
  public void stateChanged(final ChangeEvent event)
  {
    int value;
    JSlider source;

    source = (JSlider) event.getSource();
    value = source.getValue();

    playback.stop();
    playback.setSpeed(value * 50);
    try
    {
      if (playback.pointer > 1)
      {
        playback.setPointer(playback.getPointer() - 1);
        playback.start();
      }
    } catch (InterruptedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
