package racing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class PilotoService implements CRUD<Piloto>{
    Connection conn = null;

    public PilotoService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Piloto> query(String column, String value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Piloto> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    private ArrayList<Piloto> _requestAll(String sql) throws SQLException{
        ArrayList<Piloto> result = new ArrayList<Piloto>();
        Statement statement = this.conn.createStatement();   

        ResultSet querySet = statement.executeQuery(sql);

        while(querySet.next()) {
            long codigo = querySet.getLong("codigo");
            String nombre = querySet.getString("nombre");
            String apellidos = querySet.getString("apellidos");
            String fecha_nac = querySet.getString("fecha_nac");
            String nacionalidad = querySet.getString("nacionalidad");
            String equipo = querySet.getString("equipo");
            String categoria = querySet.getString("categoria");
            String urlImg = querySet.getString("url_img");
            result.add(new Piloto(codigo, nombre, apellidos, fecha_nac, nacionalidad, equipo, categoria, urlImg));
        } 
        statement.close();
        return result;
    }

    @Override
    public ArrayList<Piloto> requestAll(String sortedBy) throws SQLException{
        String sql = "SELECT codigo, nombre, apellidos, fecha_nac, nacionalidad, equipo, categoria, url_img FROM piloto"+(sortedBy.length()>0?(" ORDER BY "+sortedBy):"");
        return this._requestAll(sql);
    }

    @Override
    public Piloto requestById(long id) throws SQLException {    
        Piloto result = null;
        Statement statement = this.conn.createStatement();
        String sql = "SELECT codigo, nombre, apellidos, fecha_nac, nacionalidad, equipo, categoria, url_img FROM piloto WHERE codigo = "+id;
        ResultSet querySet = statement.executeQuery(sql);

        while(querySet.next()) {
            String nombre = querySet.getString("nombre");
            String apellidos = querySet.getString("apellidos");
            String fecha_nac = querySet.getString("fecha_nac");
            String nacionalidad = querySet.getString("nacionalidad");
            String equipo = querySet.getString("equipo");
            String categoria = querySet.getString("categoria");
            String urlImg = querySet.getString("url_img");
            result = new Piloto(id, nombre, apellidos, fecha_nac, nacionalidad, equipo, categoria, urlImg);
        }
        return result;
    }

    @Override
    public long create(Piloto model) throws SQLException {
        String nombre = model.getNombre();
        String apellidos = model.getApellidos();
        String fecha_nac = model.getFechaNacimiento();
        String nacionalidad = model.getNacionalidad();
        String equipo = model.getEquipo();
        String categoria = model.getCategoria();
        String url_img = model.getUrlImage();

        String sql ="INSERT INTO piloto (nombre, apellidos, fecha_nac, nacionalidad, equipo, categoria, url_img)"+ 
                                    "VALUES (?, ?, ?, ?, ?, ?, ?)";     
        try (PreparedStatement pstatement = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstatement.setString(1, nombre);
            pstatement.setString(2, apellidos);
            pstatement.setString(3, fecha_nac);
            pstatement.setString(4, nacionalidad);
            pstatement.setString(5, equipo);
            pstatement.setString(6, categoria);
            pstatement.setString(7, url_img);

            int affectedRows = pstatement.executeUpdate();
            if(affectedRows == 0)
                throw new SQLException("Error, no se ha podido añadir al piloto");
            
                try (ResultSet generatedKeys = pstatement.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        int codigo = generatedKeys.getInt(1);
                        return codigo;
                    } else {   
                        throw new SQLException("Error al crear el piloto. El código ya existe");
                    }
                }
        } 
    }

    @Override
    public int update(Piloto object) throws SQLException {
        long codigo = object.getCodigo();
        String nombre = object.getNombre();
        String apellidos = object.getApellidos();
        String fecha_nac = object.getFechaNacimiento();
        String nacionalidad = object.getNacionalidad();
        String equipo = object.getEquipo();
        String categoria = object.getCategoria();
        String url_img = nombre+"-"+apellidos+".jpg";

        String sql ="UPDATE piloto SET nombre = ?, apellidos = ?, fecha_nac = ?, nacionalidad = ?, equipo = ?, categoria = ?, url_img = ? WHERE codigo = ?";     

        try (PreparedStatement pstatement = this.conn.prepareStatement(sql)) {
            pstatement.setString(1, nombre);
            pstatement.setString(2, apellidos);
            pstatement.setString(3, fecha_nac);
            pstatement.setString(4, nacionalidad);
            pstatement.setString(5, equipo);
            pstatement.setString(6, categoria);
            pstatement.setString(7, url_img);
            pstatement.setLong(8, codigo);

            int affectedRows = pstatement.executeUpdate();
            if(affectedRows == 0)
                throw new SQLException("Error, no se ha podido añadir al piloto");
            else
                return affectedRows;
        }
    }

    @Override
    public boolean delete(long id) throws SQLException {
        Statement statement = null;
        statement = this.conn.createStatement();
        String sql = "DELETE FROM piloto WHERE codigo = "+id;
        int res = statement.executeUpdate(sql);
        statement.close();
        return res==1;
    }
    
}
