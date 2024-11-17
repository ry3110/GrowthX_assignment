package com.growthX.assignment.controller;

import com.growthX.assignment.model.Assignment;
import com.growthX.assignment.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/assignments")
    public List<Assignment> getAssignments(@RequestParam String adminId) {
        return adminService.getAssignments(adminId);
    }

    @PostMapping("/assignments/{id}/accept")
    public Assignment acceptAssignment(@PathVariable String id) {
        return adminService.acceptAssignment(id);
    }

    @PostMapping("/assignments/{id}/reject")
    public Assignment rejectAssignment(@PathVariable String id) {
        return adminService.rejectAssignment(id);
    }
}
