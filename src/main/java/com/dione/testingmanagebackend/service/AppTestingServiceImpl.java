package com.dione.testingmanagebackend.service;


import com.dione.testingmanagebackend.entities.*;
import com.dione.testingmanagebackend.enums.*;
import com.dione.testingmanagebackend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.stream.Stream;

@Service
@Transactional
public class AppTestingServiceImpl implements IAppTestingService {

    private final ReleaseRepository releaseRepository;
    private final TicketRepository ticketRepository;
    private final ScenarioRepository scenarioDeTestRepository;
    private final CasDeTestRepository casDeTestRepository;
    private final AnomalieRepository anomalieRepository;
    private final TesteurRepository testeurRepository;
    private final UserRepository userRepository;

    public AppTestingServiceImpl(ReleaseRepository releaseRepository, TicketRepository ticketRepository, ScenarioRepository scenarioDeTestRepository1, CasDeTestRepository casDeTestRepository, AnomalieRepository anomalieRepository, TesteurRepository testeurRepository, UserRepository userRepository) {
        this.releaseRepository = releaseRepository;
        this.ticketRepository = ticketRepository;
        this.scenarioDeTestRepository = scenarioDeTestRepository1;

        this.casDeTestRepository = casDeTestRepository;
        this.anomalieRepository = anomalieRepository;
        this.testeurRepository = testeurRepository;
        this.userRepository = userRepository;
    }

    //Initialisation des données de releases
    @Override
    public void initRelease() {
        for (int i = 0; i < 3; i++) {
            Releas release = new Releas();
            release.setDateLivraison(new Date());
            release.setDatePrevision(new Date());
            release.setDateReelle(new Date());
            releaseRepository.save(release);
        }

    }

    //Initialisation des données de Ticket

    @Override
    public void initTicket() {
      releaseRepository.findAll().forEach(release -> {

                        Stream.of("Déclaration des salaires","Controle de validite","Affilié ajouté sur un mois M").forEach(titreTicket -> {

                            Ticket ticket = new Ticket();
                            ticket.setTitre(titreTicket);
                            double randomNumber6 = Math.random();
                            Types types;
                            if (randomNumber6 < 0.2) {
                                types = Types.ANOMALIE;
                            } else if (randomNumber6 < 0.4) {
                                types = Types.RECIT;
                            } else if (randomNumber6 < 0.6) {
                                types = Types.INCIDENT;
                            } else if (randomNumber6 < 0.8) {
                                types = Types.EVOLUTION;
                            } else {
                                types = Types.HORS_RECIT;
                            }
                            ticket.setType(types);
                            ticket.setRelease(release);
                            ticketRepository.save(ticket);
                        });

                    });
    }


    //Initialisation des données des anomalies
    @Override
    public void initAnomalie() {
               for (int i=0; i<3 ; i++) {
                   Anomalie anomalie = new Anomalie();
                   double randomNumber = Math.random();
                   Criticite criticite;
                   if (randomNumber < 0.33) {
                       criticite = Criticite.BLOQUANTE;
                   } else if (randomNumber < 0.67) {
                       criticite = Criticite.MAJEURE;
                   } else {
                       criticite = Criticite.MINEURE;
                   }
                   anomalie.setCriticite(criticite);
                   anomalie.setPriorite(Math.random() > 0.5 ? Priorite.EN_URGENCE : Priorite.STANDARD);
                   double randomNumber2 = Math.random();
                   Statut statut;
                   if (randomNumber2 < 0.33) {
                       statut = Statut.FERME;
                   } else if (randomNumber2 < 0.67) {
                       statut = Statut.OUVERTE;
                   } else {
                       statut = Statut.CLOTUREE;
                   }
                   anomalie.setStatut(statut);
                   double randomNumber3 = Math.random();
                   EnCours enCours;
                   if (randomNumber3 < 0.33) {
                       enCours = EnCours.Atraite;
                   } else if (randomNumber3 < 0.67) {
                       enCours = EnCours.Verification;
                   } else {
                       enCours = EnCours.Corrigees;
                   }
                   anomalie.setEnCours(enCours);
                   double randomNumber4 = Math.random();
                   Cloturee cloturee;
                   if (randomNumber4 < 0.25) {
                       cloturee = Cloturee.Rejetees;
                   } else if (randomNumber4 < 0.5) {
                       cloturee = Cloturee.ProblemeDocumentaire;
                   } else if (randomNumber4 < 0.75) {
                       cloturee = Cloturee.ArbitrageProjetEvolution;
                   } else {
                       cloturee = Cloturee.ValidationCorrectifs;
                   }
                   anomalie.setCloturee(cloturee);
                   //anomalie.setTicket(ticket);
                   anomalieRepository.save(anomalie);
               }






        }


    //Initialiation des données de Scénario de test
    @Override
    public void initScenarioDeTest() {
for (int i=0; i<3;i++) {
    casDeTestRepository.findAll().forEach(casTest -> {
        Stream.of("Scenario", "ScenarioTest1", "ScenarioTest2").forEach(nomScenario -> {
            ScenarioDeTest scenarioDeTest = new ScenarioDeTest();
            scenarioDeTest.setScenario(nomScenario);
            scenarioDeTest.setCasDeTest(casTest);
            scenarioDeTestRepository.save(scenarioDeTest);
        });
    });

}

    }
    @Override
    public void initCasDeTest() {

      //  ticketRepository.findAll().forEach(tick -> {
        for (int i=0; i<3;i++) {
            CasDeTest casDeTest = new CasDeTest();
            double randomNumber5 = Math.random();
            Resultat resultat;
            if (randomNumber5 < 0.2) {
                resultat = Resultat.OK;
            } else if (randomNumber5 < 0.4) {
                resultat = Resultat.KO;
            } else if (randomNumber5 < 0.6) {
                resultat = Resultat.Nonteste;
            } else if (randomNumber5 < 0.8) {
                resultat = Resultat.Abandonnes;
            } else {
                resultat = Resultat.HorsPerimetre;
            }
            casDeTest.setResultat(resultat);
            //casDeTest.setTicket(tick);
            casDeTestRepository.save(casDeTest);
            //  });
        }
}




    @Override
    public void initTesteur() {
        Stream.of("Andres","Aubérie","Franck","Nicolas","Patricia").forEach(nomTesteur -> {
            Testeur testeur = new Testeur();
            testeur.setNom(nomTesteur);
            testeurRepository.save(testeur);
        });

    }

    @Override
    public void initUser() {
        User user = new User();
        user.setName("Coundoul95");
        user.setPassword("1234");
        userRepository.save(user);

    }


}