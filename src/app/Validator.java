package app;

import java.util.Vector;

/**
 * Class responsible for checking whether the file has correct formatting
 */

public abstract class Validator {
    public Validator() {
    }

    /**
     *
     * @param lines the vector of strings that were read from the file
     * @throws ChatIncorrectFileFormatException if the file has wrong formatting
     */
    abstract void validate(Vector<String> lines) throws ChatIncorrectFileFormatException;
}
