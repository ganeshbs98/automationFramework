package Tasks.Frameworks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobaileBase {

    protected  static ThreadLocal<AndroidDriver> androidDriverThreadLocal=new ThreadLocal<>();
    protected  static ThreadLocal<IOSDriver> iosDriverThreadLocal=new ThreadLocal<>();



    public static AndroidDriver android(){
        return androidDriverThreadLocal.get();
    }
    public  static IOSDriver ios(){
        return iosDriverThreadLocal.get();
    }

    protected void handleError(String message, Exception e) {
        System.err.println("ERROR: " + message);
        if (e != null) {
            e.printStackTrace();
        }
        // For simplicity, we'll exit on error. In a test framework, you'd throw an assertion.
        System.exit(1);
    }

}
