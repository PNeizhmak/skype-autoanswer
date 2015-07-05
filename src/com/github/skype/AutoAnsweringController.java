package com.github.skype;

import com.github.skype.command.AbstractCommand;
import com.github.skype.command.factory.CommandFactory;
import com.github.skype.entity.SentenceType;
import com.github.skype.util.Properties;
import com.skype.ChatMessage;
import com.skype.ChatMessageAdapter;
import com.skype.Skype;
import com.skype.SkypeException;
import com.skype.User;

/**
 * @author Pavel Neizhmak
 */
public class AutoAnsweringController {
    public static void main(String[] args) throws Exception {

        System.out.println(Properties.START_AUTO_ANSWERING);

        // This line needs to prevent exiting from this program
        Skype.setDaemon(false);

        Skype.addChatMessageListener(new ChatMessageAdapter() {
            public void chatMessageReceived(ChatMessage received) throws SkypeException {
                try {
                    analyzeIncomingText(received);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(Properties.AUTO_ANSWERING_STARTED);
    }

    private static void analyzeIncomingText(ChatMessage received) throws Exception {

        final ChatMessage.Type type = received.getType();

        if (type.equals(ChatMessage.Type.SAID)) {

            final User sender = received.getSender();
            final String incomingText = received.getContent().trim();

            System.out.println(sender.getId() + Properties.SAY);
            System.out.println(Properties.SPACE + incomingText);

            String sentenceType = analyzeSentenceType(incomingText);

            //todo: proceed according to type
            if (sentenceType.equals(SentenceType.INTERROGATIVE.getType())) {
                AbstractCommand commandToExecute = CommandFactory.getCommand(Properties.INTERROGATIVE, received);
                commandToExecute.execute();
            } else {
                //temporary solution
                AbstractCommand commandToExecute = CommandFactory.getCommand(Properties.EMOTED, received);
                commandToExecute.execute();

            }

            System.out.println(Properties.AUTO_ANSWERED);
        }
    }

    private static String analyzeSentenceType(String incomingText) {

        String sentenceType = SentenceType.BASIC.getType();

        if (incomingText.endsWith(Properties.QUESTION)) {
            sentenceType = SentenceType.INTERROGATIVE.getType();
        } else if (incomingText.endsWith(Properties.EXCLAMATION)) {
            sentenceType = SentenceType.EXCLAMATORY.getType();
        } else if (incomingText.endsWith(Properties.DOT) || incomingText.endsWith(Properties.DOT_SPACE)) {
            sentenceType = SentenceType.BASIC.getType();
        }

        return sentenceType;
    }
}