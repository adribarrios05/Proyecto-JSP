package racing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class CategoriaService implements CRUD<Categoria>{
    Connection conn = null;

    public CategoriaService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Categoria> query(String column, String value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Categoria> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    private ArrayList<Categoria> _requestAll(String sql) throws SQLException{
        ArrayList<Categoria> result = new ArrayList<Categoria>();
        Statement statement = this.conn.createStatement();   

        ResultSet querySet = statement.executeQuery(sql);

        while(querySet.next()) {
            long codigo = querySet.getLong("codigo");
            String nombre = querySet.getString("nombre");
            String tipo = querySet.getString("tipo_vehiculo");
            result.add(new Categoria(codigo, nombre, tipo));
        } 
        statement.close();
        return result;
    }

    @Override
    public ArrayList<Categoria> requestAll(String sortedBy) throws SQLException{
        String sql = "SELECT codigo, nombre, tipo_vehiculo FROM categoria"+(sortedBy.length()>0?(" ORDER BY "+sortedBy):"");
        return this._requestAll(sql);
    }

    @Override
    public Categoria requestById(long id) throws SQLException {    
        Categoria result = null;
        Statement statement = this.conn.createStatement();
        String sql = "SELECT codigo, nombre, tipo_vehiculo FROM categoria WHERE codigo = "+id;
        ResultSet querySet = statement.executeQuery(sql);

        while(querySet.next()) {
            String nombre = querySet.getString("nombre");
            String tipo = querySet.getString("tipo_vehiculo");
            result = new Categoria(id, nombre, tipo);
        }
        return result;
    }

    @Override
    public long create(Categoria model) throws SQLException {
        String nombre = model.getNombre();
        String tipo = model.getTipo();

        String sql ="INSERT INTO categoria (nombre, tipo_vehiculo)"+ 
                                    "VALUES (?, ?)";     
        try (PreparedStatement pstatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstatement.setString(1, nombre);
            pstatement.setString(2, tipo);

            int affectedRows = pstatement.executeUpdate();
            if(affectedRows == 0)
                throw new SQLException("Error, no se ha podido añadir a la categoria");
            
                try (ResultSet generatedKeys = pstatement.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        int codigo = generatedKeys.getInt(1);
                        return codigo;
                    } else {   
                        throw new SQLException("Error al crear la categoria. El código ya existe");
                    }
                }
        } 
    }

    @Override
    public int update(Categoria object) throws SQLException {
        long codigo = object.getCodigo();
        String nombre = object.getNombre();
        String tipo = object.getTipo();

        String sql ="UPDATE categoria SET nombre = ?, tipo_vehiculo = ? WHERE codigo = ?";     

        try (PreparedStatement pstatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstatement.setString(1, nombre);
            pstatement.setString(2, tipo);
            pstatement.setLong(3, codigo);

            int affectedRows = pstatement.executeUpdate();
            if(affectedRows == 0)
                throw new SQLException("Error, no se ha podido modificar la categoria");
            else
                return affectedRows;
        }
    }

    @Override
    public boolean delete(long id) throws SQLException {
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = "DELETE FROM categoria WHERE codigo = "+id;
        int res = statement.executeUpdate(sql);
        statement.close();
        return res==1;
    }
    
}

