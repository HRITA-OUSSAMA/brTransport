package com.venus.brTransport.Service.Integration_Tests;


import com.venus.brTransport.model.Marchandise;
import com.venus.brTransport.service.MarchandiseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class MarchandiseServiceIntegrationTest {

    @Autowired
    MarchandiseService marchandiseService;

    @Mock
    HttpServletRequest request;

    @Test
    public void GivenMarchandise_WhenSaved_ThenItShouldBeSaved(){

        //Given
        Marchandise marchandise=new Marchandise();
        marchandise.setHauteur(3.0);
        marchandise.setLargeur(2.0);
        marchandise.setLongueur(5.0);
        marchandise.setPoids(20.0);
        marchandise.setType("MARCHANDISE GENERALE");

        //When
        final Marchandise marchandiseSaved=marchandiseService.saveMarchandise(marchandise);

        //Then
        assertThat(marchandiseSaved).isEqualTo(marchandise);

    }

    @Test
    public void GivenSession_WhenGetAttributes_ThenTheTwoMarchandiseInstancesShouldEqualed(){

        String hauteur="hauteur";
        String largeur="largeur";
        String longueur="longueur";
        String poids="poids";
        String type="type";
        Marchandise marchandise=new Marchandise();
        marchandise.setHauteur(3.0);
        marchandise.setLargeur(2.0);
        marchandise.setLongueur(5.0);
        marchandise.setPoids(20.0);
        marchandise.setType("MARCHANDISE GENERALE");


        HttpSession mockedSession=mock(HttpSession.class);

        //Given
        when(request.getSession()).thenReturn(mockedSession);

        when(mockedSession.getAttribute(hauteur)).thenReturn(3.0);
        when(mockedSession.getAttribute(largeur)).thenReturn(2.0);
        when(mockedSession.getAttribute(longueur)).thenReturn(5.0);
        when(mockedSession.getAttribute(poids)).thenReturn(20.0);
        when(mockedSession.getAttribute(type)).thenReturn("MARCHANDISE GENERALE");

        //When
        final List<Marchandise> returnedMarchandiseList=marchandiseService.getMarchandisesByAttribute(hauteur,largeur,longueur,poids,type,request);
        Marchandise returnedMarchandise=returnedMarchandiseList.get(0);


        //Then
        verify(mockedSession).getAttribute(hauteur);
        verify(mockedSession).getAttribute(largeur);
        verify(mockedSession).getAttribute(longueur);
        verify(mockedSession).getAttribute(poids);
        verify(mockedSession).getAttribute(type);

        assertThat(returnedMarchandise).isEqualToComparingFieldByField(marchandise);

    }
}
