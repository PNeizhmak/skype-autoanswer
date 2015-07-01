package com.github.skype;

import com.skype.*;

/**
 * @author Pavel Neizhmak
 */
public class AutoAnswering {
    public static void main(String[] args) throws Exception {

        System.out.println("Start Auto Answering ...");

        // This line needs to prevent exiting from this program
        Skype.setDaemon(false);

        Skype.addChatMessageListener(new ChatMessageAdapter() {
            public void chatMessageReceived(ChatMessage received)
                    throws SkypeException {
                ChatMessage.Type type = received.getType();
                if (type.equals(ChatMessage.Type.SAID)) {

                    User sender = received.getSender();

                    System.out.println(sender.getId() + " say:");
                    System.out.println(" " + received.getContent());

                    received.getSender().send(
                            "I'm working. Please, wait a moment.");

                    System.out.println(" - Auto answered!");
                }
            }
        });


        System.out.println("Auto Answering started!");
    }
}
