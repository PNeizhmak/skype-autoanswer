package com.github.skype.entity;

/**
 * @author Pavel Neyzhmak
 */
public enum SentenceType {
    //?
    INTERROGATIVE("interrogative"),
    //!
    EXCLAMATORY("exclamatory"),
    BASIC("basic");

    private final String type;

    private SentenceType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
