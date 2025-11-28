package org.enums.lrs_model.application.dto.request;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotNull;

public record StatementRequest(
        @NotNull JsonNode statement
) {}
