package example.fsm.trafficlight;

import com.wixia.toolbox.fsm.FSMBuilder;
import com.wixia.toolbox.fsm.FSMControl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        final TrafficLight sw = FSMBuilder.buildFSM(TrafficLight.class);
        
        final FSMControl control = (FSMControl) sw;
        
        System.out.printf("CurrentState: %s\n", control.getCurrentState());
        
        for (int i = 0; i < 20; i++) {
          sw.advance();
          System.out.printf("CurrentState: %s\n", control.getCurrentState());
          Thread.sleep(2000);
        }
    }
}
