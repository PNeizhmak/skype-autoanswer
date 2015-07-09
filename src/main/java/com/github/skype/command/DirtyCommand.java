package com.github.skype.command;

import com.github.skype.entity.Dirty;
import com.skype.ChatMessage;

/**
 * @author Pavel Neyzhmak
 */
public class DirtyCommand extends AbstractCommand {


    public DirtyCommand(ChatMessage message) {
        super(message);
    }

    @Override
    public void execute() throws Exception {
        System.out.println("DirtyCommand");
        //todo: vary 2nd part
        chatMessage.getSender().send(Dirty.dirtiesOccurrence + " - предлагаю устроить хотя бы один день без мата )");
        Dirty.dirtiesOccurrence.clear();
    }
}
