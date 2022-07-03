package app;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

/**
 * Class that represents a chat
 */
public class Chat {
    private Vector<Message> messageVector = new Vector<>();
    private final Validator validator = new MsgValidator();
    private final ChatFiller chatFiller = new MsgChatFiller();

    /**
     * method that reads the file and puts the data in messageVector
     * @param string absolute path of the chosen file
     * @throws EmptyChatFileException if the file is empty
     * @throws IOException if can not close fileInputStream
     * @throws ChatIncorrectFileFormatException if file does not meet the formatting specifications
     */
    public void load(String string) throws EmptyChatFileException, IOException, ChatIncorrectFileFormatException {
        FileInputStream fileInputStream = new FileInputStream(string);
        Scanner scanner = new Scanner(fileInputStream);
        Vector<String> lines = new Vector<>();
        try {
            fileInputStream = new FileInputStream(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lines.isEmpty()) {
            throw new EmptyChatFileException();
        }
        validator.validate(lines);
        messageVector = chatFiller.fill(lines);
    }

    /**
     *
     * @return the vector of messages that are in chat
     */
    public Vector<Message> getMessageVector() {
        return messageVector;
    }

    /**
     * deletes all data from chat
     */
    public void clear(){
        messageVector.clear();
    }

    /**
     *
     * @return true is chat is empty, false if not
     */
    public boolean isEmpty(){
        return messageVector.isEmpty();
    }
}
