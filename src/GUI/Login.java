package GUI;

import java.sql.*;
import javax.swing.*;

import Classes.User;
import Database.UserService;
import Helper.Cart;


import java.awt.Color;
import static java.awt.Color.black;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JFrame;


/**
 *
 *
 */
public class Login extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

        //center the Form
        this.setLocationRelativeTo(null);

        //create a black border for the close and minimize symbols
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_hideScreen_Log.setBorder(label_border);
        jLabel_Exit_Log.setBorder(label_border);

        Border field_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jTextField_Username_Log.setBorder(field_border);
        jPasswordField_Password_Log.setBorder(field_border);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Login_Log = new javax.swing.JLabel();
        jLabel_hideScreen_Log = new javax.swing.JLabel();
        jLabel_Exit_Log = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_Username_Log = new javax.swing.JLabel();
        jLabel_Password_Log = new javax.swing.JLabel();
        jTextField_Username_Log = new javax.swing.JTextField();
        jPasswordField_Password_Log = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel_LogToRegistration_Log = new javax.swing.JLabel();
        jButton_Login_Log = new javax.swing.JButton();
        jButton_Cancel_Log = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(137, 196, 244));

        jLabel_Login_Log.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_Login_Log.setText("Login");

        jLabel_hideScreen_Log.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_hideScreen_Log.setText("-");
        jLabel_hideScreen_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_hideScreen_Log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_hideScreen_LogMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_hideScreen_LogMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_hideScreen_LogMouseExited(evt);
            }
        });

        jLabel_Exit_Log.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_Exit_Log.setText("X");
        jLabel_Exit_Log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Exit_LogMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jLabel_Login_Log)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_hideScreen_Log)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_Exit_Log)
                                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_Login_Log)
                                        .addComponent(jLabel_hideScreen_Log)
                                        .addComponent(jLabel_Exit_Log))
                                .addGap(21, 21, 21))
        );

        jPanel2.setBackground(new java.awt.Color(231, 246, 255));

        jLabel_Username_Log.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Username_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Username_Log.setText("Email or Username:");

        jLabel_Password_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Password_Log.setText("Password:");

        jTextField_Username_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Username_Log.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField_Username_Log.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_Username_LogFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Username_LogFocusLost(evt);
            }
        });
        jTextField_Username_Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Username_LogActionPerformed(evt);
            }
        });

        jPasswordField_Password_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPasswordField_Password_Log.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField_Password_LogFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField_Password_LogFocusLost(evt);
            }
        });
        jPasswordField_Password_Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_Password_LogActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(137, 196, 244));

        jLabel_LogToRegistration_Log.setText("click here to create a new account");
        jLabel_LogToRegistration_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_LogToRegistration_Log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_LogToRegistration_LogMouseClicked(evt);
            }
        });

        jButton_Login_Log.setBackground(new java.awt.Color(51, 255, 0));
        jButton_Login_Log.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Login_Log.setText("Login");
        jButton_Login_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Login_Log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_Login_LogMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_Login_LogMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_Login_LogMouseExited(evt);
            }
        });
        jButton_Login_Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton_Login_LogActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton_Cancel_Log.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Cancel_Log.setText("cancel");
        jButton_Cancel_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cancel_Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cancel_LogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jButton_Cancel_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Login_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_LogToRegistration_Log)
                                .addGap(173, 173, 173))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_Login_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_Cancel_Log))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_LogToRegistration_Log)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_Username_Log)
                                        .addComponent(jLabel_Password_Log))
                                .addGap(177, 177, 177)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPasswordField_Password_Log, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                        .addComponent(jTextField_Username_Log))
                                .addContainerGap(36, Short.MAX_VALUE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_Username_Log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_Username_Log))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jPasswordField_Password_Log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_Password_Log))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_Username_LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Username_LogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Username_LogActionPerformed

    private void jPasswordField_Password_LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_Password_LogActionPerformed

    }//GEN-LAST:event_jPasswordField_Password_LogActionPerformed

    private void jButton_Cancel_LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cancel_LogActionPerformed
        System.exit(0); //close the Login window
    }//GEN-LAST:event_jButton_Cancel_LogActionPerformed

    private void jLabel_hideScreen_LogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_hideScreen_LogMouseClicked

        this.setState(JFrame.ICONIFIED);  // minimize the Login screen
    }//GEN-LAST:event_jLabel_hideScreen_LogMouseClicked

    private void jLabel_LogToRegistration_LogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_LogToRegistration_LogMouseClicked
        Registration rg = new Registration();   // change from the Login screen to the Registration window
        rg.setVisible(true);
        rg.pack();
        rg.setLocationRelativeTo(null);
        rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel_LogToRegistration_LogMouseClicked

    private void jTextField_Username_LogFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Username_LogFocusGained
        // clear the textfiled on focus  if the text is "username"

        if (jTextField_Username_Log.getText().trim().toLowerCase().equals("username")) {
            jTextField_Username_Log.setText("");
            jTextField_Username_Log.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextField_Username_LogFocusGained

    private void jTextField_Username_LogFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Username_LogFocusLost
        //if the textfield is equal or empty
        //we will set "username" text in the field
        //on focus lost event
        if (jTextField_Username_Log.getText().trim().equals("") ||
                jTextField_Username_Log.getText().trim().toLowerCase().equals("username")) {
            jTextField_Username_Log.setText("username");
            jTextField_Username_Log.setForeground(new Color(153, 153, 153));
        }

        //remove the border from user field
        jTextField_Username_Log.setBorder(null);
    }//GEN-LAST:event_jTextField_Username_LogFocusLost

    private void jLabel_hideScreen_LogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_hideScreen_LogMouseEntered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_hideScreen_Log.setBorder(label_border);
        jLabel_hideScreen_Log.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_hideScreen_LogMouseEntered

    private void jLabel_hideScreen_LogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_hideScreen_LogMouseExited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_hideScreen_Log.setBorder(label_border);
        jLabel_hideScreen_Log.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_hideScreen_LogMouseExited

    private void jPasswordField_Password_LogFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField_Password_LogFocusGained
        //clear the password field on focus if the text is password

        //get the password text
        String pass_log = String.valueOf(jPasswordField_Password_Log.getPassword());

        if (pass_log.trim().toLowerCase().equals("password")) {
            jPasswordField_Password_Log.setText("");
            jPasswordField_Password_Log.setForeground(black);
        }
    }//GEN-LAST:event_jPasswordField_Password_LogFocusGained

    private void jPasswordField_Password_LogFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField_Password_LogFocusLost
        String pass_log = String.valueOf(jPasswordField_Password_Log.getPassword());
        if (pass_log.trim().equals("") ||
                pass_log.trim().toLowerCase().equals("password")) {
            jPasswordField_Password_Log.setText("password");
            jTextField_Username_Log.setForeground(new Color(153, 153, 153));
        }

        //remove the border from user field
        jTextField_Username_Log.setBorder(null);

    }//GEN-LAST:event_jPasswordField_Password_LogFocusLost

    private void jButton_Login_LogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Login_LogMouseEntered
        //set button backround
        jButton_Login_Log.setBackground(Color.white);
    }//GEN-LAST:event_jButton_Login_LogMouseEntered

    private void jButton_Login_LogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Login_LogMouseExited
        jButton_Login_Log.setBackground(Color.green);
    }//GEN-LAST:event_jButton_Login_LogMouseExited

    private void jButton_Login_LogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Login_LogMouseClicked
        Registration rg = new Registration();
        rg.setVisible(true);
        rg.pack();
        rg.setLocationRelativeTo(null);
        rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_Login_LogMouseClicked

    private void jButton_Login_LogActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButton_Login_LogActionPerformed
        //check if Username and password are correct
        // Connection conn = DatenbankHandler.getConnection();
        String password = String.valueOf(jPasswordField_Password_Log.getPassword());
        MessageDigest messagedigest = null; //Hash-Funktion Encryption
        try {
            messagedigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {

        }
        messagedigest.update(password.getBytes());
        StringBuffer sb= new StringBuffer();
        byte[] b = messagedigest.digest();
        for(byte b1:b)
        {
            sb.append(Integer.toHexString(b1 & 0xff).toString());//yeah
        }

        System.out.println(sb);
        Cart.user = UserService.login(jTextField_Username_Log.getText(), sb.toString());
        if(Cart.user != null){
            dispose();
            new Mainpage();
        }


}//GEN-LAST:event_jButton_Login_LogActionPerformed

    private void jLabel_Exit_LogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Exit_LogMouseClicked
        System.exit(0); //close the Login window
    }//GEN-LAST:event_jLabel_Exit_LogMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancel_Log;
    private javax.swing.JButton jButton_Login_Log;
    private javax.swing.JLabel jLabel_Exit_Log;
    private javax.swing.JLabel jLabel_LogToRegistration_Log;
    private javax.swing.JLabel jLabel_Login_Log;
    private javax.swing.JLabel jLabel_Password_Log;
    private javax.swing.JLabel jLabel_Username_Log;
    private javax.swing.JLabel jLabel_hideScreen_Log;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_Password_Log;
    private javax.swing.JTextField jTextField_Username_Log;
    // End of variables declaration//GEN-END:variables
}
