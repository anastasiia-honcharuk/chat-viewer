package app;

import java.util.Vector;

/**
 * class responsible for putting the data in the vector of Message instances
 */
public abstract class ChatFiller {
    /**
     *
     * @param lines vector of strings that were read from the file
     * @return vector of filled in Message instances
     */
    abstract Vector<Message> fill(Vector<String> lines);
}
