import java.lang.Math;
import java.util.HashMap;

public class Problem505
{
  public static void main(String[] args) {
    new Problem505();
  }

  long startTime = 0;
  double hour = 0;
  double min = 0;
  double second = 0;
  double millisecond = 0;

  HashMap<String, Double> map = new HashMap<String, Double>();

  public Problem505() {
    startTime = System.currentTimeMillis();
    double test = x(2);
    System.out.println("\nx(2)     : " + test);

    test = x(3);
    System.out.println("\nx(3)     : " + test);
    
    test = x(4);
    System.out.println("\nx(4)     : " + test);
    
    test = y(4,4);
    System.out.println("\ny4(4)    : " + test);
    
    test = y(4,3) - (2<<60);
    System.out.println("\ny4(3)    : " + test);
    
    test = y(4,2) - (2<<60);
    System.out.println("\ny4(2)    : " + test);
    
    test = y(4,1);
    System.out.println("\ny4(1)    : " + test);
    
    test = A(10) - (2<<60);
    System.out.println("\nA(10)    : 2^60" + test);
    
    test = A(Math.pow(10, 3));
    System.out.println("\nA(10^3)  : " + test); 
    
    test = A(Math.pow(10, 12));
    System.out.println("\nA(10^12)   : " + test);
    
    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.println("\nElapsedTime : " + estimatedTime);
  }

  private double x(double f) {
	  //---------------------
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
    System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
    //----------------------
    if(f == 0 || f == 1) {
    	//------------------
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
      System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
      //--------------------
      return f;
    }
    else if(map.containsKey(f+"")) {
    	//------------------
      millisecond = System.currentTimeMillis() - startTime;
      second = Math.floor(millisecond / 1000);
      min = Math.floor(second / 60);
      hour = Math.floor(min / 60);
        System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
        //--------------------
    	return map.get(f+"");
    }
    else if(f % 2 == 0 && f >= 1) {
      double k = f/2;
      double floorHalfk = Math.floor(k/2);
      double part1 = 3 * x(k);
      double part2 = 2 * x(floorHalfk);
      double part3 = part1 + part2;
      double temp = part3 % (2 << 60);
      map.put(f+"", temp);
      //---------------------
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
      System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
      //----------------------
      return temp;
    }
    else if (f >= 1) {
      double k = ((f-1)/2);
      double floorHalfk = Math.floor(k/2);
      double part1 = 2 * x(k);
      double part2 = 3 * x(floorHalfk);
      double part3 = part1 + part2;
      double temp = part3 % (2 << 60);
      map.put(f+"", temp);
      //------------------------
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
      System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
      //-------------------------
      return temp;
    }
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
    System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
    return 0;
  }

  private double y(double n, double k) {
    //-------------------------
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
    System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
    //-------------------------
    if(map.containsKey(n+"-"+k)) {
    	//-------------------------
        millisecond = System.currentTimeMillis() - startTime;
        second = Math.floor(millisecond / 1000);
        min = Math.floor(second / 60);
        hour = Math.floor(min / 60);
        System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
        //-------------------------
    	return map.get(n+"-"+k);
    }
    else if(k >= n) {
      //--------------------------
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
      System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
     //------------------------
      double temp = x(k);
      map.put(n+"-"+k, temp);
      return temp;
    }
    else if(k < n) {
      //-----------------------
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
      System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
      //-----------------------
      double temp = (2<<60) - 1 - (Math.max(y(n, 2*k), y(n, (2*k + 1))));
      map.put(n+"-"+k, temp);
      return temp;
    }
    //------------------------
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
    System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
    //------------------------
    return 0;
  }

  private double A(double n){
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
    System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
    double temp = y(n, 1);
    millisecond = System.currentTimeMillis() - startTime;
    second = Math.floor(millisecond / 1000);
    min = Math.floor(second / 60);
    hour = Math.floor(min / 60);
    System.out.print("Time=" + hour + ":" + min + ":" + second + ":" + millisecond  + "                  \r");
    return temp;
  }
}
