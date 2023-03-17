package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pageobject.ReservaCita;
import pageobject.Home;

public class ReservaCitaStepsDefinitions {

    @Steps
    Home home;


    @Steps
    ReservaCita reservaCita;



    @Given("ingreso a la web a reservar cita")
    public void ingresoALaWebAReservarCita() {
        home.open();
        home.reservaCitar();
    }
    @And("^usuario inicia session con las credenciales (.*) y (.*)$")
    public void usuarioIniciaSessionConLasCredencialesUsuarioYPassword(String user,String pass) {
        home.enviarCredenciales(user, pass);
    }
    @When("^ingreso los datos (.*),(.*), (.*), (.*) en formulario$")
    public void ingresoLosDatosFacilityHealthcareProgramVisitDateCommentEnFormulario(String facility, String healthcareProgram, String visitDate, String comment) {
        reservaCita.completFormulario(facility, healthcareProgram, visitDate, comment);
    }


    @Then("^valido que se genero la orden correctamente con mis datos ingresados (.*),(.*),(.*), (.*), (.*)$")
    public void validoQueSeGeneroLaOrdenCorrectamenteConMisDatosIngresadosFacilityReadmissionHealthcareProgramVisitDateComment(String facility,String  readmission ,String healthcareProgram,String visitDate, String comment) {
        boolean flagFacility = reservaCita.validateFacility(facility);
        Assert.assertTrue(flagFacility);
        System.out.println("es correcto");
        boolean flagReadmission = reservaCita.validateReadmission(readmission);
        Assert.assertTrue(flagReadmission);
        boolean flagHealthcareProgram= reservaCita.validateHealthcareProgram(healthcareProgram);
        Assert.assertTrue(flagHealthcareProgram);
        boolean flagVisitDate = reservaCita.validateVisitDate(visitDate);
        Assert.assertTrue(flagVisitDate);
        boolean flagComment = reservaCita.validateComment(comment);
        Assert.assertTrue(flagComment);




    }


}
