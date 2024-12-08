package ca.gbc.approvalservice.service;

import ca.gbc.approvalservice.model.Approval;
import ca.gbc.approvalservice.repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    // Get all approvals
    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    // Get an approval by ID
    public Optional<Approval> getApprovalById(String id) {
        return approvalRepository.findById(id);
    }

    // Create a new approval
    public Approval createApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    // Update an approval
    public Approval updateApproval(String id, Approval approvalDetails) {
        return approvalRepository.findById(id).map(approval -> {
            approval.setStatus(approvalDetails.getStatus());
            approval.setNotes(approvalDetails.getNotes());
            return approvalRepository.save(approval);
        }).orElseThrow(() -> new RuntimeException("Approval not found with id " + id));
    }

    // Delete an approval
    public void deleteApproval(String id) {
        approvalRepository.deleteById(id);
    }
}
