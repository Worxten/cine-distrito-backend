package com.udistrital.cinedistritobackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udistrital.cinedistritobackend.api.controllers.user.UsuarioController;
import com.udistrital.cinedistritobackend.api.services.user.entities.Empleado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    // Repo?
    String fecha = "January 2, 2010";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
    Date date = (Date) formatter.parse(fecha);

    Empleado primerEmpleado = new Empleado(Long.valueOf(1), "Andres"," Matos", "", "", date, "Empleado",
            "Empleado");
    Empleado segundoEmpleado = new Empleado(Long.valueOf(2), "Andres"," Matos", "", "", date, "Empleado",
            "Empleado");


    @Test
    public void getAllRecords_success() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/patient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(3)))
                .andExpect((ResultMatcher) jsonPath("$[2].name", is("Jane Doe")));
    }
}
