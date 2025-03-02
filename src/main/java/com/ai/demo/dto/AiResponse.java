package com.ai.demo.dto;

import java.util.List;

public class AiResponse {
    List<Response> candidates;
    private AiMetaData usageMetadata;
    private String modelVersion;

    public List<Response> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Response> candidates) {
        this.candidates = candidates;
    }

    public AiMetaData getUsageMetadata() {
        return usageMetadata;
    }

    public void setUsageMetadata(AiMetaData usageMetadata) {
        this.usageMetadata = usageMetadata;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
}
