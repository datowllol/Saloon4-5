package com.saloon.Saloon.repository;

import com.saloon.Saloon.model.FreeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FreeTableRepository extends JpaRepository<FreeTable, UUID> {
}
