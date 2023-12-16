package com.venus.brTransport;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.venus.brTransport.model.Lieu;
import com.venus.brTransport.model.Marchandise;
import com.venus.brTransport.model.Operation;
import com.venus.brTransport.model.OperationCard;
import com.venus.brTransport.model.User;
import com.venus.brTransport.service.LieuService;
import com.venus.brTransport.service.MarchandiseService;
import com.venus.brTransport.service.OperationService;
import com.venus.brTransport.service.UserService;


@SpringBootApplication
public class BrTransportApplication implements CommandLineRunner{
	@Autowired
	UserService userService;
	
	@Autowired
	LieuService lieuService;
	
	@Autowired
	OperationService operationService;
	
	@Autowired
	MarchandiseService marchandiseService;
	public static void main(String[] args) {
		SpringApplication.run(BrTransportApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hello World", font);

		document.add(chunk);
		document.close();
		
	}
}
