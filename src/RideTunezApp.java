import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RideTunezApp extends Application {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;
    private static final String APP_TITLE = "RideTunez";
    private static final String PROFILE_DATA_FILE = "userData.txt";
    private static final String[] DRIVER_NAMES = {"John Doe", "Jane Smith", "David Johnson", "Emily Davis"};
    private static final String[] PLATE_NUMBERS = {"ABC123", "XYZ789", "DEF456", "GHI987"};
    private static final String[] CAR_COLORS = {"Red", "Blue", "Black", "White"};

    private Label confirmationLabel;

    @Override
    public void start(Stage primaryStage) {
        Image backgroundImage = new Image("image_bg.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        Image appIcon = new Image("car_icon.png");
        primaryStage.getIcons().add(appIcon);
        Label Title = new Label("RideTunez");
        TextField usernameField = new TextField();
        TextField phoneNumberField = new TextField();
        Label usernameLabel = new Label("Username:");
        Label phoneNumberLabel = new Label("Phone Number:");
        TextField emergencyContactField = new TextField();
        Label emergencyContactLabel = new Label("Emergency Contact:");
        Button submitButton = new Button("Submit");
        // CSS
        usernameField.setStyle("-fx-pref-width: 300px;-fx-max-width: 300px;-fx-font-size: 15;");
        phoneNumberField.setStyle("-fx-pref-width: 300px;-fx-max-width: 300px; -fx-font-size: 15;");
        emergencyContactField.setStyle("-fx-pref-width: 300px;-fx-max-width: 300px; -fx-font-size: 15;");
        usernameLabel.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white;");
        phoneNumberLabel.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white;");
        emergencyContactLabel.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white;");
        Title.setStyle("-fx-font-size: 50;-fx-font-weight: bold;-fx-text-fill: white;");

        confirmationLabel = new Label("Your profile has been created!");
        confirmationLabel.setStyle("-fx-text-fill: white;-fx-font-size: 30; -fx-font-weight: bold;");
        confirmationLabel.setVisible(true);

        submitButton.setOnAction(event -> {
            String username = usernameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String emergencyContact = emergencyContactField.getText();
            if (username.isEmpty() || phoneNumber.isEmpty() || emergencyContact.isEmpty()) {
                showErrorDialog("Please fill in all the fields.");
            } else {
                writeDataToFile(username, phoneNumber, emergencyContact);
                showConfirmationScreen(primaryStage, username, phoneNumber, emergencyContact);
            }
        });

        VBox menuLayout = new VBox();
        menuLayout.getChildren().addAll(Title, usernameLabel, usernameField, phoneNumberLabel, phoneNumberField,
                emergencyContactLabel, emergencyContactField, submitButton);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setSpacing(10);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, menuLayout,confirmationLabel);
        BorderPane root1 = new BorderPane();
        root1.setBottom(confirmationLabel);
        BorderPane.setAlignment(confirmationLabel, Pos.BOTTOM_CENTER);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void writeDataToFile(String username, String phoneNumber, String emergencyContact) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROFILE_DATA_FILE))) {
            writer.write("Username: " + username);
            writer.newLine();
            writer.write("Phone Number: " + phoneNumber);
            writer.newLine();
            writer.write("Emergency Contact: " + emergencyContact);
        } catch (IOException e) {
            System.err.println("Failed to write data to file: " + e.getMessage());
        }
    }

    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    private void showConfirmationScreen(Stage primaryStage, String username, String phoneNumber,
                                        String emergencyContact) {
        confirmationLabel.setVisible(true);

        Timeline confirmationTimeline = new Timeline(new KeyFrame(Duration.seconds(0.0001), event -> {
            confirmationLabel.setVisible(false);
            StackPane confirmationScreen = new StackPane();
            Image backgroundImage = new Image("image_bg.png");
            ImageView backgroundImageView = new ImageView(backgroundImage);
            Label rideLabel = new Label("Enjoy Your Ride ");
            TextField currentLocationField = new TextField();
            TextField destinationField = new TextField();
            Label currentLocationLabel = new Label("Current Location:");
            Label destinationLabel = new Label("Destination:");
            Button submitLocationButton = new Button("Submit");

            currentLocationField.setStyle("-fx-pref-width: 300px;-fx-max-width: 300px; -fx-font-size: 15;");
            destinationField.setStyle("-fx-pref-width: 300px;-fx-max-width: 300px; -fx-font-size: 15;");
            currentLocationLabel.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white;");
            destinationLabel.setStyle("-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: white;");
            rideLabel.setStyle("-fx-text-fill: white;-fx-font-size: 25; -fx-font-weight: bold;");

            submitLocationButton.setOnAction(e -> {
                String currentLocation = currentLocationField.getText();
                String destination = destinationField.getText();
                if (currentLocation.isEmpty() || destination.isEmpty()) {
                    showErrorDialog("Please fill in all the fields.");
                } else if (currentLocation.equalsIgnoreCase(destination)) {
                    showErrorDialog("Current location and destination cannot be the same.");
                } else {
                    int fare = generateRandomFare(1000, 2000);
                    showFareOptions(primaryStage, currentLocation, destination, fare);
                }
            });

            VBox locationLayout = new VBox();
            locationLayout.getChildren().addAll(currentLocationLabel, currentLocationField, destinationLabel,
                    destinationField, submitLocationButton);
            locationLayout.setAlignment(Pos.CENTER);
            locationLayout.setSpacing(10);

            confirmationScreen.getChildren().addAll(backgroundImageView, rideLabel, locationLayout);
            StackPane.setAlignment(rideLabel, Pos.BOTTOM_CENTER);

            Scene confirmationScene = new Scene(confirmationScreen, WIDTH, HEIGHT);

            primaryStage.setScene(confirmationScene);
        }));

        confirmationTimeline.setDelay(Duration.seconds(1));
        confirmationTimeline.play();
    }

    private int generateRandomFare(int minFare, int maxFare) {
        Random random = new Random();
        return random.nextInt(maxFare - minFare + 1) + minFare;
    }

    private void showFareOptions(Stage primaryStage, String currentLocation, String destination, int fare) {
        StackPane fareOptionsScreen = new StackPane();
        Image backgroundImage = new Image("image_bg.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        Label fareLabel = new Label("Fare Options");
        Label fareAmountLabel = new Label("Current Fare: Rs. " + fare);
        Button lowerFareButton = new Button("Lower Fare");
        Button continueButton = new Button("Continue");

        fareLabel.setStyle("-fx-text-fill: white;-fx-font-size: 25; -fx-font-weight: bold;");
        fareAmountLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
        lowerFareButton.setStyle("-fx-pref-width: 150px; -fx-font-size: 15;");
        continueButton.setStyle("-fx-pref-width: 150px; -fx-font-size: 15;");

        lowerFareButton.setOnAction(e -> showDiscountedFareOptions(primaryStage, currentLocation, destination, fare));
        continueButton.setOnAction(e -> assignDriverAndShowSummary(primaryStage, currentLocation, destination, fare));

        VBox fareOptionsLayout = new VBox();
        fareOptionsLayout.getChildren().addAll(fareLabel, fareAmountLabel, lowerFareButton, continueButton);
        fareOptionsLayout.setAlignment(Pos.CENTER);
        fareOptionsLayout.setSpacing(10);

        fareOptionsScreen.getChildren().addAll(backgroundImageView, fareOptionsLayout);
        Scene fareOptionsScene = new Scene(fareOptionsScreen, WIDTH, HEIGHT);

        primaryStage.setScene(fareOptionsScene);
    }

    private void showDiscountedFareOptions(Stage primaryStage, String currentLocation, String destination, int fare) {
        StackPane discountedFareScreen = new StackPane();
        Image backgroundImage = new Image("image_bg.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        Label discountLabel = new Label("Select Discounted Fare");
        VBox discountedFareLayout = new VBox();

        discountLabel.setStyle("-fx-text-fill: white;-fx-font-size: 25; -fx-font-weight: bold;");
        discountedFareLayout.getChildren().add(discountLabel);

        int[] discountedFares = {fare-40, fare - 90, fare - 80, fare - 60};
        for (int i = 0; i < 4; i++) {
            Button discountedFareButton = new Button("Rs. " + discountedFares[i]);
            discountedFareButton.setStyle("-fx-pref-width: 150px; -fx-font-size: 15;");
            int fareIndex = i;
            discountedFareButton.setOnAction(e -> assignDriverAndShowSummary(primaryStage, currentLocation,
                    destination, discountedFares[fareIndex]));
            discountedFareLayout.getChildren().add(discountedFareButton);
        }

        discountedFareLayout.setAlignment(Pos.CENTER);
        discountedFareLayout.setSpacing(10);

        discountedFareScreen.getChildren().addAll(backgroundImageView, discountedFareLayout);
        Scene discountedFareScene = new Scene(discountedFareScreen, WIDTH, HEIGHT);

        primaryStage.setScene(discountedFareScene);
    }


    private void assignDriverAndShowSummary(Stage primaryStage, String currentLocation, String destination, int fare) {
        StackPane summaryScreen = new StackPane();
        Image backgroundImage = new Image("image_bg.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        Label summaryLabel = new Label("Ride Summary");
        Label driverLabel = new Label("Driver: " + getRandomElement(DRIVER_NAMES));
        Label plateNumberLabel = new Label("Plate No: " + getRandomElement(PLATE_NUMBERS));
        Label carColorLabel = new Label("Car Color: " + getRandomElement(CAR_COLORS));
        Label fareLabel = new Label("Fare: Rs. " + fare);
        Button exitButton = new Button("Exit");

        summaryLabel.setStyle("-fx-text-fill: white;-fx-font-size: 25; -fx-font-weight: bold;");
        driverLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
        plateNumberLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
        carColorLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
        fareLabel.setStyle("-fx-text-fill: white;-fx-font-size: 20;");
        exitButton.setStyle("-fx-pref-width: 150px; -fx-font-size: 15;");

        exitButton.setOnAction(e -> primaryStage.close());

        VBox summaryLayout = new VBox();
        summaryLayout.getChildren().addAll(summaryLabel, driverLabel, plateNumberLabel, carColorLabel, fareLabel,
                exitButton);
        summaryLayout.setAlignment(Pos.CENTER);
        summaryLayout.setSpacing(10);

        summaryScreen.getChildren().addAll(backgroundImageView, summaryLayout);
        Scene summaryScene = new Scene(summaryScreen, WIDTH, HEIGHT);

        primaryStage.setScene(summaryScene);
    }

    private String getRandomElement(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    public static void main(String[] args) {
        launch(args);
    }
}
