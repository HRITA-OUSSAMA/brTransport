package com.venus.brTransport.Service.Unit_Tests.controller;

import com.venus.brTransport.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.venus.brTransport.controller.AdminController;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AdminControllerTest {
    @Autowired
    AdminController adminController;
}
