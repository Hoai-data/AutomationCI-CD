package h.testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer{

	//method de chung trinh chay laij,chay bao nhieu lan 
	int count = 0;
	//gia su toi chi muon chay 1 lan 
	int maxTry = 1;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxTry) {
			count++;
			return true;
		}
		return false;
	}

}
