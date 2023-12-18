package com.venus.brTransport.Service.Unit_Tests;

import com.venus.brTransport.model.Marchandise;
import com.venus.brTransport.repository.MarchandiseRepository;
import com.venus.brTransport.service.MarchandiseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MarchandiseServiceUnitTest {

    @Autowired
    MarchandiseService marchandiseService;

    @MockBean
    MarchandiseRepository marchandiseRepository;

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


}
