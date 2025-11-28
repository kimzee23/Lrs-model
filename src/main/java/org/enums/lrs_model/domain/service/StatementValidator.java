package org.enums.lrs_model.domain.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class StatementValidator {

    // Basic validation – you can expand later
    public void validate(JsonNode statement) {
        if (statement == null || statement.isEmpty()) {
            throw new IllegalArgumentException("Invalid xAPI statement: empty body");
        }

        if (!statement.has("actor") || !statement.has("verb") || !statement.has("object")) {
            throw new IllegalArgumentException("Invalid xAPI statement: missing actor/verb/object");
        }
    }
}