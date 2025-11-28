package org.enums.lrs_model.infrastucture.adapter.out;


import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

public interface StatementRepositoryPort {
    UUID save(JsonNode rawStatement);
}