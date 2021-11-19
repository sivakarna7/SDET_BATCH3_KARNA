package modules;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerListener implements IRetryAnalyzer {
	private int retryCnt = 0;
	private int maxRetryCnt = 1;

	public boolean retry(ITestResult result) {
		if (retryCnt <= maxRetryCnt) {
			System.out.println("Retrying " + result.getName() + " again and count is " + (retryCnt + 1));
			retryCnt++;
			return true;
		} else
			return false;
	}

}
