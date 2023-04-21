package ee.carlrobert.openai.client.completion.chat;

import ee.carlrobert.openai.client.ClientCode;
import ee.carlrobert.openai.client.OpenAIClient;
import ee.carlrobert.openai.client.completion.CompletionClient;
import ee.carlrobert.openai.client.completion.CompletionEventListener;
import ee.carlrobert.openai.client.completion.chat.request.ChatCompletionRequest;
import okhttp3.sse.EventSource;

public class ChatCompletionClient extends CompletionClient {

  private static final String API_URL = "https://api.openai.com/v1/chat/completions";

  public ChatCompletionClient(OpenAIClient client) {
    super(client, API_URL);
  }

  public ChatCompletionClient(OpenAIClient client, String apiUrl) {
    super(client, apiUrl);
  }

  @Override
  protected ChatCompletionEventSourceListener getEventListener(CompletionEventListener listeners) {
    return new ChatCompletionEventSourceListener(listeners);
  }

  @Override
  protected ClientCode getClientCode() {
    return ClientCode.CHAT_COMPLETION;
  }

  public EventSource stream(ChatCompletionRequest requestBody, CompletionEventListener listeners) {
    return createNewEventSource(requestBody, listeners);
  }
}
