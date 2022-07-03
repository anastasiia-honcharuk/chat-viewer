package app;

import java.util.Vector;

/**
 * class responsible for checking that the msg file follows the given format
 */

public class MsgValidator extends Validator {
    /**
     *
     * @param lines the vector of strings that were read from the file
     * @throws ChatIncorrectFileFormatException when file has incorrect formatting
     */
    public void validate(Vector<String> lines) throws ChatIncorrectFileFormatException {
        // check if the file can be correct by the number of lines:
        // let N be an integer number of messages, L an integer number of lines, then
        // 3*N+(N-1) = L =>  4*N = L+1
        if ((lines.size() + 1) % 4 != 0) {
            throw new ChatIncorrectFileFormatException();
        }
        int messages = (lines.size() + 1) / 4;
        int j;
        // index i is for go through  the messages, j is for visiting inside the single message
        for (int i = 0;i<messages;i++){
            if (i!=0){
                j = i*4;
            } else {
                j = 0;
            }
            //check if time and username and content lines start correctly
            if (lines.get(j).matches("Time:(.*)") && lines.get(j+1).matches("Name:(.*)") &&
                    lines.get(j+2).matches("Message:(.*)")){
                //check if time and username are empty
                if(lines.get(j).substring(5).isBlank() || lines.get(j+1).substring(5).isBlank()){
                    throw new ChatIncorrectFileFormatException();
                }
            } else {
                throw new ChatIncorrectFileFormatException();
            }
            //checking if there is an empty line after each message(but not after last one)
            if (i!=messages-1){
                if (!lines.get(j+3).isBlank()){
                    throw new ChatIncorrectFileFormatException();
                }
            }
        }
    }

}
