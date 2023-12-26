package com.venus.brTransport.Service.Unit_Tests;

import com.venus.brTransport.model.Marchandise;
import com.venus.brTransport.repository.MarchandiseRepository;
import com.venus.brTransport.service.MarchandiseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MarchandiseServiceUnitTest {

    @Autowired
    MarchandiseService marchandiseService;

    @MockBean
    MarchandiseRepository marchandiseRepository;

    @Mock
    HttpServletRequest request;

    @Test
    public void GivenMarchandise_WhenSaved_ThenItShouldBeSaved(){

        Marchandise marchandise=new Marchandise();
        marchandise.setHauteur(3.0);
        marchandise.setLargeur(2.0);
        marchandise.setLongueur(5.0);
        marchandise.setPoids(20.0);
        marchandise.setType("MARCHANDISE GENERALE");
        //Given
        when(marchandiseRepository.save(any(Marchandise.class))).thenReturn(marchandise);

        //When
        final Marchandise marchandiseSaved=marchandiseService.saveMarchandise(marchandise);

        //Then
        verify(marchandiseRepository).save(marchandise);
        assertThat(marchandiseSaved).isEqualTo(marchandise);

    }

    @Test
    public void GivenSession_When(){

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
