package com.dione.testingmanagebackend.controlleur;

import com.dione.testingmanagebackend.entities.ScenarioDeTest;
import com.dione.testingmanagebackend.service.serviceImpl.ScenarioServiceImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scenarioManager")
public class ScenarioDeTestControlleur {

    private final ScenarioServiceImpl scenarioService;

    private ScenarioDeTest scenarioDeTest = new ScenarioDeTest();

    public ScenarioDeTestControlleur(ScenarioServiceImpl scenarioService) {
        this.scenarioService = scenarioService;
    }

    @GetMapping
    public ResponseEntity<List<ScenarioDeTest>> getAllScenarioTest(){
        List<ScenarioDeTest> scenarioDeTests = scenarioService.getAllScenario();
        return ResponseEntity.ok().body(scenarioDeTests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScenarioDeTest> getScenarioTest(@PathVariable(value="refScenario") Long refScenario) throws ResourceNotFoundException {
        scenarioDeTest = scenarioService.getScenario(refScenario);
        return ResponseEntity.ok().body(scenarioDeTest);
    }

    @PostMapping
    public ResponseEntity<ScenarioDeTest> addScenarioTest(@RequestBody ScenarioDeTest scenarioDeTest){
        return ResponseEntity.ok().body(scenarioService.addScenario(scenarioDeTest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScenarioDeTest> updateScenarioTest(@PathVariable (value = "refScenario", required = false) Long refScenario, @RequestBody ScenarioDeTest scenarioDeTestRequest ) throws ResourceNotFoundException {
        scenarioDeTestRequest.setRefScenario(refScenario);
        return ResponseEntity.ok().body(scenarioService.updateScenario(scenarioDeTestRequest));
    }

    @DeleteMapping("/{id}")
    public String deleteScenarioTest(@PathVariable(value="refScenario") Long refScenario){
        scenarioService.deleteScenario(refScenario);
        return "ok";
    }
}
