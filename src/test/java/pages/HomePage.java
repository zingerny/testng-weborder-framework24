package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "View all products" )
    private WebElement allOrdersLinks ;

    public void clickOnLink(String textOfTheLink){
        Driver.getDriver().findElement(By.linkText(textOfTheLink)).click();

    }
}
