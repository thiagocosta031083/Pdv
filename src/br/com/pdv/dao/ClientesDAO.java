
package br.com.pdv.dao;

import br.com.pdv.jdbc.ConnectionFactory;
import br.com.pdv.model.Clientes;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class ClientesDAO {
    
    private Connection con;
              
    public ClientesDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    } 
    
    //Metodo cadastrarCliente
    public void cadastrarCliente(Clientes obj){
        try {
            //1 passo - criar o comando sql
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                   + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getUf());
            
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!!!");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }
    
     //Metodo alterarCliente
    public void alterarCliente(){
        
    }

     //Metodo excluirCliente
    public void excluirCliente(){
        
    }
    
     //Metodo Lista Todos Cliente
    public List<Clientes> listarClientes(){
        try {
            //1 passo - criar a lista
            List<Clientes> lista = new ArrayList<>();
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_clientes";            
            PreparedStatement stmt = con.prepareStatement(sql);            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));
                
                lista.add(obj);
                
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro" + e);
            return null;
        }
    }
}



        
