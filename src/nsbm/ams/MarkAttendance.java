/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Nimesh
 */
public class MarkAttendance {

    String studentid;
    String date;
    String today;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public MarkAttendance(String stdid, String atddate, String day) {

        studentid = stdid;
        date = atddate;
        today = day;

        con = DatabaseConnection.ConnectDatabase();

        if (con != null) {

            try {

                PreparedStatement pstmt;
                pstmt = (PreparedStatement) con.prepareStatement("insert into attendance (stdid, date, day) values (?,?,?)");

                pstmt.setString(1, studentid);
                pstmt.setString(2, date);
                pstmt.setString(3, today);

                pstmt.executeUpdate();

            } catch (SQLException ex) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Oops, that did not work");
                alert.setContentText("Failed to mark attendance");

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
