package com.growthX.assignment.repository;

import com.growthX.assignment.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByAdminIdAndStatus(String adminId, String status);
}
