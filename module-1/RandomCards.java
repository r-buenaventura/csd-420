// Roxanne Buenaventura
// CSD420
// Module 1.3 Programming Assignment: Write a JavaFX Program that displays four images randomly selecte4d from a deck of 52 cards.
// 25 October, 2026

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class RandomCards extends Application {

    private final HBox cardContainer = new HBox(15);

    @Override
    public void start(Stage primaryStage) {

        // Arrange the four cards horizontally.
        cardContainer.setAlignment(Pos.CENTER);

        // Create a button to display new cards.
        Button refreshButton = new Button("Refresh Cards");

        // Lambda expression handles the button click.
        refreshButton.setOnAction(event -> displayCards());

        // Arrange the cards and button vertically.
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(cardContainer, refreshButton);

        // Display four random cards when the app opens.
        displayCards();

        Scene scene = new Scene(root, 600, 300);

        primaryStage.setTitle("Random Playing Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Randomly selects four unique cards from the deck.
    private void displayCards() {

        // Clear previously displayed cards.
        cardContainer.getChildren().clear();

        // Create a deck containing card numbers 1 through 52.
        ArrayList<Integer> deck = new ArrayList<>();

        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        // Shuffle the deck into a random order.
        Collections.shuffle(deck);

        // Display the first four cards from the shuffled deck.
        for (int i = 0; i < 4; i++) {

            int cardNumber = deck.get(i);

            File cardFile = new File("cards/" + cardNumber + ".png");
            Image cardImage = new Image(cardFile.toURI().toString());

            ImageView cardView = new ImageView(cardImage);
            cardView.setFitWidth(120);
            cardView.setPreserveRatio(true);

            cardContainer.getChildren().add(cardView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
