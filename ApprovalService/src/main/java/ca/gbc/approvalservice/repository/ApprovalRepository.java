package ca.gbc.approvalservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ca.gbc.approvalservice.model.Approval;

public interface ApprovalRepository extends MongoRepository<Approval, String> {
    // You can add custom query methods here if needed
}
