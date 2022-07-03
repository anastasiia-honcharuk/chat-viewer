package app;

import javafx.scene.text.TextFlow;
/**
 * Class responsible for displaying the chat on GUI
 */
public abstract class Displayer {
    /**
     *
     * @param textFlow textflow
     */
    abstract void displayChat(TextFlow textFlow, Chat chat);
}
