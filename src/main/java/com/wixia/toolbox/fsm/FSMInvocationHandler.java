/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wixia.toolbox.fsm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author safi
 */
class FSMInvocationHandler implements InvocationHandler {

  final private List<Class<?>> stateClasses;
  final private Class<?> initialState;
  final private Class<?> finalState;

  final private Map<Class<?>, Object> stateObjects = new HashMap<Class<?>, Object>();
  private Object currentState;

  public FSMInvocationHandler(List<Class<?>> stateClasses, Class<?> initialState, Class<?> finalState) {
    this.stateClasses = stateClasses;
    this.initialState = initialState;
    this.finalState = finalState;

    initializeStateObjects();
    setInitialState();
  }

  private void initializeStateObjects() {
    for (Class<?> stateClass : stateClasses) {
      try {
        stateObjects.put(stateClass, stateClass.newInstance());
      } catch (InstantiationException ex) {
        throw new RuntimeException("State " + stateClass.getName()
                + " can't be instanciated: " + ex.getMessage(), ex);
      } catch (IllegalAccessException ex) {
        throw new RuntimeException("State " + stateClass.getName()
                + " has no accessible default constructor: " + ex.getMessage(), ex);
      }
    }
  }

  private void setInitialState() {
    currentState = stateObjects.get(initialState);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if ("getCurrentState".equals(method.getName())
            && (method.getParameterTypes().length == 0)) {
      return currentState.getClass().getSimpleName();
    }
    Method stateMethod = lookupCurrentStateMethod(method, args);
    Object methodReturn = stateMethod.invoke(currentState, args);
    Transition transition = stateMethod.getAnnotation(Transition.class);
    if (transition != null) {
      Class<?> nextStateClass = transition.newState();
      currentState = stateObjects.get(nextStateClass);
    }
    return methodReturn;
  }

  private Method lookupCurrentStateMethod(Method method, Object[] args) {
    try {
      return currentState.getClass().getMethod(method.getName(),
              method.getParameterTypes());
    } catch (NoSuchMethodException ex) {
      throw new RuntimeException("State '" + currentState.getClass().getName()
              + "' doesn't allow '" + method.getName() + "'");
    }
  }

}
