package racing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class PaisService implements CRUD<Pais>{
    Connection conn = null;

    public PaisService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Pais> query(String column, String value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Pais> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    private ArrayList<Pais> _requestAll(String sql) throws SQLException{
        ArrayList<Pais> result = new ArrayList<Pais>();
        Statement statement = this.conn.createStatement();   

        ResultSet querySet = statement.executeQuery(sql);

        while(querySet.next()) {
            long codigo = querySet.getLong("codigo");
            String nombre = querySet.getString("nombre");
            result.add(new Pais(codigo, nombre));
        } 
        statement.close();
        return result;
    }

    @Override
    public ArrayList<Pais> requestAll(String sortedBy) throws SQLException{
        String sql = "SELECT codigo, nombre FROM pais"+(sortedBy.length()>0?(" ORDER BY "+sortedBy):"");
        return this._requestAll(sql);
    }

    @Override
    public Pais requestById(long id) throws SQLException {    
        Pais result = null;
        Statement statement = this.conn.createStatement();
        String sql = "SELECT codigo, nombre FROM pais WHERE codigo = "+id;
        ResultSet querySet = statement.executeQuery(sql);

        while(querySet.next()) {
            String nombre = querySet.getString("nombre");
            result = new Pais(id, nombre);
        }
        return result;
    }

    @Override
    public long create(Pais model) throws SQLException {
        String nombre = model.getNombre();

        String sql ="INSERT INTO pais (nombre)"+ 
                                    "VALUES (?)";     
        try (PreparedStatement pstatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstatement.setString(1, nombre);

            int affectedRows = pstatement.executeUpdate();
            if(affectedRows == 0)
                throw new SQLException("Error, no se ha podido añadir el pais");
            
                try (ResultSet generatedKeys = pstatement.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        int codigo = generatedKeys.getInt(1);
                        return codigo;
                    } else {   
                        throw new SQLException("Error al crear el pais. El código ya existe");
                    }
                }
        } 
    }

    @Override
    public int update(Pais object) throws SQLException {
        long codigo = object.getCodigo();
        String nombre = object.getNombre();

        String sql ="UPDATE pais SET nombre = ? WHERE codigo = ?";     

        try (PreparedStatement pstatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstatement.setString(1, nombre);
            pstatement.setLong(2, codigo);

            int affectedRows = pstatement.executeUpdate();
            if(affectedRows == 0)
                throw new SQLException("Error, no se ha podido modificar el pais");
            else
                return affectedRows;
        }
    }

    @Override
    public boolean delete(long id) throws SQLException {
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = "DELETE FROM pais WHERE codigo = "+id;
        int res = statement.executeUpdate(sql);
        statement.close();
        return res==1;
    }
}

