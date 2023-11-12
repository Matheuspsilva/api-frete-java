package com.example.apifrete.repository;

import com.example.apifrete.model.Remetente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RemetenteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Remetente> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM empresa",
                (rs, rowNum) ->
                        new Remetente(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        )
        );
    }

    public  Remetente findByCnpj(String cnpj) {
        return jdbcTemplate.query(
                "SELECT * FROM empresa WHERE cnpj = ?",
                (rs, rowNum) ->
                        new Remetente(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        ), cnpj).get(0);
    }

    public  Remetente findById(Long id) {
        return jdbcTemplate.query(
                "SELECT * FROM empresa WHERE id = ?",
                (rs, rowNum) ->
                        new Remetente(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        ), id).get(0);
    }

    public Remetente save(Remetente remetente) {
        jdbcTemplate.update(
                "INSERT INTO empresa (nome, endereco, telefone, cnpj) VALUES (?, ?, ?, ?)",
                remetente.getNome(), remetente.getEndereco(), remetente.getTelefone(), remetente.getCnpj()
        );
        return remetente;
    }

    public void deleteById(Long id){
        jdbcTemplate.update(
                "DELETE FROM empresa WHERE id = ?",
                id
        );
    }

    public Remetente update(Remetente remetente) {
        jdbcTemplate.update(
                "UPDATE empresa SET nome = ?, endereco = ?, telefone = ?, cnpj = ? WHERE id = ?",
                remetente.getNome(), remetente.getEndereco(), remetente.getTelefone(), remetente.getCnpj(), remetente.getId()
        );
        return remetente;
    }

}
