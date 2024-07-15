package ir.ac.kntu.faribank.bank.client.support;

import java.time.LocalDateTime;

public class Request implements Comparable<Request> {
    private Feature feature;
    private StateOfRequest stateOfRequest;
    private String feedbackText;
    private String requestText;
    private LocalDateTime date;

    public Request(Feature feature, String requestText) {
        date = LocalDateTime.now();
        setFeature(feature);
        setRequestText(requestText);
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setStateOfRequest(StateOfRequest stateOfRequest) {
        this.stateOfRequest = stateOfRequest;
    }

    public StateOfRequest getStateOfRequest() {
        return stateOfRequest;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Request{" +
        "\nfeature: '" + feature +
        "\'\nstateOfRequest: '" + stateOfRequest +
        "\'\nfeedbackText: '" + feedbackText +
        "\'\nrequestText: '" + requestText +
        "\'\ndate: " + date +
        "\n}";
    }

    @Override
    public int compareTo(Request request) {
        return request.getDate().compareTo(this.date);
    }
}
