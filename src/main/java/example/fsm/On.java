/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.fsm;

import com.wixia.toolbox.fsm.Transition;

/**
 *
 * @author safi
 */
public class On {
  
  @Transition(newState = Off.class)
  public void turnOff() {
    System.out.printf("Lights are off!\n");
  }

  @Transition(newState = On.class)
  public void turnOn() {
    System.out.printf("Lights are already on!\n");
  }
  
}
