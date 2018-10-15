/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ClienteDAO;
import Model.Cliente;
import Variables.Variaveis;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Skalybuhr
 */
public class Tela_Cliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Tela_Cliente
     */
    Cliente cliente = new Cliente();
    
    public Tela_Cliente() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jt_Clientes.getModel ();
        jt_Clientes.setRowSorter(new TableRowSorter(modelo));
        
        try {
            listarjTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tela_Cliente.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Clientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jt_Cli_Buscar = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jb_Cli_Cadastrar = new javax.swing.JButton();
        jb_Cli_Atualizar = new javax.swing.JButton();
        jb_Cli_Excluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle(Variaveis.TITULO_CLIENTE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 77, 77));

        jt_Clientes.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jt_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód", "Nome", "Endereço", "Telefone", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_ClientesMouseClicked(evt);
            }
        });
        jt_Clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_ClientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jt_Clientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 450));

        jPanel2.setBackground(new java.awt.Color(255, 77, 77));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");

        jButton4.setBackground(new java.awt.Color(255, 77, 77));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons_search_20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jt_Cli_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton4)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jt_Cli_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton4)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 210, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jb_Cli_Cadastrar.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jb_Cli_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons_add_25.png"))); // NOI18N
        jb_Cli_Cadastrar.setText("Cadastrar");
        jb_Cli_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_Cli_CadastrarActionPerformed(evt);
            }
        });

        jb_Cli_Atualizar.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jb_Cli_Atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons_update_25.png"))); // NOI18N
        jb_Cli_Atualizar.setText("Atualizar");
        jb_Cli_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_Cli_AtualizarActionPerformed(evt);
            }
        });

        jb_Cli_Excluir.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jb_Cli_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons_trash_25.png"))); // NOI18N
        jb_Cli_Excluir.setText("Excluir");
        jb_Cli_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_Cli_ExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jb_Cli_Cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Cli_Atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_Cli_Excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jb_Cli_Cadastrar)
                .addGap(50, 50, 50)
                .addComponent(jb_Cli_Atualizar)
                .addGap(50, 50, 50)
                .addComponent(jb_Cli_Excluir)
                .addGap(78, 78, 78))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 220, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_Cli_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_Cli_CadastrarActionPerformed
        // TODO add your handling code here:
        Cadastro_Cliente cc = new Cadastro_Cliente(null, true);
        cc.setVisible(true);
    }//GEN-LAST:event_jb_Cli_CadastrarActionPerformed

    private void jt_ClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_ClientesKeyReleased
        // TODO add your handling code here:
        //Getting id from table
        /*if(jt_Clientes.getSelectedRow() != -1){
            Cliente cliente = new Cliente();
            cliente.setId((int)jt_Clientes.getValueAt(jt_Clientes.getSelectedRow(), 0));
            System.out.println("Customer's id from table: "+cliente.getId()+" key released.");
        }*/
    }//GEN-LAST:event_jt_ClientesKeyReleased

    private void jt_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_ClientesMouseClicked
        // TODO add your handling code here:
        //Getting id from table
        if(jt_Clientes.getSelectedRow() != -1){
            cliente.setId((int)jt_Clientes.getValueAt(jt_Clientes.getSelectedRow(), 0));
            Variaveis.UPDATE = true;
            System.out.println("Customer's id from table: "+cliente.getId());
        }
    }//GEN-LAST:event_jt_ClientesMouseClicked

    private void jb_Cli_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_Cli_AtualizarActionPerformed
        // TODO add your handling code here:
        if (Variaveis.UPDATE == true) {
            Variaveis.ID = cliente.getId();
            Cadastro_Cliente cc = new Cadastro_Cliente(null, true);
            cc.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(this, "Você precisa clicar em um registro para atualizar!");
        }

    }//GEN-LAST:event_jb_Cli_AtualizarActionPerformed

    private void jb_Cli_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_Cli_ExcluirActionPerformed
        // TODO add your handling code here:
        ClienteDAO clienteDAO = new ClienteDAO();
        if(Variaveis.UPDATE == true){
            //Delete
            if(clienteDAO.Deletar_Cliente(cliente)){
                try {
                    listarjTable();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Tela_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Deletado com sucesso!");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Você precisa clicar em um registro para deletar!");
        }
    }//GEN-LAST:event_jb_Cli_ExcluirActionPerformed

    //Methods
    public void listarjTable() throws ClassNotFoundException{
        DefaultTableModel model = (DefaultTableModel) jt_Clientes.getModel();
        model.setNumRows(0);
        ClienteDAO clienteDAO = new ClienteDAO();
        
        for(Cliente c: clienteDAO.Listar_Cliente()){
            model.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getEndereco(),
                c.getTelefone(),
                c.getCelular()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_Cli_Atualizar;
    private javax.swing.JButton jb_Cli_Cadastrar;
    private javax.swing.JButton jb_Cli_Excluir;
    private javax.swing.JTextField jt_Cli_Buscar;
    private javax.swing.JTable jt_Clientes;
    // End of variables declaration//GEN-END:variables
}
