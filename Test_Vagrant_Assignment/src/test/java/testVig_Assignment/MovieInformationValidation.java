package testVig_Assignment;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.Assgnt.objectRepository.java.IMDBDetails_InformationPage;
import org.Assgnt.objectRepository.java.WikiMovie_InformationPage;
import org.Assignment.genericUtility.java.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieInformationValidation extends BaseClass {
	
	@Test
	public void imdbTest() throws InterruptedException {
		
		String imdbReleaseDate;
		String imdbCountry;
		String wikiReleaseDate;
		String wikiCountry;
		
		
		// create object for Common POM repo classes
		 imdb = new IMDBDetails_InformationPage(driver);
		 wiki = new WikiMovie_InformationPage(driver);

		// Navigating the Application
		webdriverUtility.openApplication(imdburl);
		Thread.sleep(2000);
		imdbReleaseDate = imdb.getActualReleaseDate();
		imdbCountry = imdb.getActualCountryName();
		
		webdriverUtility.openApplication(wikiurl);
		Thread.sleep(2000);
		wikiReleaseDate = wiki.getActualReleaseDate();
		wikiCountry = wiki.getActualCountryName();
		
		javaUtility.printStatement(imdbReleaseDate);
		javaUtility.printStatement(imdbCountry);
		javaUtility.printStatement(wikiReleaseDate);
		javaUtility.printStatement(wikiCountry);
		
		String[] sad = imdbReleaseDate.split("\\(");
		javaUtility.printStatement(sad[0]);
        String imdbDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date(sad[0]));
        String wikiDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date(wikiReleaseDate));
        
        javaUtility.printStatement("***********************************");
        javaUtility.printStatement("Imdb Release Date:-"+imdbDate);
        javaUtility.printStatement("Wiki release date:-"+wikiDate);
        javaUtility.printStatement("***********************************");
        
        Assert.assertEquals(imdbDate, wikiDate);
        Assert.assertEquals(imdbCountry, wikiCountry);
		
		//String text = driver.findElement(By.xpath("//a[.='Release date']/following-sibling::div")).getText();
		//System.out.println("Release Date:-"+text);
		
		//String imdbCountryText = driver.findElement(By.xpath("//button[.='Country of origin']/following-sibling::div")).getText();
		//System.out.println("Country of origin:-"+imdbCountryText);
		
		//driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		
		//int y1 = driver.findElement(By.xpath("//span[@id='Plot']")).getLocation().getY();
		//JavascriptExecutor j1 = (JavascriptExecutor)driver;
		//j1.executeScript("window.scrollBy(0,"+y1+")");
		
		
		//String Text = driver.findElement(By.xpath("//tbody//div[.='Release date']/following::div[@class='plainlist']/descendant::li")).getText();
		//System.out.println("Release Date:-"+Text);
		
		//String wikiCountryText = driver.findElement(By.xpath("//tbody//td[.='India']")).getText();
		//System.out.println("Country:-"+wikiCountryText);
		
		
		//if (imdbCountryText.equals(wikiCountryText)) {
			//System.out.println("Successfully----> TC is Pass");
		//} else {
		//	System.out.println(" ----> TC is fail");
		//}
		
		
		
		
		
	}

}
