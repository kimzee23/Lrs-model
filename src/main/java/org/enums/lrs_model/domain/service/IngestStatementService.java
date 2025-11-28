package org.enums.lrs_model.domain.service;


import lombok.AllArgsConstructor;
import org.enums.lrs_model.application.dto.request.StatementRequest;
import org.enums.lrs_model.application.port.in.IngestStatementPort;
import org.enums.lrs_model.infrastucture.adapter.out.EventPublisherPort;
import org.enums.lrs_model.infrastucture.adapter.out.StatementRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IngestStatementService implements IngestStatementPort {

    private final StatementValidator validator;
    private final Cmi5RulesService cmi5Service;
    private final StatementRepositoryPort repo;
    private final EventPublisherPort publisher;

    public IngestStatementService(
            StatementValidator validator,
            Cmi5RulesService cmi5Service,
            StatementRepositoryPort repo,
            EventPublisherPort publisher
    )
    {
        this.validator = validator;
        this.cmi5Service = cmi5Service;
        this.repo = repo;
        this.publisher = publisher;
    }

    @Override
    public UUID ingest(StatementRequest statementRequest, String authHeader) {

        // Validate JSON structure
        validator.validate(statementRequest.statement());

        // Optionally validate cmi5 (if context indicates)
        cmi5Service.validateIfCmi5(statementRequest.statement());

        // Persist to DB and publish event
        UUID id = repo.save(statementRequest.statement());
        publisher.publish(statementRequest.statement());

        return id;
    }
}
