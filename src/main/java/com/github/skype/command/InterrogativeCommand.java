package com.github.skype.command;

import com.github.skype.util.Properties;
import com.github.skype.util.Utils;
import com.skype.ChatMessage;

import java.io.IOException;
import java.util.List;

/**
 * @author Pavel Neyzhmak
 */
public class InterrogativeCommand extends AbstractCommand {

    private static List<String> interrogativeSentences;

    static {
        try {
            interrogativeSentences = Utils.readFile(Properties.INTERROGATIVE_RESOURCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InterrogativeCommand(ChatMessage message) {
        super(message);
    }

    @Override
    public void execute() throws Exception {
        System.out.println("InterrogativeCommand");
        final String randomSentence = Utils.getRandomItemFromList(interrogativeSentences);
        chatMessage.getSender().send(randomSentence);
    }


}
