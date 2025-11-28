package org.enums.lrs_model.infrastucture.adapter.out.entity;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "statements")
public class StatementEntity {

    @Id
    private UUID id;

    private JsonNode statement;

    private Instant timestamp = Instant.now();

    public StatementEntity(UUID id, JsonNode statement) {
        this.id = id;
        this.statement = statement;
    }

    public UUID getId() {
        return id;
    }

    public JsonNode getStatement() {
        return statement;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}