package com.qa.spring.hedgehog.repos;

import com.qa.spring.hedgehog.domain.Garden;
import com.qa.spring.hedgehog.domain.Hedgehog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GardenRepo extends JpaRepository<Garden, Integer> {

}
