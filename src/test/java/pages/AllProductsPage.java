package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;
import utility.SeleniumUtils;

import java.util.List;

@Data
public class AllProductsPage {

public AllProductsPage(){
    //this lne initializes all variables with @FindBy annotations
    PageFactory.initElements(Driver.getDriver(),this);
}


   @FindBy(xpath = "//table[@class='ProductsTable']//th" )
   private List<WebElement> headers ;






    public List<String> extractHeadersText() {
        List<WebElement> headers = getHeaders();
        return SeleniumUtils.getElementsText(headers);
    }
}
