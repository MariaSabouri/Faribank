package ir.ac.kntu.faribank.bank.client.support;

import java.time.LocalDateTime;

import org.json.JSONObject;

import ir.ac.kntu.faribank.bank.Json;

public class Request implements Comparable<Request>, Json {
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

    public void setDateNow() {
        this.date = LocalDateTime.now();
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("feature", feature);
        jsonObject.put("stateOfRequest", stateOfRequest);
        jsonObject.put("feedbackText", feedbackText);
        jsonObject.put("requestText", requestText);
        jsonObject.put("date", date);

        return jsonObject;
    }

    // public void parse(JSONObject jsonObject) {
    //     setFeature(Feature.valueOf(jsonObject.getString("feature")));
    //     setStateOfRequest(StateOfRequest.valueOf(jsonObject.getString("stateOfRequest")));
    //     setFeedbackText(jsonObject.getString("feedbackText"));
    //     setRequestText(jsonObject.getString("requestText"));
    //     setDate(LocalDateTime.parse(jsonObject.getString("date")));
    // }

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
