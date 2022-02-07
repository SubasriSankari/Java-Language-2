import java.util.*;

public class WindowEventJava{  

    static{
        System.loadLibrary("event"); 
    }

    public native Properties[] printEventViewer();
    public void main(String[] args) {

    Properties[] records = this.printEventViewer();

     /*  try {
          records = 
       }catch (UnsatisfiedLinkError e) {
          System.out.println("Couldn't call native function.\n" + e);
       } */
       for(Properties record:records){
           System.out.print("type:"+record.getProperty("type"));
           System.out.print("\ttime:"+record.getProperty("time"));
           System.out.print("\tsource:"+record.getProperty("source"));
           System.out.print("\teid:"+record.getProperty("eid"));
           System.out.println("\n");
       }

    }
 }