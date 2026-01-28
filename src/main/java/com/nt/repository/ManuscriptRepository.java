package com.nt.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Manuscript;

import java.util.List;

public interface ManuscriptRepository extends JpaRepository<Manuscript, Long> {
    List<Manuscript> findByPublisherId(Long publisherId);
}

