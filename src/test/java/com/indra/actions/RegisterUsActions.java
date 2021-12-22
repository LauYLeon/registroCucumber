package com.indra.actions;

import com.indra.models.FormularioRegistro;
import com.indra.pages.RegisterUsPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;

@DefaultUrl("/index.php?controller=authentication&back=my-account")
public class RegisterUsActions extends RegisterUsPage {

    public RegisterUsActions(WebDriver driver) {
        super(driver);
    }

    public void ingresoEmail(String email) {
        enter(email).into(getCampoEmail());
        getBtnCrear().click();
        validarIngresoPaginaRegistro();
    }

    public void validarIngresoPaginaRegistro() {
        assertThat("El titulo deberia coincidir",
                "CREATE AN ACCOUNT",
                Matchers.is(getTittleNewAccount().getText()));
    }
    public void llenarFourmularioRegistro(FormularioRegistro registro){
        enter(registro.getNombre()).into(getCampoPrimerNombre());
        enter(registro.getApellido()).into(getCampoApellido());
        enter(registro.getPassword()).into(getCampoPassword());
        selectOptionFromDropDown(By.id("days"),registro.getDay());
        selectOptionFromDropDown(By.id("months"),registro.getMonth());
        selectOptionFromDropDown(By.id("years"),registro.getYear());
        enter(registro.getNombre1()).into(getCampoName());
        enter(registro.getApellido1()).into(getCampoLastName());
        enter(registro.getCompany()).into(getCampoCompany());
        enter(registro.getDireccion()).into(getCampoDireccion());
        enter(registro.getCiudad()).into(getCampoCiudad());
        selectOptionFromDropDown(By.id("id_state"),registro.getEstado());
        enter(registro.getCodPostal()).into(getCampoCodPostal());
        enter(registro.getTelefono()).into(getCampoCelular());
    }

    public void enviarRegistro(FormularioRegistro registro){
        llenarFourmularioRegistro(registro);
        getBtnRegistar().click();
    }

    public void validarRegistroConNombreUsuario(){
        assertThat("El nombre de usuario deberia coincidir",
                "pepito perez",
                Matchers.is(getUserRegistered().getText()));
    }
}
