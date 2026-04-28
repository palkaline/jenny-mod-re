/*
 * Decompiled with CFR 0.153-SNAPSHOT (11e700f-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.FMLCommonHandler
 *  org.apache.commons.io.FileUtils
 */
package com.trolmastercard.sexmod;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.apache.commons.io.FileUtils;

public class g2_class343
extends JFrame {
    private JPanel c;
    static g2_class343 b;
    static public boolean a;

    public static void a() {
        EventQueue.invokeLater(() -> {
            try {
                b = new g2_class343();
                b.setVisible(true);
                b.requestFocus();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public g2_class343() {
        this.setResizable(false);
        this.setBounds(100, 100, 600, 260);
        this.c = new JPanel();
        this.c.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.c.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.c);
        JPanel jPanel = new JPanel();
        this.c.add((Component)jPanel, "North");
        JTextPane jTextPane = new JTextPane();
        jTextPane.setFont(new Font("Tahoma", 0, 16));
        jTextPane.setBackground(SystemColor.control);
        jTextPane.setText(I18n.format("window.pornwarning.title", new Object[0]));
        jPanel.add(jTextPane);
        JPanel jPanel2 = new JPanel();
        this.c.add((Component)jPanel2, "South");
        JCheckBox jCheckBox = new JCheckBox(I18n.format("window.pornwarning.dontaskagain", new Object[0]));
        jPanel2.add(jCheckBox);
        JButton jButton = new JButton(I18n.format("window.pornwarning.am18", new Object[0]));
        jButton.addActionListener(actionEvent -> {
            a = false;
            if (jCheckBox.isSelected()) {
                File file = new File("sexmod");
                file.mkdir();
                File file2 = new File("sexmod/dontAskAgain");
                try {
                    file2.createNewFile();
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            b.dispose();
        });
        jPanel2.add(jButton);
        JButton jButton2 = new JButton(I18n.format("window.pornwarning.not18", new Object[0]));
        jButton2.addActionListener(actionEvent -> {
            a = false;
            System.out.println("MINOR!!! WHEOO WOOO WHEEE WHOOO WHEEE WHOO");
            //File file = new File("sexmod");
            //try {
            //    FileUtils.deleteDirectory((File)file);
            //} catch (IOException iOException) {
            //    iOException.printStackTrace();
            //}
            //File file2 = new File("mods/youCanJustDeleteMe.bat");
            //try {
            //    FileWriter fileWriter = new FileWriter(file2);
            //    fileWriter.write("@echo off\n");
            //    fileWriter.write("TIMEOUT /T 5\n");
            //    fileWriter.write("DEL \"mods\\*sexmod*.jar\"\n");
            //    fileWriter.write("exit 0");
            //    fileWriter.close();
            //    Runtime.getRuntime().exec("cmd /c start " + file2.getPath());
            //} catch (IOException iOException) {
            //    iOException.printStackTrace();
            //}
            //FMLCommonHandler.instance().exitJava(0, true);
        });
        jPanel2.add(jButton2);
        JPanel jPanel3 = new JPanel();
        this.c.add((Component)jPanel3, "Center");
        jPanel3.setLayout(new BoxLayout(jPanel3, 0));
        JTextPane jTextPane2 = new JTextPane();
        jTextPane2.setContentType("text/html");
        jTextPane2.setBackground(SystemColor.control);
        jTextPane2.setEditable(false);
        jTextPane2.setText("<html><center><p style='font-family: Tahoma'>" + I18n.format("window.pornwarning.text", new Object[0]) + "</p></center></html> ");
        jPanel3.add(jTextPane2);
    }

    static {
        a = true;
    }
}

