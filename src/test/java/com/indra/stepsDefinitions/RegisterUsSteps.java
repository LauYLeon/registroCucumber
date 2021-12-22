package com.indra.stepsDefinitions;

import com.indra.actions.RegisterUsActions;
import com.indra.models.FormularioRegistro;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RegisterUsSteps {
    @Managed
    WebDriver driver;
    RegisterUsActions registerUsActions = new RegisterUsActions(driver);

    @Given("^que el usuario esta en la seccion de logueo para crear nuevo usuario$")
    public void que_el_usuario_esta_en_la_seccion_de_logueo_para_crear_nuevo_usuario() {
        registerUsActions.open();
    }

    @When("^el usuario ingresa un (.*) valido$")
    public void el_usuario_ingresa_un_valido(String email){
        registerUsActions.ingresoEmail(email);
    }

    @When("^completa el formulario de registro con los campos obligatorios$")
    public void completa_el_formulario_de_registro_con_los_campos_obligatorios(List <FormularioRegistro> formularioRegistros) {
        registerUsActions.enviarRegistro(formularioRegistros.get(0));
    }

    @Then("^el usuario deberia ver el nombre de usuario$")
    public void el_usuario_deberia_ver_el_nombre_de_usuario() {
        registerUsActions.validarRegistroConNombreUsuario();
    }


}
