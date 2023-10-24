package org.example;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;

public class ChatService {

    public final OpenAiService aiService;
    public static final String USER_ROlE = "user";
    public static final String ASSISTANT_ROLE = "assistant";

    public ChatService() {
        String CHAT_GPT_TOKEN = "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";
        aiService = new OpenAiService(CHAT_GPT_TOKEN);
    }
    public String getChatMessages(List<ChatMessage> conversation) {

        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .messages(conversation)
                .model("gpt-3.5-turbo")
                .build();

        return aiService.createChatCompletion(completionRequest)
                .getChoices()
                .get(0)
                .getMessage()
                .getContent();
    }
}
