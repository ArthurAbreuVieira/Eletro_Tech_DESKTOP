/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package eletrotech.gui;

import eletrotech.api.API;
import eletrotech.api.Employee;
import static eletrotech.gui.Home.showCard;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;

/**
 *
 * @author Arthur
 */
public class ScheduleDetails extends javax.swing.JPanel {
    private int id;
    private eletrotech.api.Schedule schedule;
    
    public ScheduleDetails(eletrotech.api.Schedule _schedule) throws IOException {
        schedule = _schedule;
        id = schedule.getId();
                
        
        initComponents();
        jPanel9.remove(employee);
        jPanel9.remove(jComboBox1);
        jPanel9.remove(jButton4);
        listPanel.remove(jPanel11);
        listPanel.remove(jPanel10);
        listPanel.remove(jPanel9);
        
        
        Employee[] technicians = API.getTechnicians();        
        
        String technicians_id[] = new String[technicians.length];;
        for(int i = 0; i < technicians.length; i++) {
            technicians_id[i] = technicians[i].getId() + " - " + technicians[i].getUsername();
        }
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<String>(technicians_id));
        
        String itemTitle = "#"+schedule.getId()+" - "+schedule.getService().getName();
        String[] dateArray = schedule.getDate().substring(0, 10).split("-");
        String date = dateArray[2]+"/"+dateArray[1]+"/"+dateArray[0];
        String itemDescription =  schedule.getService().getDescription();
        
        title.setText(itemTitle);
        description.setText(itemDescription);
        status.setText(schedule.getStatus());
        this.date.setText(date);
        time.setText(schedule.getTime());
        local.setText(schedule.getUser().getAddress());
        service.setText(schedule.getService().getName());
        value.setText(schedule.getService().getValue());
        clientField.setText(schedule.getUser().getUsername());
        
        if(status.getText().equals("Agendado")) {
//          listPanel.add(new ScheduleSetTechnician(technicians));
            jPanel10.remove(jButton4);
            if(schedule.getEmployee_id() > 0) {
                employee.setText(schedule.getEmployee().getUsername());
                jPanel9.add(employee);
                jPanel10.add(jButton4);
            }
            else jPanel9.add(jComboBox1);
            jPanel9.repaint();
            jPanel9.revalidate();
            
            listPanel.add(jPanel9);
            listPanel.add(jPanel10);
        } else if(status.getText().equals("Concluido")) {
//            listPanel.add(jPanel1);;
        }
        
        listPanel.add(jPanel11);
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
        listPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        clientField = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        local = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        service = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        value = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        employee = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        os = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(900, 472));

        listPanel.setBackground(java.awt.Color.white);
        listPanel.setMaximumSize(new java.awt.Dimension(925, 32767));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(40, 40, 40));
        title.setText("#{id} - {service_name}");
        jPanel2.add(title);

        listPanel.add(jPanel2);

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel12.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel12.setName(""); // NOI18N
        jPanel12.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 40, 40));
        jLabel3.setText("Cliente:");
        jPanel12.add(jLabel3);

        clientField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clientField.setForeground(new java.awt.Color(87, 87, 87));
        clientField.setText("{{ customer_name }}");
        jPanel12.add(clientField);

        listPanel.add(jPanel12);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel3.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 40, 40));
        jLabel2.setText("Data do agendamento:");
        jPanel3.add(jLabel2);

        date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        date.setForeground(new java.awt.Color(87, 87, 87));
        date.setText("12/31/2022");
        jPanel3.add(date);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(40, 40, 40));
        jLabel5.setText("Local:");
        jPanel3.add(jLabel5);

        local.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        local.setForeground(new java.awt.Color(87, 87, 87));
        local.setText("address");
        jPanel3.add(local);

        listPanel.add(jPanel3);

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel4.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(40, 40, 40));
        jLabel4.setText("Horario de atendimento:");
        jPanel4.add(jLabel4);

        time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        time.setForeground(new java.awt.Color(87, 87, 87));
        time.setText("Manhã - 8h as 13h");
        jPanel4.add(time);

        listPanel.add(jPanel4);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel5.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel5.setName(""); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(40, 40, 40));
        jLabel6.setText("Serviço:");
        jPanel5.add(jLabel6);

        service.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        service.setForeground(new java.awt.Color(87, 87, 87));
        service.setText("Instalação predial");
        jPanel5.add(service);

        listPanel.add(jPanel5);

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel6.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel6.setName(""); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(40, 40, 40));
        jLabel8.setText("Descrição do serviço:");
        jPanel6.add(jLabel8);

        description.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        description.setForeground(new java.awt.Color(87, 87, 87));
        description.setText("Lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet Lorem ipsum dolor sit ");
        jPanel6.add(description);

        listPanel.add(jPanel6);

        jPanel7.setBackground(java.awt.Color.white);
        jPanel7.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel7.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel7.setName(""); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(40, 40, 40));
        jLabel10.setText("Preço do serviço:");
        jPanel7.add(jLabel10);

        value.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        value.setForeground(new java.awt.Color(87, 87, 87));
        value.setText("R$ 502,12");
        jPanel7.add(value);

        listPanel.add(jPanel7);

        jPanel8.setBackground(java.awt.Color.white);
        jPanel8.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel8.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel8.setName(""); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(40, 40, 40));
        jLabel12.setText("Status:");
        jPanel8.add(jLabel12);

        status.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        status.setForeground(new java.awt.Color(87, 87, 87));
        status.setText("Aguardando pagamento");
        jPanel8.add(status);

        listPanel.add(jPanel8);

        jPanel9.setBackground(java.awt.Color.white);
        jPanel9.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel9.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel9.setName(""); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(40, 40, 40));
        jLabel14.setText("Técnico responsável:");
        jPanel9.add(jLabel14);

        jComboBox1.setBackground(new java.awt.Color(234, 234, 234));
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setFocusable(false);
        jComboBox1.setMinimumSize(new java.awt.Dimension(200, 22));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 22));
        jComboBox1.setRequestFocusEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox1);

        employee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employee.setForeground(new java.awt.Color(87, 87, 87));
        employee.setText("{employee_Name}");
        jPanel9.add(employee);

        listPanel.add(jPanel9);

        jPanel10.setBackground(java.awt.Color.white);
        jPanel10.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel10.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jButton2.setBackground(new java.awt.Color(255, 98, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("EMITIR OS");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 98, 0), 2, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton2.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2);

        jButton4.setBackground(new java.awt.Color(0, 153, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setText("CONCLUIR SERVIÇO");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 98, 0), 2, true));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton4.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton4.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton4);

        listPanel.add(jPanel10);

        jPanel11.setBackground(java.awt.Color.white);
        jPanel11.setMaximumSize(new java.awt.Dimension(1000, 45));
        jPanel11.setMinimumSize(new java.awt.Dimension(1000, 45));
        jPanel11.setName(""); // NOI18N
        jPanel11.setPreferredSize(new java.awt.Dimension(1000, 45));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jButton3.setBackground(new java.awt.Color(255, 98, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(java.awt.Color.white);
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 98, 0), 2, true));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setLabel("VOLTAR");
        jButton3.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton3.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton3);

        os.setBackground(new java.awt.Color(0, 102, 51));
        os.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        os.setForeground(new java.awt.Color(0, 102, 0));
        jPanel11.add(os);

        listPanel.add(jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int employeeId = java.lang.Integer.parseInt(jComboBox1.getSelectedItem().toString().split(" - ")[0]);
        String employeeName = jComboBox1.getSelectedItem().toString().split(" - ")[1];
        try {
            API.setTechniciansToSchedule(id, employeeId);
            
            Employee[] technicians = API.getTechnicians();
            for(int i = 0; i < technicians.length; i++) {
                if(employeeId == technicians[i].getId()) {
                    schedule.setEmployee(technicians[i]);
                    break;
                }
            }
                        
            jPanel9.remove(jComboBox1);
            employee.setText(employeeName);
            jPanel9.add(employee);
            jPanel9.repaint();
            jPanel9.revalidate();
            
            API.generateOS(schedule);
            os.setText("Documento salvo em C:\\Users\\Public\\Documents\\");
        } catch (IOException ex) {
            Logger.getLogger(ScheduleDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        System.out.println(jComboBox1.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            showCard("Schedules", new Schedules());
        } catch (IOException ex) {
            Logger.getLogger(ScheduleDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if(API.finishService(schedule.getId())) {
                try {
                    showCard("Schedules", new Schedules());
                } catch (IOException ex) {
                    Logger.getLogger(ScheduleDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ScheduleDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clientField;
    private javax.swing.JLabel date;
    private javax.swing.JLabel description;
    private javax.swing.JLabel employee;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel listPanel;
    private javax.swing.JLabel local;
    private javax.swing.JLabel os;
    private javax.swing.JLabel service;
    private javax.swing.JLabel status;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    private javax.swing.JLabel value;
    // End of variables declaration//GEN-END:variables
}
