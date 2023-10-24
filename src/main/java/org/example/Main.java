package org.example;

import com.theokanning.openai.completion.chat.ChatMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi I am chatGPT. Ask me something!");

        List<ChatMessage> conversation = new ArrayList<>();
        ChatService chatService = new ChatService();

        while(true){

            String inputMessage = scanner.nextLine();
            if( "bye".equalsIgnoreCase(inputMessage) ) {
                System.out.println("Bye!");
                break;
            }

            ChatMessage userMessage = new ChatMessage(ChatService.USER_ROlE, inputMessage);
            conversation.add(userMessage);

            String assistantResponse = chatService.getChatMessages(conversation);
            ChatMessage assistantMessage = new ChatMessage(ChatService.ASSISTANT_ROLE, assistantResponse);
            conversation.add(assistantMessage);

            System.out.println(assistantResponse);
        }
    }
}