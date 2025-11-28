package org.enums.lrs_model.application.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record StatementBatchRequest() {
    @NotEmpty
    static List<StatementRequest> statements;
}
