package View;

import DAO.ClienteDAO;
import Model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ClienteView extends javax.swing.JInternalFrame {

    Cliente cliente;
    ClienteDAO clienteDAO;
    List<Cliente> ListaClientes;

    public ClienteView() {

        clienteDAO = new ClienteDAO();
        ListaClientes = new ArrayList<>();
        initComponents();
        this.setVisible(true);

    }

    public void atualizarTabelaCliente() {
        cliente = new Cliente();
        try {
            ListaClientes = clienteDAO.ListaCliente();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dados[][] = new String[ListaClientes.size()][5];
        int i = 0;
        for (Cliente cliente : ListaClientes) {
            dados[i][0] = String.valueOf(cliente.getCodigocliente());
            dados[i][1] = cliente.getNomeCliente();
            dados[i][2] = cliente.getEnderecoCliente();
            dados[i][3] = cliente.getBairroCliente();
            dados[i][4] = cliente.getCPFCliente();
            i++;

        }
        String tituloColuna[] = {"codigo", "nome", "endereço", "bairro", "CPF"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        tblCliente.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });
        tblCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblCliente.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblCliente.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblCliente.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblCliente.getColumnModel().getColumn(4).setPreferredWidth(200);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tblCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tblCliente.setRowHeight(25);
        tblCliente.updateUI();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Bairro:");

        jLabel5.setText("CPF:");

        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNome.setEnabled(false);

        txtEndereco.setEnabled(false);
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        txtBairro.setEnabled(false);

        txtCPF.setEnabled(false);

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Endereço", "Bairro", "CPF"
            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                            .addComponent(txtCodigo)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlterar)
                                .addGap(50, 50, 50)
                                .addComponent(btnExcluir)
                                .addGap(34, 34, 34)
                                .addComponent(btnSalvar)
                                .addGap(12, 12, 12)))
                        .addGap(54, 54, 54)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovo))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtEndereco.getText().isEmpty() || txtCPF.getText().isEmpty() || txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos !");
        } else if (txtCodigo.getText().isEmpty()) {

            cliente = new Cliente();
            cliente.setNomeCliente(txtNome.getText());
            cliente.setEnderecoCliente(txtEndereco.getText());
            cliente.setBairroCliente(txtBairro.getText());
            cliente.setCPFCliente(txtCPF.getText());
        try {
            clienteDAO.salvar(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
        preparaSalvar();
        desativaCampos();
        limpaCamposCliente();
        atualizarTabelaCliente();
        }
        else{
            cliente = new Cliente();
            cliente.setCodigocliente(Integer.parseInt(txtCodigo.getText()));
            cliente.setNomeCliente(txtNome.getText());
            cliente.setEnderecoCliente(txtEndereco.getText());
            cliente.setBairroCliente(txtBairro.getText());
            cliente.setCPFCliente(txtCPF.getText());
        try {
            clienteDAO.salvar(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
        preparaSalvar();
        desativaCampos();
        atualizarTabelaCliente();
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (txtCodigo.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Selecione o código do Cliente!");
        } else {
            cliente = new Cliente();

            cliente.setCodigocliente(Integer.parseInt(txtCodigo.getText()));
            int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir?" + txtNome.getText());
            if (confirma == 0) {

                try {
                    clienteDAO.excluir(cliente);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
                }
                atualizarTabelaCliente();
                limpaCamposCliente();
                preparaExcluir();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpaCamposCliente();
        ativaCampos();
        preparaNovo();
        atualizarTabelaCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (txtCodigo.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Selecione um Cliente!");
        }
        cliente = new Cliente();
        cliente.setCodigocliente(Integer.parseInt(txtCodigo.getText()));
        cliente.setNomeCliente(txtNome.getText());
        cliente.setEnderecoCliente(txtEndereco.getText());
        cliente.setBairroCliente(txtBairro.getText());
        cliente.setCPFCliente(txtCPF.getText());

        try {
            clienteDAO.alterar(cliente);

            JOptionPane.showMessageDialog(null, "Cliente Alterado!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }

        atualizarTabelaCliente();
        preparaAlterar();
        ativaCampos();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        // TODO add your handling code here:
        txtCodigo.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(),0).toString());
        txtNome.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(),0).toString());
        txtEndereco.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(),0).toString());
        txtBairro.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(),0).toString());
        txtCPF.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(),0).toString());
        preparaselecaotabela();
    }//GEN-LAST:event_tblClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
private void limpaCamposCliente() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtEndereco.setText("");
        txtBairro.setText("");
        txtCPF.setText("");
    }

    public void ativaCampos() {
        txtNome.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtBairro.setEnabled(true);
        txtCPF.setEnabled(true);
    }

    public void desativaCampos() {
        txtNome.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtBairro.setEnabled(false);
        txtCPF.setEnabled(false);
    }

    public void preparaNovo() {
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        tblCliente.setEnabled(false);
        tblCliente.clearSelection();

    }
    public void preparaSalvar () {
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        tblCliente.setEnabled(true);
        }
    public void preparaselecaotabela() {
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
      }
    public void preparaAlterar() {
        btnNovo.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(true);
        tblCliente.setEnabled(false);
        tblCliente.clearSelection();
    }
    public void preparaExcluir() {
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        }
}
