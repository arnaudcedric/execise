package module9;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
/**
 * Created by acedric on 11/04/2017.
 */
public class Reglistener extends TestListenerAdapter {

    public void onTestSuccess(ITestResult var1) {

        System.out.println(var1.getName() + "  is Success -- " + var1.getTestClass() );
    }

    public void onTestFailure(ITestResult var1) {

        System.out.println(var1.getName() + " Failure -- " + var1.getTestClass() );
    }

    public void onTestSkipped(ITestResult var1) {

        System.out.println(var1.getName() + " Skipped -- " + var1.getTestClass() );
    }

}
