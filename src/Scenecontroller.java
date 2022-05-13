import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scenecontroller implements Initializable {

    @FXML
    private ImageView lockimage;

    // @FXML
    // private Button loginbutton;

    // public void loginbuttonOnAction(ActionEvent e) {
    // youtrytologn.setText("You try to login!");
    // }

    @FXML
    private Label passwordlabel;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private TextField usernametextfield;

    @FXML
    private Button loginbutton;

    @FXML
    void loginbuttonOnAction(ActionEvent event) {

        if (usernametextfield.getText().isBlank() == false && passwordtextfield.getText().isBlank() == false) {
            validator();

        } else {
            youtrytologn.setText("please enter username and password!");
        }

    }

    @FXML
    private Button signupbutton;

    // public void loginbuttonOnAction(ActionEvent e) {
    // Stage stage = (Stage) signupbutton.getScene().getWindow();
    // stage.close();
    // }

    public void validator() {
        Databaseconnection c = new Databaseconnection();
        Connection con = c.getConnection();

        String verify = ("select count(1) From Signup1 where userName ='" + usernametextfield.getText()
                + "' and password = '" + passwordtextfield.getText() + "'");

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(verify);
            while (rs.next())
                if (rs.getInt(1) == 1) {

                    Parent root = FXMLLoader.load(getClass().getResource("success.fxml"));
                    Stage stage = (Stage) loginbutton.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    youtrytologn.setText("Invalid attempt! please try again!!");
                }
        } catch (Exception e) {

        }
    }

    @FXML
    private Label usernamelabel;

    @FXML
    private Label youtrytologn;

    @FXML
    void onAct(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("info.fxml"));
            Scene scene = new Scene(root);
            Stage primarysStage = (Stage) signupbutton.getScene().getWindow();
            primarysStage.setScene(scene);
            primarysStage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
}