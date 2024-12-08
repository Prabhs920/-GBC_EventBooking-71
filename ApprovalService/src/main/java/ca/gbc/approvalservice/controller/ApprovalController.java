package ca.gbc.approvalservice.controller;

import ca.gbc.approvalservice.model.Approval;
import ca.gbc.approvalservice.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    // GET all approvals
    @GetMapping
    public List<Approval> getAllApprovals() {
        return approvalService.getAllApprovals();
    }

    // GET an approval by ID
    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable String id) {
        return approvalService.getApprovalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST a new approval
    @PostMapping
    public Approval createApproval(@RequestBody Approval approval) {
        return approvalService.createApproval(approval);
    }

    // PUT update an approval
    @PutMapping("/{id}")
    public ResponseEntity<Approval> updateApproval(@PathVariable String id, @RequestBody Approval approvalDetails) {
        try {
            Approval updatedApproval = approvalService.updateApproval(id, approvalDetails);
            return ResponseEntity.ok(updatedApproval);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE an approval
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApproval(@PathVariable String id) {
        approvalService.deleteApproval(id);
        return ResponseEntity.noContent().build();
    }
}
