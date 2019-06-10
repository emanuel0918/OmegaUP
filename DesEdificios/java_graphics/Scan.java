import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Scan{
  public static String scan (){
    String scan = "";
    char c = 0;
    BufferedReader br =
      new BufferedReader (new InputStreamReader (System.in));
    while (c != '\n')
      {
	try
	{
	  c = (char) br.read ();
	  if (c != '\n')
	    {
	      scan += c;
	    }
	}
	catch (java.io.IOException ex)
	{
	  ex.printStackTrace ();
	}
      }
    return scan;
  }
  
  public static int scanInt (){
    int scan=0;
    try {
     scan= Integer.parseInt(scan());
    } catch (NumberFormatException e) {
     scan=0;
    }
    return scan;
  }
  
  public static double scanDouble (){
    double scan=0f;
    try {
     scan= Double.parseDouble(scan());
    } catch (NumberFormatException e) {
     scan=0;
    }
    return scan;
  }
}
