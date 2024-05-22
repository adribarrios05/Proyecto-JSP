package racing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class EquipoService implements CRUD<Equipo>{
    Connection conn = null;

    public EquipoService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Equipo> query(String column, String value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Equipo> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    private ArrayList<Equipo> _requestAll(String sql) throws SQLException{
        ArrayList<Equipo> result = new ArrayList<Equipo>();
        Statement statement = this.conn.createStatement();   

        ResultSet querySet = statement.executeQuery(sql);

        while(querySet.next()) {
            long codigo = querySet.getLong("codigo");
            String nombre = querySet.getString("nombre");
            String sede = querySet.getString("sede");
            int pais = querySet.getInt("pais");
            result.add(new Equipo(codigo, nombre, sede, pais));
        } 
        statement.close();
        return result;
    }

    @Override
    public ArrayList<Equipo> requestAll(String sortedBy) throws SQLException{
        String sql = "SELECT codigo, nombre, sede, pais FROM equipo"+(sortedBy.length()>0?(" ORDER BY "+sortedBy):"");
        return this._requestAll(sql);
    }

    @Override
    public Equipo requestById(long id) throws SQLException {    
        Equipo result = null;
        Statement statement = this.conn.createStatement();
        String sql = "SELECT codigo, nombre, sede, pais FROM equipo WHERE codigo = "+id;
        ResultSet querySet = statement.executeQuery(sql);

        while(querySet.next()) {
            String nombre = querySet.getString("nombre");
            String sede = querySet.getString("sede");
            int pais = querySet.getInt("pais");
            result = new Equipo(id, nombre, sede, pais);
        }
        return result;
    }

    @Override
    public long create(Equipo model) throws SQLException {
        String nombre = model.getNombre();
        String sede = model.getSede();
        int pais = model.getPais();

        String sql ="INSERT INTO equipo (nombre, sede, pais)"+ 
                                    "VALUES (?, ?, ?)";     
        try (PreparedStatement pstatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstatement.setString(1, nombre);
            pstatement.setString(2, sede);
            pstatement.setInt(3, pais);

            int affectedRows = pstatement.executeUpdate();
            if(affectedRows == 0)
                throw new SQLException("Error, no se ha podido añadir al equipo");
            
                try (ResultSet generatedKeys = pstatement.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        int codigo = generatedKeys.getInt(1);
                        return codigo;
                    } else {   
                        throw new SQLException("Error al crear el equipo. El código ya existe");
                    }
                }
        } 
    }

    @Override
    public int update(Equipo object) throws SQLException {
        long codigo = object.getCodigo();
        String nombre = object.getNombre();
        String sede = object.getSede();
        int pais = object.getPais();

        String sql ="UPDATE equipo SET nombre = ?, sede = ?, pais = ? WHERE codigo = ?";     

        try (PreparedStatement pstatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstatement.setString(1, nombre);
            pstatement.setString(2, sede);
            pstatement.setInt(3, pais);
            pstatement.setLong(4, codigo);

            int affectedRows = pstatement.executeUpdate();
            if(affectedRows == 0)
                throw new SQLException("Error, no se ha podido añadir al equipo");
            else
                return affectedRows;
        }
    }

    @Override
    public boolean delete(long id) throws SQLException {
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = "DELETE FROM equipo WHERE codigo = "+id;
        int res = statement.executeUpdate(sql);
        statement.close();
        return res==1;
    }
    
}

