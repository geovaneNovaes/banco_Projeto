/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deyvid
 */
public class ClienteDAO {
     PreparedStatement pst;
   String sql;
   
   public void salvar(Cliente cliente) throws SQLException {
   
   sql = "insert into cliente values (?,?,?,?,?)";
   pst = Conexao.getInstance().prepareStatement(sql);
   pst.setInt(1,0);
   pst.setString(2, cliente.getNomeCliente());
   pst.setString(3, cliente.getEnderecoCliente());
   pst.setString(4, cliente.getBairroCliente());
   pst.setString(5, cliente.getCPFCliente());
   
   pst.execute ();
   pst.close();
   }
   
   public List<Cliente> ListaCliente () throws SQLException{
   
   List<Cliente> listaClientes;
   listaClientes = new ArrayList<> ();
   sql = "select * from cliente order by codigo";
   pst = Conexao.getInstance ().prepareStatement (sql);
   ResultSet rs = pst.executeQuery();
   while (rs.next()){
     listaClientes.add(new Cliente (rs.getInt("codigo"), rs.getString ("nome"),
             rs.getString("endereco"), rs.getString ("bairro"), rs.getString("CPF")));
   
   }
   
  
   
   pst.close();
   return listaClientes;
   
   
}
}