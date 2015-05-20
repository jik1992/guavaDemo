import com.google.common.util.concurrent.Futures;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import thread.ThreadOne;

/**
 * Created by ZuoYun on 5/20/15. Time: 11:37 AM Information:
 */

public class C0_base {

  public static void main(String[] args) throws InterruptedException {



    ExecutorService es= Executors.newFixedThreadPool(100);
    List<Future<String>> result=new LinkedList<Future<String>>();


    result.add(es.submit(new ThreadOne("1")));
    result.add(es.submit(new ThreadOne("2")));
    result.add(es.submit(new ThreadOne("3")));
    result.add(es.submit(new ThreadOne("4")));

    System.out.println(es.isTerminated());
    es.shutdown();

    while (!es.awaitTermination(1, TimeUnit.SECONDS)){
      System.out.println("thread no shutdown");
      //force shutdown!
      es.shutdownNow();
    }
    System.out.println("thread shutdown");

    System.out.println(StringUtils.center("查看多线程结果",20));
    for (Future<String> stringFuture : result) {
      try {
        System.out.println(stringFuture.get());
      } catch (ExecutionException e) {

      }
    }

  }

}
