package com.dione.testingmanagebackend;

import com.dione.testingmanagebackend.entities.*;
import com.dione.testingmanagebackend.service.AppTestingServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

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

	//Désactivation du CORS
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
