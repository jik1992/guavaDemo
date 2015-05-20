import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by ZuoYun on 5/20/15. Time: 1:52 PM Information:
 */

public class eventListener {


  @Subscribe
  public void listen(AnyEventType type){
    System.out.println("listen -->"+type.getMsg());
  }

  public static void main(String[] args) {

    EventBus event = new EventBus("test");
    event.register(new eventListener());

    event.post(new AnyEventType("hello"));



  }

}

class AnyEventType {

  private String msg;

  public AnyEventType(String msg) {
    this.msg = msg;
  }
  public String getMsg(){
    return this.msg;
  }
}