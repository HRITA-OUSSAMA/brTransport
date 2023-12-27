package com.venus.brTransport.Service.Unit_Tests;

import com.venus.brTransport.model.Contact;
import com.venus.brTransport.repository.ContactRepository;
import com.venus.brTransport.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MessageServiceUnitTest {

    @Autowired
    MessageService messageService;

    @MockBean
    ContactRepository messageRepository;


    @Test
    public void GivenMessage_WhenSaved_ThenItShouldBeSaved(){

        Contact contact=new Contact();
        contact.setNom("HRITA");
        contact.setPrenom("OUSSAMA");
        contact.setSujet("Greeting");
        contact.setMessage("Hello world !");
        contact.setVue(1);

        //Given
        when(messageRepository.save(contact)).thenReturn(contact);

        //When
        final Contact savedContact= messageService.saveMessage(contact);

        //Then
        verify(messageRepository).save(contact);
        assertThat(contact).isEqualTo(savedContact);

    }

    @Test
    public void test_getMessage(){

        Contact message1 =new Contact();
        message1.setNom("HRITA");
        message1.setPrenom("OUSSAMA");
        message1.setSujet("Greeting");
        message1.setMessage("Hello world !");
        message1.setVue(1);


        Contact message2 =new Contact();
        message2.setNom("LEBSIR");
        message2.setPrenom("YASSER");
        message2.setSujet("Greeting");
        message2.setMessage("Hello brTransport !");
        message2.setVue(0);

        List<Contact> listOfMessages=new ArrayList<>();
        listOfMessages.add(message1);
        listOfMessages.add(message2);

        //Given
        when(messageRepository.findAll()).thenReturn(listOfMessages);

        //When
        final Iterable<Contact> returnedListOfMessages=messageService.getMessages();

        //Then
        verify(messageRepository).findAll();
        assertThat(listOfMessages).isEqualTo(returnedListOfMessages);

    }

    @Test
    public void test_getMessagesNoVueNumber(){

        Contact message1 =new Contact();
        message1.setNom("HRITA");
        message1.setPrenom("OUSSAMA");
        message1.setSujet("Greeting");
        message1.setMessage("Hello world !");
        message1.setVue(0);


        Contact message2 =new Contact();
        message2.setNom("LEBSIR");
        message2.setPrenom("YASSER");
        message2.setSujet("Greeting");
        message2.setMessage("Hello brTransport !");
        message2.setVue(0);

        List<Contact> listOfMessages=new ArrayList<>();
        listOfMessages.add(message1);
        listOfMessages.add(message2);

        //Given
        when(messageRepository.findAll()).thenReturn(listOfMessages);

        //when
        final int nbrsOfVues= messageService.getMessagesNoVueNumber();

        //Then
        verify(messageRepository).findAll();
        assertThat(nbrsOfVues).isEqualTo(2);

    }

    @Test
    public void test_getMessageNonVue(){

        Contact message1 =new Contact();
        message1.setNom("HRITA");
        message1.setPrenom("OUSSAMA");
        message1.setSujet("Greeting");
        message1.setMessage("Hello world !");
        message1.setVue(0);


        Contact message2 =new Contact();
        message2.setNom("LEBSIR");
        message2.setPrenom("YASSER");
        message2.setSujet("Greeting");
        message2.setMessage("Hello brTransport !");
        message2.setVue(0);

        List<Contact> listOfMessages=new ArrayList<>();
        listOfMessages.add(message1);
        listOfMessages.add(message2);

        //Given
        when(messageRepository.findByVue(0)).thenReturn(listOfMessages);

        //when
        final Iterable<Contact> messageNonVue= messageService.getMessageNonVue();

        //Then
        verify(messageRepository).findByVue(0);
        assertThat(messageNonVue).isEqualTo(listOfMessages);

    }

}
