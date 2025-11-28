package org.enums.lrs_model.domain.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class Cmi5RulesService {

    public void validateIfCmi5(JsonNode statement) {

        // If no cmi5 context category, skip
        if (!statement.has("context")) return;

        JsonNode context = statement.get("context");
        if (!context.has("contextActivities")) return;

        // Check if cmi5 category exists
        JsonNode categories = context.get("contextActivities").get("category");
        if (categories == null) return;

        boolean isCmi5 = false;

        for (JsonNode cat : categories) {
            if (cat.has("id") && cat.get("id").asText().contains("cmi5")) {
                isCmi5 = true;
                break;
            }
        }

        if (!isCmi5) return; // not a cmi5 statement → done

        // Minimal cmi5 rule enforcement
        if (!statement.has("verb")) {
            throw new IllegalArgumentException("cmi5 statement missing verb");
        }

        // You will later enforce:
        // - initialized first
        // - terminated last
        // - session registration
    }
}