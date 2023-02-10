package com.dione.testingmanagebackend;

import com.dione.testingmanagebackend.entities.*;
import com.dione.testingmanagebackend.service.AppTestingServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class TestingManageBackEndApplication implements CommandLineRunner {
	private final AppTestingServiceImpl appTestingService;
	private final RepositoryRestConfiguration restConfiguration;

	public TestingManageBackEndApplication(AppTestingServiceImpl appTestingService, RepositoryRestConfiguration restConfiguration) {
		this.appTestingService = appTestingService;
		this.restConfiguration = restConfiguration;
	}


	public static void main(String[] args) {
		SpringApplication.run(TestingManageBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Exposition des id
		restConfiguration.exposeIdsFor(Release.class);
		restConfiguration.exposeIdsFor(Ticket.class);
		restConfiguration.exposeIdsFor(Anomalie.class);
		restConfiguration.exposeIdsFor(CasDeTest.class);
		restConfiguration.exposeIdsFor(ScenarioDeTest.class);
		restConfiguration.exposeIdsFor(Testeur.class);

		appTestingService.initAnomalie();
		appTestingService.initCasDeTest();
		appTestingService.initScenarioDeTest();
		appTestingService.initRelease();
		appTestingService.initTicket();
		appTestingService.initTesteur();

	}
}
