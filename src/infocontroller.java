import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class infocontroller implements Initializable {

    // private Stage stage;
    // private Scene scene;
    // private parent root;

    // public void switchToinfo(ActionEvent event){
    @FXML
    private Label displayidlabel;
    @FXML
    private Label email;

    @FXML
    private TextField emailfield;

    @FXML
    private Label lastname;

    @FXML
    private TextField lastnamefield;

    @FXML
    private Label name;

    @FXML
    private TextField namefield;

    @FXML
    private PasswordField passfield;

    @FXML
    private Label password;

    @FXML
    void signAction(ActionEvent event) {
        store();
        displayidlabel.setText("Account created successfully.");
    }

    @FXML
    private Button backbutton;

    @FXML
    void backAction(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
            Scene scene = new Scene(root);
            Stage primarysStage = (Stage) backbutton.getScene().getWindow();
            primarysStage.setScene(scene);
            primarysStage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO: handle exception
        }
    }

    public void store() {
        Databaseconnection c = new Databaseconnection();
        Connection con = c.getConnection();

        String sql = ("insert into Signup1(password,firstname,lastname,username) values(?,?,?,?)");
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, passfield.getText());
            st.setString(2, namefield.getText());
            st.setString(3, lastnamefield.getText());
            st.setString(4, emailfield.getText());

            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

}