/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Nimesh
 */
public class Scan extends javax.swing.JFrame {

    /**
     * Creates new form Scan
     */
    @FXML
    private Pane paneMain;

    String useremail;
    String studentid;
    String fname;
    String lname;
    String stdemail;
    String nic;
    String faculty;
    String batch;
    String degree;
    String datetime;
    int day;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public Scan(String email) {
        initComponents();
        useremail = email;
        lblUser.setText(useremail);
        lblStatus.setText("Please scan your ID");
        txtID.requestFocusInWindow();
    }

    private Scan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnSignout = new javax.swing.JButton();
        panelDashboard = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNic = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblDegree = new javax.swing.JLabel();
        lblBatch = new javax.swing.JLabel();
        lblFaculty = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblStdID = new javax.swing.JLabel();
        panelStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        panelScan = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("Scan"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        panelUser.setFocusable(false);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() & ~java.awt.Font.BOLD, jLabel1.getFont().getSize()+6));
        jLabel1.setText("You are signed in as");
        jLabel1.setFocusable(false);

        lblUser.setFont(lblUser.getFont().deriveFont(lblUser.getFont().getSize()+6f));
        lblUser.setFocusable(false);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSignout.setText("Sign out");
        btnSignout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSignout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addGap(39, 39, 39))
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnClose)
                    .addComponent(btnSignout))
                .addGap(38, 38, 38))
        );

        panelDashboard.setFocusable(false);

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD, jLabel3.getFont().getSize()+24));
        jLabel3.setText("Information Dashboard");

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getSize()+12f));
        jLabel4.setText("Full Name:");

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getSize()+12f));
        jLabel5.setText("Email:");

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getSize()+12f));
        jLabel6.setText("Batch:");

        jLabel7.setFont(jLabel7.getFont().deriveFont(jLabel7.getFont().getSize()+12f));
        jLabel7.setText("NIC:");

        jLabel8.setFont(jLabel8.getFont().deriveFont(jLabel8.getFont().getSize()+12f));
        jLabel8.setText("Faculty of Studies:");

        jLabel9.setFont(jLabel9.getFont().deriveFont(jLabel9.getFont().getSize()+12f));
        jLabel9.setText("Degree Program:");

        lblNic.setFont(lblNic.getFont().deriveFont(lblNic.getFont().getSize()+12f));

        lblName.setFont(lblName.getFont().deriveFont(lblName.getFont().getSize()+12f));

        lblEmail.setFont(lblEmail.getFont().deriveFont(lblEmail.getFont().getSize()+12f));

        lblDegree.setFont(lblDegree.getFont().deriveFont(lblDegree.getFont().getSize()+12f));

        lblBatch.setFont(lblBatch.getFont().deriveFont(lblBatch.getFont().getSize()+12f));

        lblFaculty.setFont(lblFaculty.getFont().deriveFont(lblFaculty.getFont().getSize()+12f));

        jLabel10.setFont(jLabel10.getFont().deriveFont(jLabel10.getFont().getSize()+12f));
        jLabel10.setText("Student ID:");

        lblStdID.setFont(lblStdID.getFont().deriveFont(lblStdID.getFont().getSize()+12f));

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStdID))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDegree))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblName))
                    .addComponent(jLabel3)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEmail))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNic))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFaculty))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBatch)))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStdID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDegree, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        lblStatus.setFont(lblStatus.getFont().deriveFont(lblStatus.getFont().getStyle() | java.awt.Font.BOLD, lblStatus.getFont().getSize()+24));

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(panelStatus);
        panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStatusLayout.createSequentialGroup()
                .addContainerGap(500, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(56, 56, 56))
        );
        panelStatusLayout.setVerticalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(lblStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtID.setFont(txtID.getFont().deriveFont(txtID.getFont().getSize()+57f));
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelScanLayout = new javax.swing.GroupLayout(panelScan);
        panelScan.setLayout(panelScanLayout);
        panelScanLayout.setHorizontalGroup(
            panelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID)
                .addContainerGap())
        );
        panelScanLayout.setVerticalGroup(
            panelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            studentid = txtID.getText();

            if (!studentid.matches("^[0-9]*$")) {

                lblStatus.setText("ID must contain integers between 0-9");
                txtID.setText("");
                lblName.setText("");
                lblStdID.setText("");
                lblEmail.setText("");
                lblNic.setText("");
                lblBatch.setText("");
                lblFaculty.setText("");
                lblDegree.setText("");

            } else {

                if (studentid.length() != 10) {

                    lblStatus.setText("ID must contain 10 characters");
                    txtID.setText("");
                    lblName.setText("");
                    lblStdID.setText("");
                    lblEmail.setText("");
                    lblNic.setText("");
                    lblBatch.setText("");
                    lblFaculty.setText("");
                    lblDegree.setText("");

                } else {

                    con = DatabaseConnection.ConnectDatabase();

                    String qry = "select fname, lname, email, nic, batch, faculty, degree from student where stdid = ?";

                    try {
                        ps = con.prepareStatement(qry);
                        ps.setString(1, studentid);
                        rs = ps.executeQuery();

                        if (rs.next()) {

                            fname = rs.getString("fname");
                            lname = rs.getString("lname");
                            stdemail = rs.getString("email");
                            nic = rs.getString("nic");
                            batch = rs.getString("batch");
                            faculty = rs.getString("faculty");
                            degree = rs.getString("degree");

                            lblStatus.setText("Student");
                            lblName.setText(fname + " " + lname);
                            lblStdID.setText(studentid);
                            lblEmail.setText(stdemail);
                            lblNic.setText(nic);
                            lblBatch.setText(batch);
                            lblFaculty.setText(faculty);
                            lblDegree.setText(degree);

                            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            Date date = new Date();
                            datetime = dateFormat.format(date);

                            Calendar c = Calendar.getInstance();
                            c.setTime(date);
                            day = c.get(Calendar.DAY_OF_WEEK);

                            MarkAttendance markatd = new MarkAttendance(studentid, datetime, day);

                        } else {

                            lblStatus.setText("Invalid");
                            txtID.setText("");
                            lblName.setText("");
                            lblStdID.setText("");
                            lblEmail.setText("");
                            lblNic.setText("");
                            lblBatch.setText("");
                            lblFaculty.setText("");
                            lblDegree.setText("");

                        }
                    } catch (SQLException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Oops, that did not work");
                        alert.setContentText("Fetching failed");

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
                    } finally {
                        txtID.setText("");
                    }
                }

            }

        }
    }//GEN-LAST:event_txtIDKeyPressed

    private void btnSignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignoutActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_btnSignoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Scan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSignout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBatch;
    private javax.swing.JLabel lblDegree;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFaculty;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNic;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStdID;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelScan;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JPanel panelUser;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
