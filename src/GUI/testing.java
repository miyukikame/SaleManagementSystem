/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Product;
import Classes.Products;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import static javax.swing.GroupLayout.Alignment.*;

/**
 *
 * @author nikoa
 */
public class testing extends javax.swing.JFrame {
    public testing() throws SQLException {
        Products clothes;
        ArrayList<JLabel> itemName = new ArrayList<>();
        ArrayList<JLabel> itemPrice = new ArrayList<>();
        ArrayList<JComboBox> itemQuantity = new ArrayList<>();
        JLabel sectionName = new JLabel("Food");
        sectionName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sectionName.setText("Technology");
        JButton button = new JButton("Test Button");

        clothes = new Products(1);
        for (int i = 0; i < clothes.getProducts().size(); i ++) {
            itemName.add(new JLabel());
            itemName.get(i).setFont(new java.awt.Font("Tahoma", 1, 14));
            itemName.get(i).setText(clothes.getProducts().get(i).getName());
            itemPrice.add(new JLabel());
            itemPrice.get(i).setFont(new java.awt.Font("Tahoma", 1, 14));
            itemPrice.get(i).setText(clothes.getProducts().get(i).getPriceFormatted());
            itemQuantity.add(new JComboBox());
            itemQuantity.get(i).setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        }

        JPanel frame = new JPanel();
        getContentPane().setBackground(Color.ORANGE);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupLayout.ParallelGroup itemCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemName) {
            itemCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup priceCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemPrice) {
            priceCollection.addComponent(test);

        }
        GroupLayout.SequentialGroup verticalGroup = groupLayout.createSequentialGroup();
        verticalGroup.addComponent(sectionName);
        for (int i = 0; i < itemPrice.size(); i++) {
            verticalGroup.addGroup(groupLayout.createParallelGroup()
                    .addComponent(itemName.get(i))
                    .addComponent(itemPrice.get(i)));
        }

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(itemCollection)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(sectionName))
                        .addGroup(priceCollection)
        );
        groupLayout.setVerticalGroup(
                verticalGroup);
        /*groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup()
                            .addComponent(itemName.get(0))
                            .addComponent(itemName.get(1)))
                        .addGroup(groupLayout.createParallelGroup()
                            .addComponent(itemPrice.get(0))
                            .addComponent(itemPrice.get(1)))
                        .addComponent(button)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(itemName.get(0))
                                .addComponent(itemPrice.get(0))
                                .addComponent(button))
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(itemName.get(1))
                                .addComponent(itemPrice.get(1))
                                .addComponent(button))
        );*/
        pack();
    }


    /**
     * Creates new form Clothes
     */
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Clothes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                try {
                    new testing().setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

}

