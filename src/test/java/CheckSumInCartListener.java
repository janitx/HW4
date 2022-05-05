import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckSumInCartListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(CheckSumInCartListener.class);

    public void onStart(ITestContext context) {
        logger.info(String.format("onStart method started -> %s", context.getName()));
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish method started");
        logger.info(String.format("onFinish method started -> %s", context.getName()));
    }

    public void onTestStart(ITestResult result) {
        logger.info(String.format("New Test Started -> %s", result.getName()));
    }

    public void onTestSuccess(ITestResult result) {
        logger.info(String.format("onTestSuccess Method -> %s", result.getName()));

    }

    public void onTestFailure(ITestResult result) {
        logger.error(String.format("onTestFailure Method -> %s", result.getName()));
    }

    public void onTestSkipped(ITestResult result) {
        logger.info(String.format("onTestSkipped Method -> %s", result.getName()));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info(String.format("onTestFailedButWithinSuccessPercentage -> %s", result.getName()));
    }

}

