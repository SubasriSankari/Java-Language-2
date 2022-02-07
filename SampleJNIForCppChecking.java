import java.util.*;

public class SampleJNIForCppChecking{  

    public native void printHello();
    static{
        System.loadLibrary("event"); 
    }

    public static void main(String[] args) {

    	SampleJNIForCppChecking sample = new SampleJNIForCppChecking();
	sample.printHello();

    }
 }