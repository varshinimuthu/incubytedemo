package incubytedemo.incubytedemo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Composemail {
	WebDriver driver;
	WebDriverWait wait;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/vamuthuk/eclipse-workspace/incubytedemo/Drivers/chromedriver.exe");
		//C:/Users/vamuthuk/Downloads/chromeon23rd/chromedriver.exe
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();

	}

	@BeforeTest
	public void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "//test-output//Extentreport.html");
		test = report.startTest("Composeemail");
	}

	@Test
	public void test()throws InterruptedException {
		driver.get("https://www.gmail.com/");
	
	
		test.log(LogStatus.PASS, "Navigated to Gmail");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email'")));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("varshinitest1@gmail.com");
		test.log(LogStatus.PASS, "Email is Entered Successfully");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[@id='identifierNext']/div/button/span"))));
		driver.findElement(By.xpath("//*[@id='identifierNext']/div/button/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password@123");
		test.log(LogStatus.PASS, "Password is Entered Successfully");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[@id='passwordNext']/div/button/span"))));
		driver.findElement(By.xpath("//*[@id='passwordNext']/div/button/span")).click();
		test.log(LogStatus.PASS, "Signin is Successfully Completed ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[@class='z0']"))));
		driver.findElement(By.xpath("//*[@class='z0']")).click();
		test.log(LogStatus.PASS, "Compose Email is clicked successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//*[@class='vO'])[1]"))));
		driver.findElement(By.xpath("(//*[@class='vO'])[1]")).sendKeys("varshinitest1@gmail.com");
		driver.findElement(By.xpath("//div[@data-hovercard-id='varshinitest1@gmail.com']")).click();
		test.log(LogStatus.PASS, "Recipient Email Address is Entered Successfully");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[@id=':2a']"))));
//		WebElement element = driver.findElement(By.id("//*[@id=':2a']"));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", element);
//		driver.findElement(By.xpath("//*[@id=':2a']")).sendKeys("varshinimuthukrishnan6@gmail.com");
//		test.log(LogStatus.PASS, "Recipient Email Address For CC is Entered Successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//input[@name='subjectbox']"))));
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("IncubyteDemo");
		test.log(LogStatus.PASS, "Email Subject is Entered successfully");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[@class='Am Al editable LW-avf tS-tW']"))));
		driver.findElement(By.xpath("//*[@class='Am Al editable LW-avf tS-tW']"))
				.sendKeys("This is a Automation Testing demo for Compose Functionality in Gmail");
		test.log(LogStatus.PASS, "EmailBody is Entered Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//*[contains(text(),'Send')])[2]"))));
		driver.findElement(By.xpath("(//*[contains(text(),'Send')])[2]")).click();
		test.log(LogStatus.PASS, "Send Button is Clicked Successfully");
	}

	@AfterTest
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	@AfterClass
	public void tearDown() {
	//	driver.close();
	}

}
