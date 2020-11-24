/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import org.apache.commons.io.FileUtils;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class ManageAccountController implements Initializable {

    @FXML
    private Pane paneManageAcc;
    @FXML
    private Hyperlink linkHome;
    @FXML
    private Hyperlink linkChangeDp;
    @FXML
    private Hyperlink linkDelAcc;
    @FXML
    private TextField txtFName;
    @FXML
    private TextField txtLName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPass;
    @FXML
    private TextField txtMobile;
    @FXML
    private Button btnSave;
    @FXML
    private PasswordField txtConPass;
    @FXML
    private Circle imgDp;

    String oldFName;
    String oldLName;
    String oldEmail;
    String oldMobile;
    PreparedStatement pstmt = null;
    Connection con = null;
    ResultSet rs = null;
    String email;
    String empid;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {

            con = DatabaseConnection.ConnectDatabase();

            String populateFields = "select * from employee where email = '" + email + "'";

            try {

                pstmt = con.prepareStatement(populateFields);
                rs = pstmt.executeQuery();

                if (rs.next()) {

                    oldFName = rs.getString("fname");
                    oldLName = rs.getString("lname");
                    oldEmail = rs.getString("email");
                    oldMobile = rs.getString("mobile");

                    txtFName.setText(oldFName);
                    txtLName.setText(oldLName);
                    txtEmail.setText(oldEmail);
                    txtMobile.setText(oldMobile);

                } else {

                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Fetching error");
                    alert.setContentText("Couldn't fetch the existing data");

                    alert.showAndWait();

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageAccountController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    public void setEmail(String empEmail) {
        email = empEmail;
    }

    public void setEmpId(String empId) {
        empid = empId;
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {
        Pane paneMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        paneManageAcc.getChildren().setAll(paneMenu);
    }

    @FXML
    private void saveChanges(ActionEvent event) throws SQLException {

        String newFName = txtFName.getText();
        String newLName = txtLName.getText();
        String newEmail = txtEmail.getText();
        String mobile = txtMobile.getText();
        String newPass = txtPass.getText();

        con = DatabaseConnection.ConnectDatabase();

        String qry = "update employee set fname = '" + newFName + "', lname = '" + newLName + "', email = '" + newEmail + "', mobile = '" + mobile + "', password = '" + newPass + "' where email = '" + email + "'";

        try {

            if (txtPass.getText() == null || txtPass.getText().isEmpty() || txtConPass.getText() == null || txtConPass.getText().isEmpty()) {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Invalid data");
                alert.setHeaderText("Something is missing");
                alert.setContentText("Make sure you have filled the passwords");

                alert.showAndWait();

            } else if (!txtPass.getText().equals(txtConPass.getText())) {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Invalid data");
                alert.setHeaderText("Invalid passwords");
                alert.setContentText("Make sure the passwords match");

                alert.showAndWait();

            } else {

                pstmt = con.prepareStatement(qry);
                int result = pstmt.executeUpdate();

                if (result > 0) {

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Account update");
                    alert.setHeaderText("Successful");
                    alert.setContentText("Your information has been changed");

                    alert.showAndWait();

                } else {

                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Couldn't update");
                    alert.setContentText("Failed to update your changes");

                    alert.showAndWait();

                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            String populateFields = "select * from employee where email = '" + email + "'";

            try {

                pstmt = con.prepareStatement(populateFields);
                rs = pstmt.executeQuery();

                if (rs.next()) {

                    oldFName = rs.getString("fname");
                    oldLName = rs.getString("lname");
                    oldEmail = rs.getString("email");
                    oldMobile = rs.getString("mobile");

                    txtFName.setText(oldFName);
                    txtLName.setText(oldLName);
                    txtEmail.setText(oldEmail);
                    txtMobile.setText(oldMobile);
                    txtPass.setText("");
                    txtConPass.setText("");

                } else {

                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Fetching error");
                    alert.setContentText("Couldn't fetch the existing data");

                    alert.showAndWait();

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            con.close();
        }

    }

    @FXML
    private void UpdateDp(ActionEvent event) throws MalformedURLException {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        File file = new File(empid);
        file = fileChooser.showOpenDialog(null);
        String path = file.getAbsolutePath();

        try {
            File destDir = new File(new JFileChooser().getFileSystemView().getDefaultDirectory().toString());
            File srcFile = new File(path);
            FileUtils.copyFileToDirectory(srcFile, destDir);
            InputStream inputStream = new FileInputStream(destDir);
            Image image = new Image(inputStream);
            imgDp.setFill(new ImagePattern(image));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void DeleteAcc(ActionEvent event) throws IOException, SQLException {

        con = DatabaseConnection.ConnectDatabase();

        String qry = "delete from employee where email = ? ";

        try {

            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, email);
            int result = pstmt.executeUpdate();

            if (result > 0) {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Account update");
                alert.setHeaderText("Your account has been deleted");
                alert.setContentText("You'll be taken back to login window");

                alert.showAndWait();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.show();
                stage.centerOnScreen();
                stage.setTitle("Attendance Management System");
                stage.setResizable(false);

            } else {

                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Looks like that didn't work");
                alert.setContentText("Failed to delete your account");

                alert.showAndWait();

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            con.close();
        }

    }

}
