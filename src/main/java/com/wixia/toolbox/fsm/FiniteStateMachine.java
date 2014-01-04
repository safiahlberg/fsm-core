/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wixia.toolbox.fsm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author safi
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FiniteStateMachine {
  
  Class<?>[] states();
  
  Class<?> initialState();
  
  Class<?> finalState() default Object.class;
}
