package org.enums.lrs_model.application.dto.response;

import java.util.List;

public record StatementBatchResponse(
        List<StatementResponse> result

) {
}
