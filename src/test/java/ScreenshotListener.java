import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();

        try {
            WebDriver driver = (WebDriver) testClass
                    .getClass()
                    .getDeclaredField("Driver")
                    .get(testClass);

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path destination = Path.of(
                    "screenshots",
                    result.getName() + ".png"
            );

            Files.createDirectories(destination.getParent());
            Files.copy(source.toPath(), destination);

            System.out.println("Screenshot saved: " + destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
