/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Nimesh
 */
public class Scan extends javax.swing.JFrame {

    /**
     * Creates new form Scan
     */
    
    String useremail;
    
    public Scan(String email) {
        initComponents();
        useremail = email;
        lblUser.setText(useremail);
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

        jPanelMain = new javax.swing.JPanel();
        jPanelUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jPanelDashboard = new javax.swing.JPanel();
        jPanelInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        jPanelScan = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("Scan"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jPanelUser.setFocusable(false);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() & ~java.awt.Font.BOLD, jLabel1.getFont().getSize()+6));
        jLabel1.setText("You are signed in as");
        jLabel1.setFocusable(false);

        lblUser.setFont(lblUser.getFont().deriveFont(lblUser.getFont().getSize()+6f));
        lblUser.setText("user@test.com");
        lblUser.setFocusable(false);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUserLayout = new javax.swing.GroupLayout(jPanelUser);
        jPanelUser.setLayout(jPanelUserLayout);
        jPanelUserLayout.setHorizontalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(39, 39, 39))
        );
        jPanelUserLayout.setVerticalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose))
                .addGap(38, 38, 38))
        );

        jPanelDashboard.setFocusable(false);

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD, jLabel3.getFont().getSize()+24));
        jLabel3.setText("Information Dashboard");

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getSize()+12f));
        jLabel4.setText("Full Name:");

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getSize()+12f));
        jLabel5.setText("Email:");

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getSize()+12f));
        jLabel6.setText("Faculty of studies:");

        jLabel7.setFont(jLabel7.getFont().deriveFont(jLabel7.getFont().getSize()+12f));
        jLabel7.setText("Mobile:");

        jLabel8.setFont(jLabel8.getFont().deriveFont(jLabel8.getFont().getSize()+12f));
        jLabel8.setText("Batch:");

        jLabel9.setFont(jLabel9.getFont().deriveFont(jLabel9.getFont().getSize()+12f));
        jLabel9.setText("Degree program:");

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );

        lblStatus.setFont(lblStatus.getFont().deriveFont(lblStatus.getFont().getStyle() | java.awt.Font.BOLD, lblStatus.getFont().getSize()+24));
        lblStatus.setText("Student");

        javax.swing.GroupLayout jPanelStatusLayout = new javax.swing.GroupLayout(jPanelStatus);
        jPanelStatus.setLayout(jPanelStatusLayout);
        jPanelStatusLayout.setHorizontalGroup(
            jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStatusLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(118, 118, 118))
        );
        jPanelStatusLayout.setVerticalGroup(
            jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStatusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(158, 158, 158))
        );

        javax.swing.GroupLayout jPanelDashboardLayout = new javax.swing.GroupLayout(jPanelDashboard);
        jPanelDashboard.setLayout(jPanelDashboardLayout);
        jPanelDashboardLayout.setHorizontalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDashboardLayout.setVerticalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtID.setFont(txtID.getFont().deriveFont(txtID.getFont().getSize()+60f));

        javax.swing.GroupLayout jPanelScanLayout = new javax.swing.GroupLayout(jPanelScan);
        jPanelScan.setLayout(jPanelScanLayout);
        jPanelScanLayout.setHorizontalGroup(
            jPanelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID)
                .addContainerGap())
        );
        jPanelScanLayout.setVerticalGroup(
            jPanelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jPanelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelDashboard;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelScan;
    private javax.swing.JPanel jPanelStatus;
    private javax.swing.JPanel jPanelUser;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
