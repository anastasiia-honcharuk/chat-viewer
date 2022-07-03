package app;

import java.util.Vector;

/**
 * class responsible for putting the data taken from msg file in the vector of Message instances
 */
public class MsgChatFiller extends ChatFiller {
    /**
     *
     * @param lines vector of strings that were read from the file
     * @return vector of filled in Message instances
     */
    @Override
    public Vector<Message> fill(Vector<String> lines) {
        Vector<Message> messageVector = new Vector<>();
        String currentNick = "";
        int timeLength = "Time:".length();
        int nameLength = "Name:".length();
        int contentLength = "Message:".length();
        for (int i = 0; i<lines.size(); i = i+4){
            Message m = new Message();
            m.setTime(lines.get(i).substring(timeLength));
            if (currentNick.equals("")){
                m.setUsername(lines.get(i+1).substring(nameLength));
                currentNick = m.getUsername();
            } else {
                if(currentNick.equals(lines.get(i+1).substring(nameLength))){
                    m.setUsername("...");
                } else {
                    m.setUsername(lines.get(i+1).substring(nameLength));
                    currentNick = lines.get(i+1).substring(nameLength);
                }
            }
            m.setContent(lines.get(i+2).substring(contentLength));
            messageVector.add(m);
        }
        return messageVector;
    }
}
