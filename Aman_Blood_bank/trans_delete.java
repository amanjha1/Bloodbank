/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aman_Blood_bank;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Aman Kumar Jha
 */
public class trans_delete extends javax.swing.JFrame {

    /**
     * Creates new form trans_delete
     */
    
    Connection con=null;
    Statement stmt=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public trans_delete() {
        String url="url:oracle:thin:@localhost:1521:XE";
         
        try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("driver loaded\n");
                con=DriverManager.getConnection(url,"system","aman");
                System.out.println("Connection aman Established\n");
               
            }
        catch(ClassNotFoundException e)
        {
            System.out.println("driver not found\n");
        }
        catch(SQLException e)
        {
            System.out.println("Connection not establish");
        }
        if(con!=null)
        {
            initComponents();
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        delete_record = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        goback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("ENTER CONTACT NUMBER:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 200, 30));

        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        getContentPane().add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 220, 30));

        delete_record.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        delete_record.setText("DELETE RECORD");
        delete_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_recordMouseClicked(evt);
            }
        });
        getContentPane().add(delete_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.blue);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BLOOD BANK");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 260, 30));

        jLabel3.setText("_____________________________________________________________________________________");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 510, -1));

        goback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        goback.setText("<<");
        goback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gobackMouseClicked(evt);
            }
        });
        goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobackActionPerformed(evt);
            }
        });
        getContentPane().add(goback, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void delete_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_recordMouseClicked
        // TODO add your handling code here:

        try
        {
            String sr="delete from issuedblood where contact='"+contact.getText()+"'";
            stmt=con.createStatement();
           rs=stmt.executeQuery(sr);
           if(rs.next())
           {
               stmt.executeUpdate(sr);
                System.out.println("Record deleted sucessfully...!!!");
                JOptionPane.showMessageDialog(this,"Record Deleted...!!!","Deleted",JOptionPane.INFORMATION_MESSAGE);
                contact.setText("");
           }
           else
           {
               JOptionPane.showMessageDialog(this,"Record Not Found raman...!!!"," ",JOptionPane.ERROR_MESSAGE);
               
           }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }//GEN-LAST:event_delete_recordMouseClicked

    private void gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gobackActionPerformed

    private void gobackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gobackMouseClicked
        // TODO add your handling code here:
        deleterec_t obj=new deleterec_t();
        this.setVisible(false);
        obj.setVisible(true);
    }//GEN-LAST:event_gobackMouseClicked

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
            java.util.logging.Logger.getLogger(trans_delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trans_delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trans_delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trans_delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trans_delete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contact;
    private javax.swing.JToggleButton delete_record;
    private javax.swing.JButton goback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
