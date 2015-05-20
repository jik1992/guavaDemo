package thread;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZuoYun on 5/20/15. Time: 11:39 AM Information:
 */

public class ThreadOne implements Callable {

  public ThreadLocalRandom random=ThreadLocalRandom.current();

  public volatile String name;

  public ThreadOne(String name) {
    this.name = name;
  }

  public Object call() throws Exception {
    System.out.println("thread_"+name);
    TimeUnit.SECONDS.sleep(4);
    return "thread_"+name+" finsh!";
  }
}
