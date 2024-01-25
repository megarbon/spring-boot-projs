package com.example.crudmelaku;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeporteRepository extends JpaRepository<Deporte, Integer> {
    public Deporte findById(int id);

    public int deleteById(int id);
}
