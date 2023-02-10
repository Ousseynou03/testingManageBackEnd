package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.CasDeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasDeTestRepository extends JpaRepository<CasDeTest, Long> {
}
