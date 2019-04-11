package main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SiteRunner implements Runnable {
	
	private static final String SITE1 = "https://www.ynet.co.il";
	private static final String SITE2 = "https://edition.cnn.com/";
	private static final String SITE3 = "https://www.bbc.com/";
	private boolean flag;

	public SiteRunner() {
		super();
		flag = true;
	}

	public void run() {
		while (flag) {
			
			System.out.println("thread SiteRunner");
			
			//Proxy proxy = new Proxy();
			//proxy.setHttpProxy(httpProxy)
			
			System.setProperty("webdriver.edge.driver", "C:\\workspace2\\MicrosoftWebDriver.exe");
			
	        WebDriver driver = new EdgeDriver();

	        // And now use this to visit Google
	       // driver.get("http://www.google.com");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        //driver.get("https://www.hidemyass.com/en-il/proxy");
	        driver.get("https://hide.me/en/proxy");
	        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	        
	        // Alternatively the same thing can be done like this
	        // driver.navigate().to("http://www.google.com");

	        // Find the text input element by its name
	        
	        // WebElement element = driver.findElement(By.name("q"));
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         WebElement element =   new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("u")));

	        // Enter something to search for
	        //element.sendKeys("Cheese!");
	        element.sendKeys("http://whatismyipaddress.com");
	       

	        // Now submit the form. WebDriver will find the form for us from the element
	        element.submit();

	        // Check the title of the page
	       System.out.println("Page title is: " + driver.getTitle());
	        
	        // Google's search is rendered dynamically with JavaScript.
	        // Wait for the page to load, timeout after 10 seconds
	       // (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
	      //      public Boolean apply(WebDriver d) {
	        //        return d.getTitle().toLowerCase().startsWith("Hide");
	               // return d.getTitle().toLowerCase().startsWith("cheese!");
	        //    }
	      //  });

	        // Should see: "cheese! - Google Search"
	       // System.out.println("Page title is: " + driver.getTitle());
	        
	        //Close the browser
	       try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        driver.quit();
			
			
			try {
				Thread.sleep((8000));
			} catch (InterruptedException e) {
				
				continue;//if stopTask was evoked, followed by interruption of this thread, the flag changes to false and 
				//the continue statement will cause the flag value to be checked. This will cause the thread to finish its task.
			}
		}

	}

	public void stopTask() {
		flag = false;
	}

}

/*
Runtime rt = Runtime.getRuntime();
try {
	rt.exec(SITE3);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
*/
/*
if (Desktop.isDesktopSupported()) {
    // Windows
    try {
		Desktop.getDesktop().browse(new URI(SITE3));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} else {
	System.out.println("not supported");
}
*/
