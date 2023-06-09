
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.TableModel;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import java.util.Date;
//import common.OpenPdf;
import java.io.FileOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author bhawana
 */
public class SellMedicine extends javax.swing.JFrame {
    
    private String userName = "";
    private int finalTotalPrice = 0;
    private String billID = "";
    private String numberPattern = "^[0-9]*$";

    /**
     * Creates new form SellMedicine
     */
    public SellMedicine() {
        initComponents();
    }
    
    public SellMedicine(String tmpUsername) {
        initComponents();
        userName = tmpUsername;
        setLocationRelativeTo(null);
    }
    
    private void medicineName(String nameOrUniqueId) {
        DefaultTableModel model = (DefaultTableModel) medTable.getModel();
        model.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from medicine where name like '" + nameOrUniqueId + "%' or uniqueId like '" + nameOrUniqueId + "%'");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("uniqueId") + "-" + rs.getString("name")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void clearMedicineFiled() {
        txtMI.setText("");
        txtName.setText("");
        txtCN.setText("");
        txtPU.setText("");
        txtTP.setText("");
        txtNU.setText("");
    }
    
    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
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
        btnClose = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtMN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPU = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNU = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTP = new javax.swing.JTextField();
        btnATC = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        btnPP = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Sell Medicine");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 6, -1, -1));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 1366, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        txtMN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMNKeyReleased(evt);
            }
        });
        getContentPane().add(txtMN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 300, -1));

        medTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        medTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicines"
            }
        ));
        medTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 164, 300, 597));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Medicine ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 88, -1, -1));

        txtMI.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtMI, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 120, 250, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 164, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 202, 250, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Company Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 246, -1, -1));

        txtCN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 284, 250, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Price Of Unit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 88, -1, -1));

        txtPU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 120, 250, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("No Of Unit");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 164, -1, -1));

        txtNU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNUKeyReleased(evt);
            }
        });
        getContentPane().add(txtNU, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 202, 250, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Total Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 246, -1, -1));

        txtTP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 284, 250, -1));

        btnATC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnATC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnATC.setText("Add To Cart");
        btnATC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATCActionPerformed(evt);
            }
        });
        getContentPane().add(btnATC, new org.netbeans.lib.awtextra.AbsoluteConstraints(1028, 337, -1, -1));

        cartTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Name", "Company Name", "Price Per Unit", "No oF Unit", "Total Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 396, 600, 254));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("RS :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 697, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFinalTotalPrice.setText("00");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(794, 697, 68, -1));

        btnPP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        btnPP.setText("Purchase & Print");
        btnPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPPActionPerformed(evt);
            }
        });
        getContentPane().add(btnPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(997, 694, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sellMedicineBackground.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        medicineName("");
        txtMI.setEditable(false);
        txtName.setEditable(false);
        txtCN.setEditable(false);
        txtPU.setEditable(false);
//        txtTP.setEditable(false);
//        txtNU.setEditable(false);
    }//GEN-LAST:event_formComponentShown

    private void txtMNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMNKeyReleased
        // TODO add your handling code here:
        medicineName(txtMN.getText());
    }//GEN-LAST:event_txtMNKeyReleased

    private void medTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medTableMouseClicked
        // TODO add your handling code here:
        int index = medTable.getSelectedRow();
        TableModel model = medTable.getModel();
        String nameOrUniqueId = model.getValueAt(index, 0).toString();
        
        String uniqueId[] = nameOrUniqueId.split("-", 0);
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from medicine where uniqueId=" + uniqueId[0] + "");
            while (rs.next()) {
                txtMI.setText(uniqueId[0]);
                txtName.setText(rs.getString("name"));
                txtCN.setText(rs.getString("companyName"));
                txtPU.setText(rs.getString("price"));
                txtTP.setText("");
                txtNU.setText("");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_medTableMouseClicked

    private void txtNUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNUKeyReleased
        // TODO add your handling code here:
        String noOfUnit = txtNU.getText();
        if (!noOfUnit.equals("")) {
            String price = txtPU.getText();
            if (!noOfUnit.matches(numberPattern)) {
                JOptionPane.showMessageDialog(null, "No Of Unit Field is Invalid ");
            }
            
            int totalPrice = Integer.parseInt(noOfUnit) * Integer.parseInt(price);
            txtTP.setText(String.valueOf(totalPrice));
        } else
            txtTP.setText("");
    }//GEN-LAST:event_txtNUKeyReleased

    private void btnATCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATCActionPerformed
        // TODO add your handling code here:
        String uniqueId = txtMI.getText();
        String noUnits = txtNU.getText();
        if (!uniqueId.equals("") && !noUnits.equals("")) {
            String companyName = txtCN.getText();
            String name = txtName.getText();
            String totalPrice = txtTP.getText();
            String pricePerUnit = txtPU.getText();
            int checkStock = 0;
            int checkMedicineAlreadyExistInCart = 0;
            try {
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from medicine where uniqueId='" + uniqueId + "'");
                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noUnits)) {
                        checkStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Medicine is Out of Stock.only " + rs.getInt("quantity") + " is Left");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (checkStock == 1) {
                DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
                if (cartTable.getRowCount() != 0) {
                    for (int i = 0; i < cartTable.getRowCount(); i++) {
                        if (Integer.parseInt(uniqueId) == Integer.parseInt(dtm.getValueAt(i, 0).toString())) {
                            checkMedicineAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "Medicine Already Exist in cart");
                        }
                    }
                }
                if (checkMedicineAlreadyExistInCart == 0) {
                    dtm.addRow(new Object[]{uniqueId, name, companyName, pricePerUnit, noUnits, totalPrice});
                    finalTotalPrice = finalTotalPrice + Integer.parseInt(totalPrice);
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Added Succesfully !!");
                }
                clearMedicineFiled();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Of Units Required !!!");
        }
    }//GEN-LAST:event_btnATCActionPerformed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        // TODO add your handling code here:
        int index = cartTable.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do You Really Want to remove this Medicine", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = cartTable.getModel();
            String total = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(total);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) cartTable.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_cartTableMouseClicked

    private void btnPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPPActionPerformed
        // TODO add your handling code here:
        if (finalTotalPrice != 0) {
            billID = getUniqueId("BillId-");
            DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
            if (dtm.getRowCount() != 0) {
                for (int i = 0; i < cartTable.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getcon();
                        Statement st = con.createStatement();
                        st.executeUpdate("update  medicine set quantity=quantity-" + Integer.parseInt(dtm.getValueAt(i, 4).toString()) + " where uniqueId=" + dtm.getValueAt(i, 0).toString() + "");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
                
            }
            try {
                SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getcon();
                PreparedStatement ps = con.prepareStatement("insert into bill(billId,billDate,totalPaid,generatedBy)values(?,?,?,?)");
                ps.setString(1, billID);
                ps.setString(2, dFormat.format(cal.getTime()));
                ps.setInt(3, finalTotalPrice);
                ps.setString(4, userName);
                ps.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            //creating bill
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(PharmacyUtils.billPath + "" + billID + ".pdf"));
                doc.open();
                Paragraph pharmacyName = new Paragraph("                                                           SHUBHAM PHARMA\n");
                doc.add(pharmacyName);
                Paragraph startLine = new Paragraph("****************************************************************************************************************");
                doc.add(startLine);
                Paragraph details = new Paragraph("\t Bill Id: " + billID + "\nDate: " + new Date() + "\nTotalPaid:" + finalTotalPrice);
                doc.add(details);
                doc.add(startLine);
                PdfPTable tbl = new PdfPTable(6);
                tbl.addCell("Medicine Id");
                tbl.addCell("Name");
                tbl.addCell("Company Name");
                tbl.addCell("Price Per Unit");
                tbl.addCell("No Of Unit");
                tbl.addCell("Total Price");
                for (int i = 0; i < cartTable.getRowCount(); i++) {
                    String a = cartTable.getValueAt(i, 0).toString();
                    String b = cartTable.getValueAt(i, 1).toString();
                    String c = cartTable.getValueAt(i, 2).toString();
                    String d = cartTable.getValueAt(i, 3).toString();
                    String e = cartTable.getValueAt(i, 4).toString();
                    String f = cartTable.getValueAt(i, 5).toString();
                    tbl.addCell(a);
                    tbl.addCell(b);
                    tbl.addCell(c);
                    tbl.addCell(d);
                    tbl.addCell(e);
                    tbl.addCell(f);
                }
                doc.add(tbl);
                doc.add(startLine);
                Paragraph thanksMsg = new Paragraph("Thank You !! Please Visit Again !!");
                doc.add(thanksMsg);
                //open pdf
                OpenPdf.openById(String.valueOf(billID));
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new SellMedicine(userName).setVisible(true);
        } else
            JOptionPane.showMessageDialog(null, "Please Add Some Medicine to Cart.");
    }//GEN-LAST:event_btnPPActionPerformed

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
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnATC;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPP;
    private javax.swing.JTable cartTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable medTable;
    private javax.swing.JTextField txtCN;
    private javax.swing.JTextField txtMI;
    private javax.swing.JTextField txtMN;
    private javax.swing.JTextField txtNU;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPU;
    private javax.swing.JTextField txtTP;
    // End of variables declaration//GEN-END:variables
}
