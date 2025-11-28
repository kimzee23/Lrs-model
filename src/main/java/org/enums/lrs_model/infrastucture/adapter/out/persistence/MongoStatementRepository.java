package org.enums.lrs_model.infrastucture.adapter.out.persistence;


import com.fasterxml.jackson.databind.JsonNode;
import org.enums.lrs_model.infrastucture.adapter.out.StatementRepositoryPort;
import org.enums.lrs_model.infrastucture.adapter.out.entity.StatementEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MongoStatementRepository implements StatementRepositoryPort {

    private final MongoStatementRepository mongoRepo;

    public MongoStatementRepository(MongoStatementRepository mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public UUID save(JsonNode statement) {
        UUID id = UUID.randomUUID();
        mongoRepo.save(new StatementEntity(id, statement).getStatement());
        return id;
    }
}