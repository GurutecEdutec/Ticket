package com.ticket.view;

import com.ticket.model.Ticket;
import com.ticket.utils.EntityUtils;
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
    private Ticket ticketSelected;
    private List<Ticket> fetchedTickets;
    private List<Ticket> tableResults;

    public TicketsScreen(TicketsCreate creationModal, TicketsEdit editionModal) {
        initComponents();
        this.creationModal = creationModal;
        this.editionModal = editionModal;

        this.populateTable();
        //this.updateBoxSearch();
        
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
        spTicket = new javax.swing.JScrollPane();
        TicketTable = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        lblTítulo = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

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

        txtSearch.setText("Pesquisar...");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtSearchMouseReleased(evt);
            }
        });

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTítulo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreate)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate))
                .addContainerGap(512, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addComponent(spTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equals(""))
        txtSearch.setText("Pesquisar...");
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseReleased
        if (txtSearch.getText().equals("Pesquisar..."))
        txtSearch.setText(null);
    }//GEN-LAST:event_txtSearchMouseReleased

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

    private void fetchTableResults(/*int page, int maxResults*/) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticket");
        EntityManager em = emf.createEntityManager();
        
        //int firstResult = page == 1 ? 0 : ((page - 1) * maxResults);
        
        TypedQuery<Ticket> ticketsQuery = em.createQuery(
                "SELECT c FROM Ticket c WHERE c.isDeleted = FALSE order by c.id asc", 
                Ticket.class);
        this.tableResults = ticketsQuery./*setFirstResult(firstResult).setMaxResults(maxResults).*/getResultList();
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
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTítulo;
    private javax.swing.JScrollPane spTicket;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
