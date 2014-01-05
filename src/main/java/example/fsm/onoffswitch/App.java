package example.fsm.onoffswitch;

import com.wixia.toolbox.fsm.FSMBuilder;
import com.wixia.toolbox.fsm.FSMControl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final Switch sw = FSMBuilder.buildFSM(Switch.class);
        
        final FSMControl control = (FSMControl) sw;
        
        System.out.printf("CurrentState: %s\n", control.getCurrentState());
        
        sw.turnOff();
        System.out.printf("CurrentState: %s\n", control.getCurrentState());
        
        sw.turnOn();
        System.out.printf("CurrentState: %s\n", control.getCurrentState());
        
        sw.turnOn();
        System.out.printf("CurrentState: %s\n", control.getCurrentState());
        
        sw.turnOff();
        System.out.printf("CurrentState: %s\n", control.getCurrentState());
        
    }
}
