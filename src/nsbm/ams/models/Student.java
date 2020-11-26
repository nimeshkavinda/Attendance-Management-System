/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams.models;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import nsbm.ams.DatabaseConnection;

/**
 *
 * @author Nimesh
 */
public class Student implements StudentServices {

    private String fname;
    private String lname;
    private String dob;
    private String gender;
    private String nic;
    private String studentid;
    private String email;
    private String mobile;
    private String address;
    private String city;
    private String province;
    private String faculty;
    private String batch;
    private String degree;
    private int degreeid;
    private String day;
    private String moduleid;
    private String moduleday;
    private String time;
    private String fullname;

    public Student() {

    }

    public Student(String fname, String lname, String dob, String gender, String nic, String studentid) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.gender = gender;
        this.nic = nic;
        this.studentid = studentid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setDegreeid(int degreeid) {
        this.degreeid = degreeid;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getNic() {
        return nic;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getBatch() {
        return batch;
    }

    public String getDegree() {
        return degree;
    }

    public int getDegreeid() {
        return degreeid;
    }

    public String getDay() {
        return day;
    }

    public String getModuleid() {
        return moduleid;
    }

    public String getModuleday() {
        return moduleday;
    }

    public String getTime() {
        return time;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    @Override
    public void registerStudent() {

        if (fname.isEmpty() || lname.isEmpty() || dob.isEmpty() || gender.isEmpty() || nic.isEmpty() || studentid.isEmpty() || email.isEmpty() || mobile.isEmpty() || address.isEmpty() || city.isEmpty() || province.isEmpty() || faculty.isEmpty() || batch.isEmpty() || degreeid == 0) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Data missing");
            alert.setHeaderText("Looks like you have missed something");
            alert.setContentText("Please fill in all the fields");

            alert.showAndWait();

        } else {

            Connection con = DatabaseConnection.ConnectDatabase();

            if (con != null) {

                try {

                    PreparedStatement ps;
                    ps = (PreparedStatement) con.prepareStatement("INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                    ps.setString(1, studentid);
                    ps.setString(2, fname);
                    ps.setString(3, lname);
                    ps.setString(4, dob);
                    ps.setString(5, gender);
                    ps.setString(6, nic);
                    ps.setString(7, email);
                    ps.setString(8, mobile);
                    ps.setString(9, address);
                    ps.setString(10, city);
                    ps.setString(11, province);
                    ps.setString(12, faculty);
                    ps.setString(13, batch);
                    ps.setInt(14, degreeid);

                    int res = ps.executeUpdate();

                    if (res > 0) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText("Student registration successful");
                        alert.setContentText("Student has been registered in the AMS");

                        alert.showAndWait();

                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Student registration fail");
                        alert.setContentText("Failed to register the student");

                        alert.showAndWait();
                    }

                } catch (SQLException ex) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Oops, that did not work");
                    alert.setContentText("Student registration failed");

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

            } else {

                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Connection error");
                alert.setHeaderText("Ah oh!");
                alert.setContentText("Looks like the database connection is not available");

                alert.showAndWait();

            }

        }

    }

    public void setContactInfo() {

        Connection con = DatabaseConnection.ConnectDatabase();
        String qry = "SELECT * FROM student WHERE stdid = '" + studentid + "'";

        if (con != null) {

            try {

                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement(qry);
                rs = ps.executeQuery();

                if (rs.next()) {

                    this.fname = rs.getString("fname");
                    this.lname = rs.getString("lname");
                    this.email = rs.getString("email");

                    this.fullname = fname + " " + lname;

                }

            } catch (SQLException ex) {
            }

        }

    }

    @Override
    public void generateTimeTable() {

        Connection con = DatabaseConnection.ConnectDatabase();

        String qry = "SELECT * FROM time_table INNER JOIN degree_module ON time_table.mid = degree_module.mid INNER JOIN student ON degree_module.did = student.did WHERE student.stdid = '" + studentid + "' AND time_table.day = '" + day + "'";

        if (con != null) {

            try {

                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement(qry);
                rs = ps.executeQuery();

                if (rs.next()) {

                    moduleid = rs.getString("mid");
                    moduleday = rs.getString("day");
                    time = rs.getString("time");
                }

            } catch (SQLException ex) {
            }

        }
    }

    public void sendEmail() {

        Email mail = new Email(moduleid, time);
        mail.sendEmail(email, fullname);

    }

}
