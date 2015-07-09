package com.github.skype.entity;

import com.github.skype.util.Properties;
import com.github.skype.util.Utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 * @author Pavel Neyzhmak
 */
public class Dirty {

    public static List<String> dirties;
    public static HashSet<String> dirtiesOccurrence = new HashSet<String>();

    static {
        try {
            dirties = Utils.readFile(Properties.DIRTIES_RESOURCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
