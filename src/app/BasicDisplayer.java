package app;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Class responsible for displaying the chat on GUI
 */

public class BasicDisplayer extends Displayer {
    private Image happyImage;
    private Image sadImage;

    /**
     *
     * @param textFlow textflow
     * @param chat Chat object that needs to be displayed
     */
    @Override
    void displayChat(TextFlow textFlow, Chat chat) {
        Font fontRegular = Font.font("Verdana", FontWeight.NORMAL, 12);
        Font fontBold = Font.font("Verdana", FontWeight.EXTRA_BOLD, 12);
        happyImage = new Image("smile_happy.gif");
        sadImage = new Image("smile_sad.gif");
        textFlow.getChildren().clear();
        for (var message : chat.getMessageVector()) {
            displayTime(message,textFlow, fontRegular);
            displayUsername(message,textFlow, fontRegular);
            displayContent(message,textFlow, fontBold);
            textFlow.getChildren().add(new Text("\n"));
        }
    }

    /**
     *
     * @param message Message from which to extract the info
     * @param textflow textflow
     * @param font that is used to display time
     */
    private void displayTime(Message message,TextFlow textflow,Font font){
        Text textTime;
        textTime = new Text("[" + message.getTime() + "]");
        textTime.setFont(font);
        textflow.getChildren().add(textTime);
    }

    /**
     *  @param message Message from which to extract the info
     * @param textflow textflow
     * @param font that is used to display username
     */
    private void displayUsername(Message message, TextFlow textflow, Font font){
        Text textUsername;
        textUsername = new Text(message.getUsername() + ":");
        textUsername.setFill(Color.BLUE);
        textUsername.setFont(font);
        textflow.getChildren().add(textUsername);
    }

    /**
     *
     * @param message Message from which to extract the info
     * @param textflow textflow
     * @param font that is used to display content
     */
    private void displayContent(Message message, TextFlow textflow, Font font){
        String pair;
        Text textContent;
        for (int i = 0; i < message.getContent().length() - 1; ) {
            pair = message.getContent().substring(i, i + 2);
            switch (pair) {
                case ":)" -> {
                    textflow.getChildren().add(new ImageView(happyImage));
                    i += 2;
                }
                case ":(" -> {
                    textflow.getChildren().add(new ImageView(sadImage));
                    i += 2;
                }
                default -> {
                    if (i == message.getContent().length() - 2) {
                        textContent = new Text(pair);
                    } else {
                        textContent = new Text(Character.toString(message.getContent().charAt(i)));
                    }
                    textContent.setFont(font);
                    textflow.getChildren().add(textContent);
                    i++;
                }
            }
        }
    }
}