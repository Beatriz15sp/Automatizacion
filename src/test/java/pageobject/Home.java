package pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;


public class Home extends PageObject {


    @FindBy(id = "btn-make-appointment")
    public WebElementFacade btncita;
    @FindBy(id = "txt-username")
    public WebElementFacade usertxt;
    @FindBy(id = "txt-password")
    public WebElementFacade passwordtxt;
    @FindBy(id = "btn-login")
    public WebElementFacade btnlogin;

    public void reservaCitar(){
        btncita.click();
    }

    public void enviarCredenciales(String username,String password){
        element(usertxt).waitUntilVisible();
        usertxt.type(username);
        passwordtxt.type(password);
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", btnlogin);
    }


}
