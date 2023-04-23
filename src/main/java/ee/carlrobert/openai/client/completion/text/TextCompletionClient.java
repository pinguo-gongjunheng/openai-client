package ee.carlrobert.openai.client.completion.text;

import ee.carlrobert.openai.client.ClientCode;
import ee.carlrobert.openai.client.OpenAIClient;
import ee.carlrobert.openai.client.completion.CompletionClient;
import ee.carlrobert.openai.client.completion.CompletionEventListener;
import ee.carlrobert.openai.client.completion.text.request.TextCompletionRequest;
import okhttp3.sse.EventSource;

public class TextCompletionClient extends CompletionClient {

    private static final String API_URL = "https://api.openai.com/v1/completions";

    public TextCompletionClient(OpenAIClient client) {
        super(client, API_URL);
    }

    public TextCompletionClient(OpenAIClient client, String apiUrl) {
        super(client, apiUrl);
    }

    @Override
    protected TextCompletionEventSourceListener getEventListener(CompletionEventListener listeners) {
        return new TextCompletionEventSourceListener(listeners);
    }

    @Override
    protected ClientCode getClientCode() {
        return ClientCode.TEXT_COMPLETION;
    }

    public EventSource stream(TextCompletionRequest requestBody, CompletionEventListener listeners) {
        return createNewEventSource(requestBody, listeners);
    }
}
