/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laksh
 */
public class Conferenece_Reservation extends javax.swing.JFrame {

 
    
    
    
public Conferenece_Reservation() {
        initComponents();
        Connect();
        autoID();
        Load_reservation_conference();
        RoomTypeL();
    }
    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel d;
    
public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagement","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
public void autoID()
    {
        try {
            Statement s =con.createStatement();
            ResultSet rs =s.executeQuery("select MAX(cid)from  conferencereservation");
            rs.next();
            rs.getString("MAX(cid)");
            if(rs.getString("MAX(cid)")==null)
            {
                jLabel13.setText("RE001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(cid)").substring(2,rs.getString("MAX(cid)").length()));
                id++;
                jLabel13.setText("RE"+String.format("%03d",id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
 
public void RoomTypeL()
      {
        try {
            pst=con.prepareStatement("select Distinct crtype from  conference");  
            ResultSet rs = pst.executeQuery();
            txtrtype.removeAllItems();
            
            while(rs.next())
            {
                txtrtype.addItem(rs.getString("crtype"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
 
 
public void Load_reservation_conference()
      {
        int c;
        try {
            pst =con.prepareStatement("select * from  conferencereservation");
            ResultSet rs =pst.executeQuery();
            
            ResultSetMetaData rsd =rs.getMetaData();
            c = rsd.getColumnCount();
            
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 =new Vector();
                for(int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("cid"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("mobile"));
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("time"));
                    v2.add(rs.getString("rtype"));
                    v2.add(rs.getString("amount"));
                    v2.add(rs.getString("capacity"));
                    v2.add(rs.getString("status"));
                }
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnam = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtdate = new com.toedter.calendar.JDateChooser();
        txttime = new javax.swing.JTextField();
        txtamount = new javax.swing.JTextField();
        txtrtype = new javax.swing.JComboBox<>();
        txtstatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtcapacity = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\picture\\meeting-room1.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Conference Room Reservation");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(460, 10, 500, 60);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Reservation Number");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(70, 100, 220, 24);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 640, 190, 24);

        txtname.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 255, 255));
        txtname.setText("institution Name And Adress");
        jPanel2.add(txtname);
        txtname.setBounds(70, 160, 240, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mobile");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(70, 210, 140, 24);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email Adress");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(70, 270, 230, 20);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reserved Date");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(70, 330, 250, 24);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Reserved Time");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(70, 400, 190, 22);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Capacity");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(70, 580, 150, 24);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(310, 100, 120, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Reservation Room Type");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(70, 460, 240, 24);

        txtnam.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtnam);
        txtnam.setBounds(310, 160, 170, 30);

        txtmobile.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtmobile);
        txtmobile.setBounds(310, 220, 170, 30);

        txtemail.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtemail);
        txtemail.setBounds(310, 280, 170, 30);
        jPanel2.add(txtdate);
        txtdate.setBounds(310, 340, 170, 30);

        txttime.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txttime);
        txttime.setBounds(310, 400, 170, 30);

        txtamount.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtamount);
        txtamount.setBounds(310, 520, 170, 30);

        txtrtype.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtrtype);
        txtrtype.setBounds(310, 460, 170, 30);

        txtstatus.setBackground(new java.awt.Color(204, 204, 204));
        txtstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reservied", "Not reserved" }));
        txtstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstatusActionPerformed(evt);
            }
        });
        jPanel2.add(txtstatus);
        txtstatus.setBounds(310, 640, 170, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cid", "Institute Name", "Mobile", "Email", "Reserved Date", "Reserved Time", "Reservation Room", "Amount", "capacity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(520, 130, 700, 500);

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(660, 690, 61, 25);

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(840, 690, 63, 25);

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(940, 690, 69, 25);

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(1040, 690, 59, 25);

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(750, 690, 53, 25);

        jButton6.setBackground(new java.awt.Color(255, 204, 204));
        jButton6.setText("Close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(1140, 690, 63, 25);

        txtcapacity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-25", "1-50", "1-100", "100-500", "More Than 500" }));
        txtcapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcapacityActionPerformed(evt);
            }
        });
        jPanel2.add(txtcapacity);
        txtcapacity.setBounds(310, 580, 170, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Amount");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(70, 520, 150, 24);

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\picture\\Conference room.jpg")); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(-270, -160, 1510, 910);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1228, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        AdminMainManu min =new AdminMainManu();
        min.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtamount.getText().isEmpty())
       {
            JOptionPane.showMessageDialog(this,"Found Empty Filed." );
       }
       else { 
        String cno =jLabel13.getText();
        String name =txtnam.getText();
        String mobile =txtmobile.getText();
        String email =txtemail.getText();
        
        SimpleDateFormat df1 =new SimpleDateFormat("yyyy-MM-dd");
        String Date=df1.format(txtdate.getDate());
        
        String time =txttime.getText().toString();
        String rtype =txtrtype.getSelectedItem().toString();
        String amount =txtamount.getText();
        String capacity =txtcapacity.getSelectedItem().toString();
        String status =txtstatus.getSelectedItem().toString(); 
        try {
            pst =con.prepareStatement("insert into conferencereservation (cid ,name,mobile,email,date,time,rtype,amount,capacity,status) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, cno);
            pst.setString(2, name);
            pst.setString(3, mobile);
            pst.setString(4, email);
            pst.setString(5, Date);
            pst.setString(6, time);
            pst.setString(7, rtype);
            pst.setString(8, amount);
            pst.setString(9, capacity);
            pst.setString(10, status);
           
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Reservation Conference Room Added");
           
            
            txtnam.setText("");
            txtmobile.setText("");
            txtemail.setText("");
            txttime.setText("");
            txtrtype.setSelectedIndex(-1);
            txtamount.setText("");
            txtcapacity.setSelectedIndex(-1);;
            txtstatus.setSelectedIndex(-1);;
            autoID();
            Load_reservation_conference();
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstatusActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
         // TODO add your handling code here: d = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
            
         jLabel13.setText(d.getValueAt(selectIndex,0).toString());
         txtnam.setText(d.getValueAt(selectIndex,1).toString());
         txtmobile.setText(d.getValueAt(selectIndex, 2).toString());
         txtemail.setText(d.getValueAt(selectIndex, 3).toString());
         
        try {
            Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse((String)d.getValueAt(selectIndex,4));
            txtdate.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         txttime.setText(d.getValueAt(selectIndex, 5).toString());
         txtrtype.setSelectedItem(d.getValueAt(selectIndex, 6).toString());
         txtamount.setText(d.getValueAt(selectIndex, 7).toString());
         txtcapacity.setSelectedItem(d.getValueAt(selectIndex, 8).toString()); 
         txtstatus.setSelectedItem(d.getValueAt(selectIndex, 9).toString());
         
         jButton1.setEnabled(false);//save button desable
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          int selectIndex = jTable1.getSelectedRow();
            
         jLabel13.setText(d.getValueAt(selectIndex,0).toString());
         txtnam.setText(d.getValueAt(selectIndex,1).toString());
         txtmobile.setText(d.getValueAt(selectIndex, 2).toString());
         txtemail.setText(d.getValueAt(selectIndex, 3).toString());
         
        try {
            Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse((String)d.getValueAt(selectIndex,4));
            txtdate.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         txttime.setText(d.getValueAt(selectIndex, 5).toString());
         txtrtype.setSelectedItem(d.getValueAt(selectIndex, 6).toString());
         txtamount.setText(d.getValueAt(selectIndex,7).toString());
         txtcapacity.setSelectedItem(d.getValueAt(selectIndex, 8).toString()); 
         txtstatus.setSelectedItem(d.getValueAt(selectIndex, 9).toString());
         
         jButton1.setEnabled(false);//save button desable
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
           if(txtnam.getText().toString().isEmpty()||txtmobile.getText().toString().isEmpty()|| txtemail.getText().toString().isEmpty() || txtstatus.getSelectedItem().toString().isEmpty() ||txtamount.getText().toString().isEmpty()||txtrtype.getSelectedItem().toString().isEmpty()){
              JOptionPane.showMessageDialog(this, "You Don't  Edit Any Item " );
        }
        else{
        String cno =jLabel13.getText();
        String name =txtnam.getText();
        String mobile =txtmobile.getText();
        String email =txtemail.getText();
        
        SimpleDateFormat df1 =new SimpleDateFormat("yyyy-MM-dd");
        String Date=df1.format(txtdate.getDate());
        
        String time =txttime.getText().toString();
        String rtype =txtrtype.getSelectedItem().toString();
        String amount =txtamount.getText();
        String capacity =txtcapacity.getSelectedItem().toString(); 
        String status =txtstatus.getSelectedItem().toString(); 
        try {
            pst =con.prepareStatement("update conferencereservation set name = ?,mobile = ?,email = ?,date = ?,time = ? ,rtype = ?, amount= ?,capacity=?,status = ? where cid =?" );
            pst.setString(1, name);
            pst.setString(2, mobile);
            pst.setString(3, email);
            pst.setString(4, Date);
            pst.setString(5, time);
            pst.setString(6, rtype);
            pst.setString(7, amount);
            pst.setString(8, capacity);
            pst.setString(9, status);
            pst.setString(10, cno);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"conference Room Edit");
           
            
            
            txtnam.setText("");
            txtmobile.setText("");
            txtemail.setText("");
            txttime.setText("");
            txtrtype.setSelectedIndex(-1);
            txtamount.setText("");
            txtcapacity.setSelectedIndex(-1);;
            txtstatus.setSelectedIndex(-1);
            autoID();
            Load_reservation_conference();
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
           String cno =jLabel13.getText();

        try {
            pst =con.prepareStatement("delete from conferencereservation where cid =?" );
           
            pst.setString(1, cno);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Delete Succes");
           
            
            txtnam.setText("");
            txtmobile.setText("");
            txtemail.setText("");
            txttime.setText("");
            txtrtype.setSelectedIndex(-1);
            txtamount.setText("");
            txtcapacity.setSelectedIndex(-1);
            txtstatus.setSelectedIndex(-1);;
            autoID();
            Load_reservation_conference();
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomAdd.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            txtnam.setText("");
            txtmobile.setText("");
            txtemail.setText("");
            txttime.setText("");
            txtrtype.setSelectedIndex(-1);
            txtamount.setText("");
            txtcapacity.setSelectedIndex(-1);
            txtstatus.setSelectedIndex(-1);;
            autoID();
            Load_reservation_conference();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int close =JOptionPane.showConfirmDialog(null,"Close The Application","Select",JOptionPane.YES_NO_OPTION);
        if(close==0)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtcapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcapacityActionPerformed

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
            java.util.logging.Logger.getLogger(Conferenece_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conferenece_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conferenece_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conferenece_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conferenece_Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtcapacity;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtnam;
    private javax.swing.JLabel txtname;
    private javax.swing.JComboBox<String> txtrtype;
    private javax.swing.JComboBox<String> txtstatus;
    private javax.swing.JTextField txttime;
    // End of variables declaration//GEN-END:variables
}
