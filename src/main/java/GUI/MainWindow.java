package GUI;

import Papagu.Ui.Papagu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    private Papagu papagu;
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/Enel.png"));
    private Image papaguImage = new Image(this.getClass().getResourceAsStream("/images/Papagu.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setPapagu(Papagu papagu) {
        this.papagu = papagu;
        String welcomeMessage = "Hello! I'm Papagu\nWhat can I do for you?";
        dialogContainer.getChildren().add(DialogBox.getPapaguDialog(welcomeMessage, papaguImage));
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String userText = userInput.getText();
        userInput.clear();

        // Get response from Papagu
        String papaguResponse = papagu.getResponse(userText);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, userImage),
                DialogBox.getPapaguDialog(papaguResponse, papaguImage)
        );
    }
}