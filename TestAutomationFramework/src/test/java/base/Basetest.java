package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	
	
	public static WebDriver driver;
	
	public static Properties prop= new Properties();
	
	public static Properties loc= new Properties();
	
	public static FileReader fr;
	public static FileReader lr;
	
	@BeforeMethod
	public void setup() throws IOException{
		
		if (driver== null);{
		
		fr= new FileReader (System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		lr=new FileReader(System.getProperty("user.dir")+"src\\test\\resources\\configfiles\\locator.properties");
		prop.load(fr);
		loc.load(lr);
	
	}
	
	if(prop.getProperty("browser")=="chrome") {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(prop.getProperty("ur"));
		
		
	}

	else if (prop.getProperty("browser")=="firefox") {
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver ();
		driver.get(prop.getProperty("ur"));
		;
	}
else if (prop.getProperty("browser")=="edge") {
		
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get(prop.getProperty("ur"));
		
}
	}

	@AfterMethod
	public void teardown() {
		
		driver.close();
		
	}}