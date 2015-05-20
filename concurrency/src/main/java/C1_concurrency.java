import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ServiceManager;

import com.sun.deploy.services.DefaultService;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import thread.ThreadOne;

/**
 * Created by ZuoYun on 5/20/15. Time: 11:36 AM Information:
 */

public class C1_concurrency {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService es= Executors.newFixedThreadPool(100);
    List<ListenableFuture> result=new LinkedList<ListenableFuture>();

    ListeningExecutorService service = MoreExecutors.listeningDecorator(es);
    result.add(service.submit(new ThreadOne("1")));
    result.add(service.submit(new ThreadOne("2")));
    result.add(service.submit(new ThreadOne("3")));
    result.add(service.submit(new ThreadOne("4")));


    //给future 增加回调
    for (ListenableFuture listenableFuture : result) {
      Futures.addCallback(listenableFuture, new FutureCallback<Object>() {
        public void onSuccess(Object result) {
          System.out.println("finish");
        }

        public void onFailure(Throwable t) {
          System.out.println("fail!");
        }
      });
    }

    while (!service.isTerminated()){
      System.out.println("waiting...");
    }

    for (ListenableFuture listenableFuture : result) {
      //blocking
      System.out.println(listenableFuture.get());
    }
    service.shutdownNow();
  }

}
