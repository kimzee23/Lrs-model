package org.enums.lrs_model.application.port.in;

import org.enums.lrs_model.application.dto.request.StatementRequest;
import org.enums.lrs_model.application.dto.response.StatementResponse;

import java.util.UUID;


public interface IngestStatementPort {
    UUID ingest(StatementRequest statement,  String authHeader);
}