import com.google.common.base.Ticker;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZuoYun on 5/20/15. Time: 9:38 AM Information:
 */

public class B1_cache {

  public static void main(String[] args) throws ExecutionException {
    LoadingCache<String, String> cache = CacheBuilder.newBuilder()
        .maximumSize(1000)
        // 超过则将最大权重的逼近的清空
//        .maximumWeight(10)
//        .weigher(new Weigher<String, String>() {
//          public int weigh(String key, String value) {
//            return value.length();
//          }
//        })

        //未写访问清空
        .expireAfterWrite(10, TimeUnit.MINUTES)
        //未读写访问清空
//        .expireAfterAccess(10, TimeUnit.MINUTES)
        //制定一个时间源
//        .ticker(Ticker.systemTicker())

        //开启缓存统计
        .recordStats()
        .build(
            //fail load call
            new CacheLoader<String, String>() {
              public String load(String key) throws Exception {
                return "not exist!";
              }
            });


    cache.put("aaa","ssss");
    cache.put("aaa","ssss");
    cache.put("aaa","ssss");
    cache.put("aaa","ssss");
    cache.put("aaa","ssss");
    cache.put("aaa","ssss");

    System.out.println(cache.get("aaa"));
    System.out.println(cache.get("bbb"));

    cache.invalidate("aaa");
    System.out.println(cache.get("aaa"));

    //刷新清理缓存
    cache.cleanUp();
    //快速刷新
    cache.refresh("bbb");

    System.out.println(cache.stats());

  }

}
