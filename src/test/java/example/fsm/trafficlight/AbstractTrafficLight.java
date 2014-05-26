/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.fsm.trafficlight;

import com.wixia.toolbox.fsm.Transition;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author safi
 */
public abstract class AbstractTrafficLight implements TrafficLight {

  @Override
  public void advance() {
    try {
      System.out.printf("Switching from state: %s, to new state: %s\n", this, getClass().getMethod("advance").getAnnotation(Transition.class).newState().getSimpleName());
    } catch (NoSuchMethodException ex) {
      Logger.getLogger(AbstractTrafficLight.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
      Logger.getLogger(AbstractTrafficLight.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
  
}
