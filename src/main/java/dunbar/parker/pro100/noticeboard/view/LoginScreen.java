package dunbar.parker.pro100.noticeboard.view;

import dunbar.parker.pro100.noticeboard.controller.Main;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginScreen extends Application {
	private Stage stage;
	private Scene loginScene, newUserScene;
	private BorderPane loginPane, newUserPane;
	private GridPane userLogin, newUserInfo;
	private Button newUser, back, create, login;
	private TextField firstName, lastName, city, state, username, usernameLogin;
	private PasswordField password, passwordLogin;
	private Label fNLabel, lNLabel, cityLabel, stateLabel, usernameLabel, passwordLabel, dobLabel, userLoginLabel, passLoginLabel;
	private DatePicker dob;
	
	
	private Main control;
	
	@Override
	public void start(Stage primaryStage) {
		control = new Main();
		stage = primaryStage;
		initializeElements();

		primaryStage.setScene(loginScene);
		primaryStage.setTitle("Noticeboard");
		primaryStage.show();
		
//		PasswordField
		newUser.setOnMouseClicked(e -> setNewUserScene());
		back.setOnMouseClicked(e -> setLoginScene());
		create.setOnMouseClicked(e -> createUser());
		login.setOnMouseClicked(e -> login());
		
	}
	
	public void initializeElements() {
		//ROOTS
		loginPane = new BorderPane();
		newUserPane = new BorderPane();
		//SCENES
		loginScene = new Scene(loginPane, 700, 400);
		newUserScene = new Scene(newUserPane, 700, 400);
		//NODES
		userLogin = new GridPane();
		newUserInfo = new GridPane();
		//BUTTONS
		newUser = new Button("New User");
		back = new Button("Go Back");
		create = new Button("Create User");
		login = new Button("Login");
		//TEXT FIELDS
		firstName = new TextField();
		lastName = new TextField();
		city = new TextField();
		state = new TextField();
		username = new TextField();
		usernameLogin = new TextField();
		password = new PasswordField();
		passwordLogin = new PasswordField();
		//LABELS
		fNLabel = new Label("First Name");
		lNLabel = new Label("Last Name");
		cityLabel = new Label("City");
		stateLabel = new Label("State");
		usernameLabel = new Label("Username");
		userLoginLabel = new Label("Username");
		passwordLabel = new Label("Password");
		passLoginLabel = new Label("Password");
		dobLabel = new Label("DOB");
		//DATE PICKER
		dob = new DatePicker();


		//CONFIGURATIONS
		userLogin.setVgap(10);
		userLogin.setHgap(10);
		userLogin.add(userLoginLabel, 0, 0);
		userLogin.add(usernameLogin, 1, 0);
		userLogin.add(passLoginLabel, 0, 1);
		userLogin.add(passwordLogin, 1, 1);
		userLogin.add(login, 0, 2);
		userLogin.setConstraints(login, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		userLogin.setAlignment(Pos.CENTER);
		loginPane.setCenter(userLogin);
		loginPane.setBottom(newUser);
		
		newUserInfo.setVgap(10);
		newUserInfo.setHgap(10);
		newUserInfo.add(fNLabel, 0, 0);
		newUserInfo.add(firstName, 1, 0);
		newUserInfo.add(lNLabel, 0, 1);
		newUserInfo.add(lastName, 1, 1);
		newUserInfo.add(cityLabel, 0, 2);
		newUserInfo.add(city, 1, 2);
		newUserInfo.add(stateLabel, 0, 3);
		newUserInfo.add(state, 1, 3);
		newUserInfo.add(usernameLabel, 0, 4);
		newUserInfo.add(username, 1, 4);
		newUserInfo.add(passwordLabel, 0, 5);
		newUserInfo.add(password, 1, 5);
		newUserInfo.add(dobLabel, 0, 6);
		newUserInfo.add(dob, 1, 6);
		newUserInfo.add(create, 0, 7);
		newUserInfo.setConstraints(create, 0, 7, 2, 1, HPos.CENTER, VPos.CENTER);
		newUserInfo.setAlignment(Pos.CENTER);
		newUserPane.setCenter(newUserInfo);
		newUserPane.setBottom(back);
	}
	
	public void setLoginScene() {
		stage.setScene(loginScene);
	}
	
	public void setNewUserScene() {
		stage.setScene(newUserScene);
	}
	
	public void createUser() {
		

		if(control.createUser(firstName.getText(), lastName.getText(), city.getText(), state.getText(),
				username.getText(), password.getText(), dob.getValue())) {
			Alert success = new Alert(AlertType.INFORMATION);
			success.setTitle("Creation Successful");
			success.setHeaderText(null);
			success.setContentText("New user created successfully.");
			success.showAndWait();
			clearLoginField();
			setLoginScene();
		}
		else {
			Alert missing = new Alert(AlertType.INFORMATION);
			missing.setTitle("Missing Information");
			missing.setHeaderText(null);
			missing.setContentText("Please fill out the rest of the form before creating a new user.");
			missing.showAndWait();
		}
	}
	
	public void clearLoginField() {
		firstName.clear();
		lastName.clear();
		city.clear();
		state.clear();
		username.clear();
		password.clear();
	}
	
	
	public void login() {
		
	}
}
