package pageobject;

import actions.SelectOptions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ReservaCita extends PageObject {



    @FindBy(id = "combo_facility")
    public WebElementFacade facilityOption;

    @FindBy(id = "chk_hospotal_readmission")
    public WebElementFacade readmissionchk;

    @FindBy(xpath = "//label[@class='radio-inline']")
    public List<WebElementFacade> tipProgramlist;
    @FindBy(id = "txt_visit_date")
    public WebElementFacade datetxt;

    @FindBy(css = "#txt_comment")
    public WebElementFacade commentxt;


    @FindBy(id = "btn-book-appointment")
    public WebElementFacade btnbook;

    @FindBy(xpath = "//h2[text()='Appointment Confirmation']")
    public WebElementFacade messageconfirmtxt;

    @FindBy(xpath = "//section[@id='summary']")
    public WebElement validateText;

    public void completFormulario(String facility, String tipoprograma, String date, String comment) {
        Select elementFacility = new Select(facilityOption);
        elementFacility.selectByVisibleText(facility);
        readmissionchk.click();
        SelectOptions.in(tipProgramlist, tipoprograma);
        datetxt.type(date);
        commentxt.type(comment);
        btnbook.click();
        messageconfirmtxt.withTimeoutOf(Duration.ofSeconds(20)).isEnabled();
        Assert.assertEquals(messageconfirmtxt.getText(),"Appointment Confirmation");

    }

    public boolean validateFacility(String facility){
        return validateText.getText().contains(facility);
    }
    public boolean validateReadmission(String readmission){
            return validateText.getText().contains(readmission);
    }
    public boolean validateHealthcareProgram(String healthcareProgram){return validateText.getText().contains(healthcareProgram);}
    public boolean validateVisitDate(String date){return validateText.getText().contains(date);}
    public boolean validateComment(String comment){return validateText.getText().contains(comment);}

}
