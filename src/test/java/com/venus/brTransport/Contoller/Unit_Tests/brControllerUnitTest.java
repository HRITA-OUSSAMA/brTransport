package com.venus.brTransport.Contoller.Unit_Tests;


import com.venus.brTransport.controller.brController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class brControllerUnitTest {

    @Autowired
    private brController brController;

    @Test
    void testAccueil() {
        // Créez une session et définissez les attributs
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("userPrenom", "John");
        session.setAttribute("userNom", "Doe");

        // Créez une requête avec la session
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setSession(session);

        // Appelez la méthode accueil du contrôleur
        String viewName = brController.accueil(new ExtendedModelMap(), request);

        // Vérifiez le nom de la vue retournée
        assertEquals("Accueil", viewName);

        // Vérifiez que les attributs de session sont correctement définis
        assertEquals("John", session.getAttribute("userPrenom"));
        assertEquals("Doe", session.getAttribute("userNom"));
    }



    @Test
    public void testConnexion() {
        // Créer une instance du contrôleur
        brController brController = new brController();

        // Appeler la méthode du contrôleur
        String viewName = brController.connexion();

        // Vérifier le nom de la vue
        assertEquals("Connexion", viewName);
    }

    @Test
    void testContact() {
        // Créer une instance du contrôleur
        brController brController = new brController();

        // Créer un objet Model simulé
        Model model = new ExtendedModelMap();

        // Créer une requête HTTP simulée avec une session
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("userPrenom", "Jane");
        request.getSession().setAttribute("userNom", "Smith");

        // Appeler la méthode du contrôleur
        String viewName = brController.contact(model, request);

        // Vérifier le nom de la vue
        assertEquals("Contact", viewName);

        // Vérifier que les attributs du modèle sont corrects
        assertEquals("Smith", model.getAttribute("userNom"));
        assertEquals("Jane", model.getAttribute("userPrenom"));
        assertNotNull(model.getAttribute("userNom"));
        assertNotNull(model.getAttribute("userPrenom"));
    }

}
