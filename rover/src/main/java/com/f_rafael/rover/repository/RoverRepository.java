package com.f_rafael.rover.repository;

import com.f_rafael.rover.models.Rover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoverRepository extends JpaRepository<Rover,Long> {
}
