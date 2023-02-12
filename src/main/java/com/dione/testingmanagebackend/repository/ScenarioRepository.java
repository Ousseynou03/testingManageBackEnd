package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.ScenarioDeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScenarioRepository extends JpaRepository<ScenarioDeTest, Long> {
}
