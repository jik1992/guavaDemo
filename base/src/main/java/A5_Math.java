import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;

import java.math.RoundingMode;

/**
 * Created by ZuoYun on 5/20/15. Time: 9:28 AM Information:
 */

public class A5_Math {


  public static void main(String[] args) {
//    IntMath.checkedAdd(Integer.MAX_VALUE,Integer.MAX_VALUE);
    System.out.println(DoubleMath.roundToBigInteger(2.4422, RoundingMode.DOWN));;
  }
}
