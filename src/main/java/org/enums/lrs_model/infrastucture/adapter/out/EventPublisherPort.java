package org.enums.lrs_model.infrastucture.adapter.out;

import com.fasterxml.jackson.databind.JsonNode;

public interface EventPublisherPort {
    void publish(JsonNode statement);
}