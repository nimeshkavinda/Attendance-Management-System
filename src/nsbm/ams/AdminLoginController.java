/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class AdminLoginController implements Initializable {

    @FXML
    private AnchorPane paneAdminLogin;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Hyperlink linkBack;
    @FXML
    private Button btnLogin;
    @FXML
    private Hyperlink linkSignup;

    String fname;
    String lname;
    String flname;
    String email;
    String empid;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void toBack(ActionEvent event) throws IOException {
        Pane paneLogin = FXMLLoader.load(getClass().getResource("Login.fxml"));
        paneAdminLogin.getChildren().setAll(paneLogin);
    }

    @FXML
    private void loginAdmin(ActionEvent event) throws IOException {

        email = txtEmail.getText();
        String pass = txtPass.getText();

        if (event.getSource() == btnLogin) {

            if (email.isEmpty() || pass.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Missing");
                alert.setHeaderText("Looks like you have missed something");
                alert.setContentText("Please fill in all the fields");

                alert.showAndWait();

            } else if (!email.matches("([a-zA-Z0-9\\.]{1,20})\\@nsbm[\\.]lk")) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Invalid data");
                alert.setHeaderText(null);
                alert.setContentText("Please use NSBM provided email to login to dashboard");

                alert.showAndWait();

            } else {

                con = DatabaseConnection.ConnectDatabase();

                String qry = "select * from employee where email = ? and password = ? and access_lvl = '0' ";

                try {
                    ps = con.prepareStatement(qry);
                    ps.setString(1, email);
                    ps.setString(2, pass);
                    rs = ps.executeQuery();

                    if (rs.next()) {

                        empid = rs.getString("empid");
                        fname = rs.getString("fname");
                        lname = rs.getString("lname");
                        flname = fname + " " + lname;

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));

                        Parent root = loader.load();
                        Stage dashboard = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        DashboardController dashctrl = loader.getController();
                        dashctrl.setName(flname);
                        dashctrl.setEmail(email);
                        dashctrl.setEmpId(empid);
                        dashboard.setScene(new Scene(root, 1200, 700));
                        dashboard.show();
                        dashboard.centerOnScreen();
                        dashboard.setTitle("Attendance Management System");
                        dashboard.setResizable(false);

                    } else {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Invalid data");
                        alert.setHeaderText("There's no matching user");
                        alert.setContentText("Make sure you are using NSBM provided email and your email and password combination is correct");

                        alert.showAndWait();
                    }
                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Oops, that did not work");
                    alert.setContentText("Login failed");

                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    ex.printStackTrace(pw);
                    String exceptionText = sw.toString();

                    Label label = new Label("The exception stacktrace was:");

                    TextArea textArea = new TextArea(exceptionText);
                    textArea.setEditable(false);
                    textArea.setWrapText(true);

                    textArea.setMaxWidth(Double.MAX_VALUE);
                    textArea.setMaxHeight(Double.MAX_VALUE);
                    GridPane.setVgrow(textArea, Priority.ALWAYS);
                    GridPane.setHgrow(textArea, Priority.ALWAYS);

                    GridPane expContent = new GridPane();
                    expContent.setMaxWidth(Double.MAX_VALUE);
                    expContent.add(label, 0, 0);
                    expContent.add(textArea, 0, 1);

                    alert.getDialogPane().setExpandableContent(expContent);

                    alert.showAndWait();
                }
            }
        }

    }

    @FXML
    private void toSignup(ActionEvent event) throws IOException {
        Pane paneSignup = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        paneAdminLogin.getChildren().setAll(paneSignup);
    }

}
