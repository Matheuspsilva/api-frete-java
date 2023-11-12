package com.example.apifrete.repository;

import com.example.apifrete.model.Transportadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportadoraRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Transportadora> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM empresa",
                (rs, rowNum) ->
                        new Transportadora(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        )
        );
    }

    public  Transportadora findByCnpj(String cnpj) {
        return jdbcTemplate.query(
                "SELECT * FROM empresa WHERE cnpj = ?",
                (rs, rowNum) ->
                        new Transportadora(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        ), cnpj).get(0);
    }

    public  Transportadora findById(Long id) {
        return jdbcTemplate.query(
                "SELECT * FROM empresa WHERE id = ?",
                (rs, rowNum) ->
                        new Transportadora(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        ), id).get(0);
    }

    public Transportadora save(Transportadora transportadora) {
        jdbcTemplate.update(
                "INSERT INTO empresa (nome, endereco, telefone, cnpj) VALUES (?, ?, ?, ?)",
                transportadora.getNome(), transportadora.getEndereco(), transportadora.getTelefone(), transportadora.getCnpj()
        );
        return transportadora;
    }

    public void deleteById(Long id){
        jdbcTemplate.update(
                "DELETE FROM empresa WHERE id = ?",
                id
        );
    }

    public Transportadora update(Transportadora transportadora) {
        jdbcTemplate.update(
                "UPDATE empresa SET nome = ?, endereco = ?, telefone = ?, cnpj = ? WHERE id = ?",
                transportadora.getNome(), transportadora.getEndereco(), transportadora.getTelefone(), transportadora.getCnpj(), transportadora.getId()
        );
        return transportadora;
    }

}
