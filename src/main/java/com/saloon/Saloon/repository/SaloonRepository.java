package com.saloon.Saloon.repository;

import com.saloon.Saloon.model.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaloonRepository extends JpaRepository<Saloon, UUID> {
}
