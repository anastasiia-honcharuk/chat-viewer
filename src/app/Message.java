package app;

/**
 * class that represents the message with the data in it
 */
public class Message {
    /**
     * each message consists of the time it was sent, the senders username and the content
     */
    private String time;
    private String username;
    private String content;

    /**
     *
     * @return time the message was sent
     */
    public String getTime(){
        return time;
    }

    /**
     *
     * @return senders username
     */
    public String getUsername(){
        return username;
    }

    /**
     *
     * @return text contents
     */
    public String getContent(){
        return content;
    }

    /**
     * set time
     * @param time the message was sent
     */
    public void setTime(String time){
        this.time = time;
    }

    /**
     * set username
     * @param username senders username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * set content
     * @param content text contents
     */
    public void setContent(String content){
        this.content = content;
    }
}
