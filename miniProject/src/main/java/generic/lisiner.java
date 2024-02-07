package generic;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class lisiner extends utility implements ITestListener {

	void getDateandTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormat);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			utility.getScreenShot(result.getMethod().getMethodName()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

}
