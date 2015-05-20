import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;

/**
 * Created by ZuoYun on 5/19/15. Time: 1:08 AM Information:
 */

public class A4_String {

  public static void main(String[] args) {
    System.out.println(Joiner.on(",").join(1,2,3,4,5));

    System.out.println(Joiner.on(",").skipNulls().join(1,2,3,null,5));

    System.out.println(Joiner.on(",").useForNull("empty").join(1, 2, 3, null, 5));

    System.out.println(Joiner.on("#").withKeyValueSeparator(";").join(ImmutableMap.of("a",1,"b",2)));

    System.out.println(Splitter.on(' ').split("1 2 3"));

    System.out.println(Splitter.onPattern("\\s+").split("1 \t   2 3"));

    System.out.println(Splitter.fixedLength(3).split("1 2 3"));

    System.out.println(Splitter.on("#").withKeyValueSeparator(":").split("1:2#3:4"));


  }

}
