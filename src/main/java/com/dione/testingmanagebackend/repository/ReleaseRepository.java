package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
