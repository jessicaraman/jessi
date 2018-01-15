package fr.digicar.webportal.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {

    @Test
    public void mainPage() {
        assertEquals("home", new HomeController().mainPage().getViewName());
    }

}
