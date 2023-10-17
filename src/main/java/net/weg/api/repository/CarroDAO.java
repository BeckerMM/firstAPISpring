package net.weg.api.repository;

import net.weg.api.model.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO extends DAOPadrao <Carro,Integer>{

    public CarroDAO() {
        super("carro");
    }

    @Override
    public void inserir(Carro obj) {
        String comandoSQL = "INSERT INTO carro VALUES(?,?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(comandoSQL)) {
            stmt.setInt(1,obj.getId());
            stmt.setString(2,obj.getMarca());
            stmt.setString(3,obj.getCor());
            stmt.setString(4,obj.getModelo());
            stmt.setDouble(5,obj.getPreco());
            stmt.setInt(6,obj.getAno());


            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Carro converter(ResultSet resultSet) throws SQLException {
        return new Carro(resultSet);
    }

    @Override
    public void atualizar(Carro obj) {

    }


}