package com.growthX.assignment.service;

import com.growthX.assignment.model.Assignment;
import com.growthX.assignment.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AssignmentRepository assignmentRepository;

    public AdminService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAssignments(String adminId) {
        return assignmentRepository.findByAdminIdAndStatus(adminId, "pending");
    }

    public Assignment acceptAssignment(String id) {
        Assignment assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setStatus("accepted");
        return assignmentRepository.save(assignment);
    }

    public Assignment rejectAssignment(String id) {
        Assignment assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setStatus("rejected");
        return assignmentRepository.save(assignment);
    }
}

