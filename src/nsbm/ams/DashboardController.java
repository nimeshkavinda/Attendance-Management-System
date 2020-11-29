/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import nsbm.ams.services.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author Nimesh
 */
public class DashboardController implements Initializable {

    @FXML
    private Pane paneNav;
    @FXML
    private Hyperlink linkSignout;
    @FXML
    private Hyperlink linkManageacc;
    private Pane paneMenu;
    @FXML
    private Pane paneUpdates;
    @FXML
    private Circle picProfile;
    @FXML
    private Label lblGreeting;
    @FXML
    private Label lblName;
    @FXML
    private Label lblNameAlt;
    @FXML
    private Pane panePlaceholder;
    @FXML
    private Label lblNameAlt1;

    Calendar cal;
    int timeOfDay;
    String empemail;
    String empid;
    String flname;
    String imagename;
    @FXML
    private Label lblLhId1;
    @FXML
    private Label lblModule1;
    @FXML
    private Label lblAtd1;
    @FXML
    private Label lblLhId2;
    @FXML
    private Label lblModule2;
    @FXML
    private Label lblAtd2;
    @FXML
    private Label lblLhId3;
    @FXML
    private Label lblModule3;
    @FXML
    private Label lblAtd3;
    @FXML
    private Label lblLhId4;
    @FXML
    private Label lblModule4;
    @FXML
    private Label lblAtd4;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    try {
                        showLecHalls();
                    } catch (SQLException ex) {
                        Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }, 2000, 2000);

        Platform.runLater(() -> {

            Pane paneLogin = null;
            try {
                paneMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            panePlaceholder.getChildren().setAll(paneMenu);

            cal = Calendar.getInstance();
            timeOfDay = cal.get(Calendar.HOUR_OF_DAY);

            if (timeOfDay >= 0 && timeOfDay < 12) {
                lblGreeting.setText("Good Morning");
            } else if (timeOfDay >= 12 && timeOfDay < 16) {
                lblGreeting.setText("Good Afternoon");
            } else if (timeOfDay >= 16 && timeOfDay < 24) {
                lblGreeting.setText("Good Evening");
            } else {
                lblGreeting.setText("Hello There");
            }

            if (timeOfDay >= 0 && timeOfDay < 12) {
                lblNameAlt1.setText(flname);
            } else if (timeOfDay >= 12 && timeOfDay < 16) {
                lblName.setText(flname);
            } else if (timeOfDay >= 16 && timeOfDay < 24) {
                lblNameAlt.setText(flname);
            } else {
                lblNameAlt.setText(flname);
            }

            String doc = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
            Path imgloc = Paths.get(doc + "/" + empid + ".png");

            if (Files.notExists(imgloc)) {
                Image dp = new Image("resources/img/dp.png");
                picProfile.setFill(new ImagePattern(dp));
            } else {
                InputStream inputStream = null;
                try {
                    inputStream = new FileInputStream(doc + "/" + empid + ".png");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image image = new Image(inputStream);
                picProfile.setFill(new ImagePattern(image));
            }

        });

    }

    public void setName(String name) {
        flname = name;
    }

    public void setEmail(String email) {
        empemail = email;
    }

    public void setEmpId(String id) {
        empid = id;
    }

    public void refreshDp(String imgname) throws FileNotFoundException {
        imagename = imgname;
        File destDir = new File(new JFileChooser().getFileSystemView().getDefaultDirectory().toString());
        InputStream inputStream = new FileInputStream(destDir + "/" + imagename + ".png");
        Image image = new Image(inputStream);
        picProfile.setFill(new ImagePattern(image));
    }

    @FXML
    private void toLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Attendance Management System");
        stage.setResizable(false);
    }

    @FXML
    private void toManageAcc(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageAccount.fxml"));
        Pane paneManageAcc = loader.load();
        paneMenu.getChildren().setAll(paneManageAcc);
        ManageAccountController accountctrl = loader.getController();
        accountctrl.setEmail(empemail);
        accountctrl.setEmpId(empid);

    }

    public void showLecHalls() throws SQLException {

        Connection con = DatabaseConnection.ConnectDatabase();

        String qry = "SELECT lecture_hall.lhid, lecture_hall.size, module.name, COUNT(module_date.mid) AS value_occurrence FROM module_date INNER JOIN module ON module_date.mid = module.mid INNER JOIN lecture_hall ON lecture_hall.mid = module_date.mid GROUP BY module_date.mid ORDER BY value_occurrence DESC LIMIT 4";

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            rs = st.executeQuery(qry);

            int i = 0;

            while (rs.next()) {
                i++;

                if (i == 1) {
                    lblLhId1.setText(rs.getString("lhid"));
                    lblModule1.setText(rs.getString("name"));
                    lblAtd1.setText(rs.getString("value_occurrence") + "/ " + rs.getString("size"));
                } else if (i == 2) {
                    lblLhId2.setText(rs.getString("lhid"));
                    lblModule2.setText(rs.getString("name"));
                    lblAtd2.setText(rs.getString("value_occurrence") + "/ " + rs.getString("size"));
                } else if (i == 3) {
                    lblLhId3.setText(rs.getString("lhid"));
                    lblModule3.setText(rs.getString("name"));
                    lblAtd3.setText(rs.getString("value_occurrence") + "/ " + rs.getString("size"));
                } else if (i == 4) {
                    lblLhId4.setText(rs.getString("lhid"));
                    lblModule4.setText(rs.getString("name"));
                    lblAtd4.setText(rs.getString("value_occurrence") + "/ " + rs.getString("size"));
                }

            }

        } catch (SQLException ex) {
        } finally {
            con.close();
        }

    }
}
