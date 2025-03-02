package com.ai.demo.dto;

public class Response {
    private Content content;
    private String finishReason;
    private Long avgLogprobs;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public Long getAvgLogprobs() {
        return avgLogprobs;
    }

    public void setAvgLogprobs(Long avgLogprobs) {
        this.avgLogprobs = avgLogprobs;
    }
}
