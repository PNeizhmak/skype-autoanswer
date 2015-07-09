package com.github.skype.entity;

import com.github.skype.util.Properties;
import com.github.skype.util.Utils;

import java.io.IOException;
import java.util.List;

/**
 * @author Pavel Neyzhmak
 */
public class Emotions {

    public static List<String> emotions;

    static {
        try {
            emotions = Utils.readFile(Properties.EMOTIONS_RESOURCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
