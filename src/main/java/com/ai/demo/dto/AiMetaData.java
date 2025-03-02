package com.ai.demo.dto;

import java.util.List;

public class AiMetaData {
    private int promptTokenCount;
    private int candidatesTokenCount;
    private int totalTokenCount;
    private List<AIDetail> promptTokensDetails;
    private List<AIDetail> candidatesTokensDetails;

    public int getPromptTokenCount() {
        return promptTokenCount;
    }

    public void setPromptTokenCount(int promptTokenCount) {
        this.promptTokenCount = promptTokenCount;
    }

    public int getCandidatesTokenCount() {
        return candidatesTokenCount;
    }

    public void setCandidatesTokenCount(int candidatesTokenCount) {
        this.candidatesTokenCount = candidatesTokenCount;
    }

    public int getTotalTokenCount() {
        return totalTokenCount;
    }

    public void setTotalTokenCount(int totalTokenCount) {
        this.totalTokenCount = totalTokenCount;
    }

    public List<AIDetail> getPromptTokensDetails() {
        return promptTokensDetails;
    }

    public void setPromptTokensDetails(List<AIDetail> promptTokensDetails) {
        this.promptTokensDetails = promptTokensDetails;
    }

    public List<AIDetail> getCandidatesTokensDetails() {
        return candidatesTokensDetails;
    }

    public void setCandidatesTokensDetails(List<AIDetail> candidatesTokensDetails) {
        this.candidatesTokensDetails = candidatesTokensDetails;
    }
}
