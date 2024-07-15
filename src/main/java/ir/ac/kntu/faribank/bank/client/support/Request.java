package ir.ac.kntu.faribank.bank.client.support;

public class Request {
    private Feature feature;
    private StateOfRequest stateOfRequest;
    private String feedbackText;
    private String requestText;

    public Request(Feature feature, String feedbackText) {
        setFeature(feature);
        setFeedbackText(feedbackText);
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

    @Override
    public String toString() {
        return "Request{" +
        "\nfeature: '" + feature +
        "\'\nstateOfRequest: '" + stateOfRequest +
        "\'\nfeedbackText: '" + feedbackText +
        "\'\nrequestText: '" + requestText +
        "\'\n}";
    }
}
