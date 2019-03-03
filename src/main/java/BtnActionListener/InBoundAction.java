package BtnActionListener;

import FrameDesign.JFrameTemplate;
import Util.MgmtSysUtil;
import dbConn.SqlConnLocal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InBoundAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        JPanel centreContentPanel = new JPanel();
        //order_no
        Box hBoxOrder = Box.createHorizontalBox();
        JLabel orderNoLabel = new JLabel("Customer Order No. : ");
        final JTextField orderNoText = new JTextField("",10);
        hBoxOrder.add(orderNoLabel);
        hBoxOrder.add(orderNoText);

        //logistic_company
        Box hBoxLogisticComp = Box.createHorizontalBox();
        JLabel logisticCompLabel = new JLabel("Shipment Company : ");
        final JComboBox logsitcCompText = new JComboBox();
        logsitcCompText.addItem("--- please choose the company ---");
        logsitcCompText.addItem("DHL");
        logsitcCompText.addItem("Hermes");
        hBoxLogisticComp.add(logisticCompLabel);
        hBoxLogisticComp.add(logsitcCompText);

        //tracking_no
        Box hBoxTrackingNo = Box.createHorizontalBox();
        JLabel trackingNoLabel = new JLabel("Tracking No : ");
        final JTextField trakingNoText = new JTextField("",10);
        hBoxTrackingNo.add(trackingNoLabel);
        hBoxTrackingNo.add(trakingNoText);

        //shipment_date
        Box hBoxShipmentDate = Box.createHorizontalBox();
        JLabel shipmentDateLabel = new JLabel("Shipment Date : ");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();
        final JFormattedTextField shipmentDateText = new JFormattedTextField(dateFormat);
        shipmentDateText.setValue(currentDate);
        hBoxShipmentDate.add(shipmentDateLabel);
        hBoxShipmentDate.add(shipmentDateText);

        //shipment_item1
        Box hBoxShipmentItem = Box.createHorizontalBox();
        JLabel item01Label = new JLabel("item 1 : ");
        final JTextField item01Text = new JTextField("",5);
        JLabel item02Label = new JLabel("item 2 : ");
        final JTextField item02Text = new JTextField("",5);
        JLabel item03Label = new JLabel("item 3 : ");
        final JTextField item03Text = new JTextField("",5);
        hBoxShipmentItem.add(item01Label);
        hBoxShipmentItem.add(item01Text);
        hBoxShipmentItem.add(item02Label);
        hBoxShipmentItem.add(item02Text);
        hBoxShipmentItem.add(item03Label);
        hBoxShipmentItem.add(item03Text);

        //receipt_date
        Box hBoxReceiptDate = Box.createHorizontalBox();
        JLabel receiptDateLabel = new JLabel("Receipt Date : ");
        final JFormattedTextField receiptDateText = new JFormattedTextField(dateFormat);
        receiptDateText.setValue(currentDate);
        hBoxReceiptDate.add(receiptDateLabel);
        hBoxReceiptDate.add(receiptDateText);

        //receipt_item
        Box hBoxReceiptItem = Box.createHorizontalBox();
        JLabel receiptItem01Label = new JLabel("Receipt Item 1 : ");
        final JTextField receiptItem01Text = new JTextField("",5);
        JLabel receiptItem02Label = new JLabel("Receipt Item 2 : ");
        final JTextField receiptItem02Text = new JTextField("",5);
        JLabel receiptItem03Label = new JLabel("Receipt Item 3 : ");
        final JTextField receiptItem03Text = new JTextField("",5);
        hBoxReceiptItem.add(receiptItem01Label);
        hBoxReceiptItem.add(receiptItem01Text);
        hBoxReceiptItem.add(receiptItem02Label);
        hBoxReceiptItem.add(receiptItem02Text);
        hBoxReceiptItem.add(receiptItem03Label);
        hBoxReceiptItem.add(receiptItem03Text);

        //description
        Box hBoxDescript = Box.createHorizontalBox();
        JLabel descriptLabel = new JLabel("Description : ");
        final JTextField descriptText = new JTextField("");
        hBoxDescript.add(descriptLabel);
        hBoxDescript.add(descriptText);

        //submit
        Box hBoxSubmit = Box.createHorizontalBox();
        JButton submitJBtn = new JButton("Submit");
        submitJBtn.setFont(MgmtSysUtil.btnFont);
        hBoxSubmit.add(submitJBtn);

        submitJBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // read value from input
                String orderNo = orderNoText.getText();
                String logsitcComp = logsitcCompText.getSelectedItem().toString();
                String trakingNo = trakingNoText.getText();
                String shipmentDate = shipmentDateText.getValue().toString();
                int item01 = Integer.parseInt(item01Text.getText());
                int item02 =  Integer.parseInt(item02Text.getText());
                int item03 =  Integer.parseInt(item03Text.getText());
                String receiptDate = receiptDateText.getValue().toString();
                int receiptItem1 =  Integer.parseInt(receiptItem01Text.getText());
                int receiptItem2 =  Integer.parseInt(receiptItem02Text.getText());
                int receiptItem3 =  Integer.parseInt(receiptItem03Text.getText());
                String description = descriptText.getText();

                // database connection
                Connection conn = null;
                try {
                    //STEP 2: Register JDBC driver
                    Class.forName(SqlConnLocal.JDBC_DRIVER);
                    //STEP 3: Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(SqlConnLocal.DB_URL, SqlConnLocal.USER, SqlConnLocal.PASS);
                    //STEP 4: Execute a query
                    System.out.println("Creating statement...");
                    // get count
                    Statement prestmt = conn.createStatement();
                    int id = 0;
                    ResultSet rs = prestmt.executeQuery("SELECT COUNT(*) FROM inbound_table AS count");
                    while (rs.next()){
                       id = rs.getInt(1);
                    }

                    // the mysql insert statement
                    String query = " insert into inbound_table (id, order_no, logistic_company, tracking_no, shipment_date, shipment_item1, shipment_item2, shipment_item3, receipt_date, receipt_item1, receipt_item2, receipt_item3, description)"
                            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setInt (1, id);
                    preparedStmt.setString (2, orderNo);
                    preparedStmt.setString   (3, logsitcComp);
                    preparedStmt.setString   (4, trakingNo);
                    preparedStmt.setString (5, shipmentDate);
                    preparedStmt.setInt    (6, item01);
                    preparedStmt.setInt (7, item02);
                    preparedStmt.setInt (8, item03);
                    preparedStmt.setString   (9, receiptDate);
                    preparedStmt.setInt (10, receiptItem1);
                    preparedStmt.setInt    (11, receiptItem2);
                    preparedStmt.setInt    (12, receiptItem3);
                    preparedStmt.setString(13,description);

                    // execute the preparedstatement
                    preparedStmt.execute();



                    prestmt.close();
                    // close connect
                    conn.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch (ClassNotFoundException e1){
                    e1.printStackTrace();
                }finally{
                    //finally block used to close resources
                    try{
                        if(conn!=null)
                            conn.close();
                    }catch(SQLException se){
                        se.printStackTrace();
                    }//end finally try
                }//end try
            }
        });

        Box vBox = Box.createVerticalBox();
        Dimension padding = new Dimension(0,25);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxOrder);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxLogisticComp);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxTrackingNo);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxShipmentDate);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxShipmentItem);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxReceiptDate);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxReceiptItem);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxDescript);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxSubmit);

        centreContentPanel.add(vBox);

        JFrame inComingFrame = new JFrameTemplate("Inbound Interface",
                "Please enter all information needed as follow",
                centreContentPanel, MgmtSysUtil.frameFont);

        inComingFrame.setVisible(true);
    }
}
