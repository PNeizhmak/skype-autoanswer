package com.github.skype.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

/**
 * @author Pavel Neyzhmak
 */
public class Utils {

    public static List<String> readFile(final String fileName) throws IOException {
        return Files.readAllLines(new File(Properties.RESOURCES + fileName).toPath(), Charset.forName(Properties.UTF_8));
    }

    public static String getRandomItemFromList(final List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
