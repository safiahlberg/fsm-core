package example.fsm.trafficlight;

import com.wixia.toolbox.fsm.FSMBuilder;
import com.wixia.toolbox.fsm.FSMControl;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) throws InterruptedException {
    final long delay = 2000;
    final int repetitions = 10;

    final TrafficLight sw = FSMBuilder.buildFSM(TrafficLight.class);

    final FSMControl control = (FSMControl) sw;

    System.out.printf("CurrentState: %s\n", control.getCurrentState());
    
    TimerTask task = new TimerTask() {

      @Override
      public void run() {
        sw.advance();
        System.out.printf("CurrentState: %s\n", control.getCurrentState());
        System.out.printf("Pausing %d\n\n", delay);
      }
      
    };
    
    Timer timer = new Timer();
    timer.schedule(task, 0, delay);
    
  }
}
