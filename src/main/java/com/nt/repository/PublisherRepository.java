package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    boolean existsByEmail(String email);
}

