package com.github.skype.command;

import com.skype.ChatMessage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

/**
 * @author Pavel Neyzhmak
 */
public class InterrogativeCommand extends AbstractCommand {

    private List<String> interrogativeSentences;

    {
        try {
            interrogativeSentences = Files.readAllLines(new File("resources/interrogative.txt").toPath(), Charset.defaultCharset());
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
        final String randomSentence = interrogativeSentences.get(new Random().nextInt(interrogativeSentences.size()));
        chatMessage.getSender().send(randomSentence);
    }
}
