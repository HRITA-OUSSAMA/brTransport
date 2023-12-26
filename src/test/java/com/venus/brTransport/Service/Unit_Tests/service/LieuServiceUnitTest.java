package com.venus.brTransport.Service.Unit_Tests.service;

import com.venus.brTransport.model.Lieu;
import com.venus.brTransport.repository.LieuRepository;
import com.venus.brTransport.service.LieuService;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

@SpringBootTest
public class LieuServiceUnitTest {
    @Autowired
    LieuService lieuService;

    @MockBean
    LieuRepository lieuRepository;

    @Test
    public void testGetLieux(){
        Lieu lieu = new Lieu();
        // create a list of Lieu
        ArrayList<Lieu> lieux = new ArrayList<>();
        lieux.add(lieu);
        // tell Mockito to return these Lieu when lieuRepository.findAll() is called
        when(lieuRepository.findAll()).thenReturn((Iterable<Lieu>) lieux);

        Iterable<Lieu> savedLieux = lieuService.getLieux();

        // test
        verify(lieuRepository).findAll();
        assertThat(savedLieux).isEqualTo(lieux);
    }

    @Test
    public void testGetLieuxById(){
        Lieu lieu = new Lieu();
        // tell Mockito to return these Lieu when lieuRepository.findById() is called
        when(lieuRepository.findById(anyInt())).thenReturn(java.util.Optional.of(lieu));

        Lieu savedLieu = lieuService.getLieuxById(1);

        // test
        verify(lieuRepository).findById(anyInt());
        assertThat(savedLieu).isEqualTo(lieu);
    }

    @Test
    public void testGetLieuEnDeuxParam(){
        Lieu lieu = new Lieu();
        // tell Mockito to return these Lieu when lieuRepository.getLieuEnDeuxParams() is called
        when(lieuRepository.getLieuEnDeuxParams(anyString(),anyString())).thenReturn(lieu);

        Lieu savedLieu = lieuService.getLieuEnDeuxParam("lieu1","lieu2");

        // test
        verify(lieuRepository).getLieuEnDeuxParams(anyString(),anyString());
        assertThat(savedLieu).isEqualTo(lieu);
    }

    @Test
    public void testSaveLieux(){
        Lieu lieu = new Lieu();
        // tell Mockito to return these Lieu when lieuRepository.save() is called
        when(lieuRepository.save(any(Lieu.class))).thenReturn(lieu);

        lieuService.saveLieux(lieu);

        // test
        verify(lieuRepository).save(any(Lieu.class));
    }
}
