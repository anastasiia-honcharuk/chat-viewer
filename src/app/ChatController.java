package app;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * connects GUI with the rest of application
 */
public class ChatController {
    private final Chat chat = new Chat();
    private final Displayer displayer = new BasicDisplayer();
    private File currentPath = null;
    public Label label;
    public TextFlow textFlow;

    /**
     * executes when the button is clicked
     * @param actionEvent
     */
    public void onSelectFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(currentPath);
        File file = fileChooser.showOpenDialog(Main.stage);
        if (file == null) {
            return;
        }
        currentPath = file.getParentFile();
        label.setText(file.getAbsolutePath());
        try {
            if (!chat.isEmpty()) {
                chat.clear();
            }
            chat.load(file.getAbsolutePath());
            displayer.displayChat(textFlow,chat);
        } catch (EmptyChatFileException e) {
            new Alert(Alert.AlertType.ERROR, "The file " + file.getName() + " is empty!", ButtonType.OK).showAndWait();
        } catch (FileNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "The file is not found!", ButtonType.OK).showAndWait();
        } catch (ChatIncorrectFileFormatException e) {
            new Alert(Alert.AlertType.ERROR, file.getName() + " has incorrect format!", ButtonType.OK).showAndWait();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(),ButtonType.OK).showAndWait();
        }
    }
}



