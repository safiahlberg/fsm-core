/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.fsm.trafficlight;

import com.wixia.toolbox.fsm.Transition;

/**
 *
 * @author safi
 */
public class Green extends AbstractTrafficLight {

  @Override
  @Transition(newState = Yellow.class)
  public void advance() {
    super.advance(); 
  }
  
}
