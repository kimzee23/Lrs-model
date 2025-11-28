package org.enums.lrs_model.application.dto.request;

import com.fasterxml.jackson.databind.JsonNode;

public record StatementRequest(JsonNode statement) {}
