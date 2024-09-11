package com.improvement.dslearn.repositories;

import com.improvement.dslearn.entities.Enrollment;
import com.improvement.dslearn.entities.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}