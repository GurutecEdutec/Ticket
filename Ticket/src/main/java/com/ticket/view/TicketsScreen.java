package com.ticket.view;

import com.ticket.model.Ticket;
import com.ticket.utils.EntityUtils;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TicketsScreen extends javax.swing.JFrame {
    private final TicketsCreate creationModal;
    private final TicketsEdit editionModal;
    private final TicketsView viewModal;
    private Ticket ticketSelected;
    private List<Ticket> fetchedTickets;
    private List<Ticket> tableResults;

    public TicketsScreen(TicketsCreate creationModal, TicketsEdit editionModal, TicketsView viewModal) {
        initComponents();
        this.creationModal = creationModal;
        this.editionModal = editionModal;
        this.viewModal = viewModal;

        this.populateTable();
        this.updateBoxSearch();
        
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/TicketIconTest.png")).getImage());
    }
    
    private String getSelectedTicketCode() {
        if (TicketTable.getSelectedRow() != -1) {
            return String.valueOf(TicketTable.getModel().getValueAt(TicketTable.getSelectedRow(), 0));
        } else {
            return null;
        }
    }
    
    private Object getSelectedTicketValue() {
        return TicketTable.getModel().getValueAt(TicketTable.getSelectedRow(), TicketTable.getSelectedColumn());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boxSearch = new com.fp3.haras.components.ComboBoxSuggestion();
        spTicket = new javax.swing.JScrollPane();
        TicketTable = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        lblTítulo = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TicketTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "REQUIRENTE", "E-MAIL", "TIPO", "ASSUNTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TicketTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TicketTableMouseClicked(evt);
            }
        });
        spTicket.setViewportView(TicketTable);

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        btnCreate.setText("CRIAR");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnEdit.setText("EDITAR");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblTítulo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTítulo.setText("PAINEL DE TICKETS");

        btnUpdate.setText("ATUALIZAR");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnView.setText("VISUALIZAR");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearch)
                .addGap(26, 26, 26)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTítulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(spTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTítulo)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(btnCreate)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate)
                            .addComponent(btnView)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(519, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addComponent(spTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.creationModal.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (TicketTable.getSelectedColumnCount()!= 0
            && getSelectedTicketCode() != null && getSelectedTicketValue() != null) {

            this.editionModal.populateData(ticketSelected);
            this.editionModal.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_btnEditActionPerformed
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        this.populateTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void TicketTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) TicketTable.getModel();
        
        int id = Integer.parseInt(table.getValueAt(TicketTable.getSelectedRow(), 0).toString());
        
        String queryAnimal = "SELECT a FROM Ticket a WHERE a.id = " + id;
        this.ticketSelected = EntityUtils.select(queryAnimal, Ticket.class).get(0);
    }//GEN-LAST:event_TicketTableMouseClicked

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        DefaultTableModel table = (DefaultTableModel) TicketTable.getModel();
        table.setRowCount(0);
        
        if (boxSearch.getSelectedItem() == null) {
            this.populateTable();
        } else {
            String querySearch = "SELECT a FROM Ticket a WHERE a.nome = '" + (String) boxSearch.getSelectedItem() + "'";
            List<Ticket> ticket = EntityUtils.select(querySearch, Ticket.class);
            for (Ticket a : ticket) {
                table.addRow(new Object[]{
                    a.getId(),
                    a.getNome(),
                    a.getEmail(),
                    a.getTipo(),
                    a.getAssunto()
                });
            }
        }
    }//GEN-LAST:event_lblSearchMouseClicked

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        if (TicketTable.getSelectedColumnCount()!= 0
            && getSelectedTicketCode() != null && getSelectedTicketValue() != null) {

            this.viewModal.populateData(ticketSelected);
            this.viewModal.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Nada foi selecionado.", null, JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void fetchTableResults(/*int page, int maxResults*/) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticket");
        EntityManager em = emf.createEntityManager();
        
        //int firstResult = page == 1 ? 0 : ((page - 1) * maxResults);
        
        TypedQuery<Ticket> ticketsQuery = em.createQuery(
                "SELECT c FROM Ticket c WHERE c.isDeleted = FALSE order by c.id asc", 
                Ticket.class);
        this.tableResults = ticketsQuery./*setFirstResult(firstResult).setMaxResults(maxResults).*/getResultList();
    }
    
    private void updateBoxSearch(){
        boxSearch.addItem("");
        String queryTickets = "SELECT a from Ticket a WHERE a.isDeleted = FALSE";
        fetchedTickets = EntityUtils.select(queryTickets, Ticket.class);
        for (Ticket ticket : fetchedTickets) {
            boxSearch.addItem(ticket.getNome());
        }
    }
    
    private void populateTable() {
        DefaultTableModel table = (DefaultTableModel) TicketTable.getModel();
        table.setRowCount(0);
        
        fetchTableResults();
        for (Ticket t : this.tableResults) {
            table.addRow(new Object[]{
                t.getId(),
                t.getNome(),
                t.getEmail(),
                t.getTipo(),
                t.getAssunto(),
            });
        }
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TicketTable;
    private com.fp3.haras.components.ComboBoxSuggestion boxSearch;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTítulo;
    private javax.swing.JScrollPane spTicket;
    // End of variables declaration//GEN-END:variables
}
