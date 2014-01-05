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
public class Off {
  
  @Transition(newState = On.class)
  public void turnOn() {
    System.out.printf("Lights are on!\n");
  }
  
  @Transition(newState = Off.class)
  public void turnOff() {
    System.out.printf("Lights are already off!\n");
  }

}
