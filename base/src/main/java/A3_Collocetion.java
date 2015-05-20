import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZuoYun on 5/19/15. Time: 1:31 AM Information:
 */

public class A3_Collocetion {

  public static void main(String[] args) {
    Map<String,Object> map=Maps.newLinkedHashMap();

    ImmutableList<Integer> list= ImmutableList.of(1, 2, 3, 4, 5, 6);

    LinkedHashMultimap<String,String> map_=LinkedHashMultimap.create();
    map_.put("a","a1");
    map_.put("a","a2");
    map_.put("a","a3");
    map_.put("b","a");
    System.out.println(map_.get("a"));

    BiMap<Object,Object> bimap= HashBiMap.create();
    bimap.forcePut("a", 1);
    System.out.println(bimap.containsKey("a"));
    System.out.println(bimap.containsValue(1));

    Table<Integer, Integer, String> table=HashBasedTable.create();


    table.put(1,2,"x");
    table.put(1,3,"x");
    table.put(2,1,"x");

    System.out.println(table);
    System.out.println(table.containsRow(1));

    List<Long> taobaoIds= Lists.newArrayListWithCapacity(10);

    List<Integer> taobaoIds_= Ints.asList(1,2,3,4,5,6,6,8);
    Lists.partition(taobaoIds_,3);
    System.out.println(taobaoIds_);

  }

}
