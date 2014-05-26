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
public class YellowRed extends AbstractTrafficLight {
  
  @Override
  @Transition(newState = Green.class)
  public void advance() {
    super.advance(); 
  }
  
}
