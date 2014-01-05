/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.fsm;

import com.wixia.toolbox.fsm.FiniteStateMachine;

/**
 *
 * @author safi
 */
@FiniteStateMachine(states = {On.class, Off.class}, initialState = Off.class)
public interface Switch {
  
  void turnOn();
  void turnOff();
  
}
