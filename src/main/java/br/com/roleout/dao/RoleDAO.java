package br.com.roleout.dao;

import br.com.roleout.config.ConnectionFactory;
import br.com.roleout.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {

    public void inserir(Role role) {

        String sql = """
                INSERT INTO roles
                (nome, descricao, local, cidade, data, categoria, valor)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, role.getNome());
            statement.setString(2, role.getDescricao());
            statement.setString(3, role.getLocal());
            statement.setString(4, role.getCidade());
            if (role.getData() != null) {
    statement.setDate(
        5,
        java.sql.Date.valueOf(role.getData())
    );
} else {
    statement.setNull(5, java.sql.Types.DATE);
}
            statement.setString(6, role.getCategoria());
            statement.setDouble(7, role.getValor());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir rolê no banco.", e);
        }
    }
    public List<Role> listarTodos() {

    List<Role> roles = new ArrayList<>();

    String sql = "SELECT * FROM roles ORDER BY data";

    try (
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()
    ) {

        while (resultSet.next()) {

            Role role = new Role();

            role.setId(resultSet.getInt("id"));
            role.setNome(resultSet.getString("nome"));
            role.setDescricao(resultSet.getString("descricao"));
            role.setLocal(resultSet.getString("local"));
            role.setCidade(resultSet.getString("cidade"));

            if (resultSet.getDate("data") != null) {
                role.setData(resultSet.getDate("data").toLocalDate());
            }

            role.setCategoria(resultSet.getString("categoria"));
            role.setValor(resultSet.getDouble("valor"));

            roles.add(role);
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao listar rolês.", e);
    }

    return roles;
}


public void atualizar(Role role) {

    String sql = """
            UPDATE roles
            SET nome = ?,
                descricao = ?,
                local = ?,
                cidade = ?,
                data = ?,
                categoria = ?,
                valor = ?
            WHERE id = ?
            """;

    try (
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)
    ) {

        statement.setString(1, role.getNome());
        statement.setString(2, role.getDescricao());
        statement.setString(3, role.getLocal());
        statement.setString(4, role.getCidade());
        if (role.getData() != null) {
    statement.setDate(
        5,
        java.sql.Date.valueOf(role.getData())
    );
} else {
    statement.setNull(5, java.sql.Types.DATE);
}
        statement.setString(6, role.getCategoria());
        statement.setDouble(7, role.getValor());
        statement.setInt(8, role.getId());

        statement.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao atualizar rolê.", e);
    }
}


public void excluir(int id) {

    String sql = "DELETE FROM roles WHERE id = ?";

    try (
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)
    ) {

        statement.setInt(1, id);

        statement.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao excluir rolê.", e);
    }
}
public Role buscarPorId(int id) {

    String sql = "SELECT * FROM roles WHERE id = ?";

    try (
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)
    ) {

        statement.setInt(1, id);

        try (ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {

                Role role = new Role();

                role.setId(resultSet.getInt("id"));
                role.setNome(resultSet.getString("nome"));
                role.setDescricao(resultSet.getString("descricao"));
                role.setLocal(resultSet.getString("local"));
                role.setCidade(resultSet.getString("cidade"));

                if (resultSet.getDate("data") != null) {
                    role.setData(resultSet.getDate("data").toLocalDate());
                }

                role.setCategoria(resultSet.getString("categoria"));
                role.setValor(resultSet.getDouble("valor"));

                return role;
            }
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar rolê.", e);
    }

    return null;
}
public List<Role> buscarSugestoes(String categoria, String cidade, double valorMaximo) {

    List<Role> roles = new ArrayList<>();

    String sql = """
            SELECT *
            FROM roles
            WHERE LOWER(categoria) = LOWER(?)
              AND LOWER(cidade) = LOWER(?)
              AND valor <= ?
            ORDER BY valor ASC
            """;

    try (
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)
    ) {

        statement.setString(1, categoria);
        statement.setString(2, cidade);
        statement.setDouble(3, valorMaximo);

        try (ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Role role = new Role();

                role.setId(resultSet.getInt("id"));
                role.setNome(resultSet.getString("nome"));
                role.setDescricao(resultSet.getString("descricao"));
                role.setLocal(resultSet.getString("local"));
                role.setCidade(resultSet.getString("cidade"));

                if (resultSet.getDate("data") != null) {
                    role.setData(resultSet.getDate("data").toLocalDate());
                }

                role.setCategoria(resultSet.getString("categoria"));
                role.setValor(resultSet.getDouble("valor"));

                roles.add(role);
            }
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar sugestões de rolês.", e);
    }

    return roles;
}
}
