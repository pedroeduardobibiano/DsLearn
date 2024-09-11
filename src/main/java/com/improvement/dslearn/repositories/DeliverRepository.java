package com.improvement.dslearn.repositories;

import com.improvement.dslearn.entities.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {
}