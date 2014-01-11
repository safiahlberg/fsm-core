/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wixia.toolbox.fsm;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author safi
 */
public class FSMBuilder {
  
  private FSMBuilder() {    
  }
  
  public static <T> T buildFSM(Class<T> clazz) {
    return buildFSM(clazz, extractStateClasses(clazz),
            extractInitialState(clazz), 
            extractFinalState(clazz));
  }
  
  private static List<Class<?>> extractStateClasses(Class<?> clazz) {
    final FiniteStateMachine fsm = extractFiniteStateMachine(clazz);
    return Arrays.asList(fsm.states());
  }
  
  private static Class<?> extractInitialState(Class<?> clazz) {
    final FiniteStateMachine fsm = extractFiniteStateMachine(clazz);
    return fsm.initialState();
  }
  
  private static Class<?> extractFinalState(Class<?> clazz) {
    final FiniteStateMachine fsm = extractFiniteStateMachine(clazz);
    return fsm.finalState();
  }
  
  private static FiniteStateMachine extractFiniteStateMachine(Class<?> clazz) {
    return clazz.getAnnotation(FiniteStateMachine.class);
  }
  
  private static <T> T buildFSM(Class<?> clazz, 
          List<Class<?>> stateClasses, Class<?> initialState, 
          Class<?> finalState) {
    return buildFSM(clazz, new FSMInvocationHandler(stateClasses, initialState, finalState));
  }
  
  /**
   * Create a proxy instance for the state class and for FSMControl at the 
   * same time
   * 
   * @param <T>
   * @param clazz This will be the Finite State Machine class (the one with FiniteStateMachine annotation)
   * @param invocationHandler
   * @return 
   */
  static <T> T buildFSM(Class<?> clazz, FSMInvocationHandler invocationHandler) {
    return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[] {clazz, FSMControl.class}, invocationHandler);
  }
}
