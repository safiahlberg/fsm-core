/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.fsm.trafficlight;

import com.wixia.toolbox.fsm.FiniteStateMachine;

/**
 *
 * @author safi
 */
@FiniteStateMachine(states = {Green.class, Yellow.class, YellowRed.class, Red.class}, initialState = Green.class)
public interface TrafficLight {
  
  void advance();
  
}
