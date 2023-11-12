package com.example.apifrete.repository;

import com.example.apifrete.model.Destinatario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DestinatarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Destinatario> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM empresa",
                (rs, rowNum) ->
                        new Destinatario(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        )
        );
    }

    public  Destinatario findByCnpj(String cnpj) {
        return jdbcTemplate.query(
                "SELECT * FROM empresa WHERE cnpj = ?",
                (rs, rowNum) ->
                        new Destinatario(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        ), cnpj).get(0);
    }

    public  Destinatario findById(Long id) {
        return jdbcTemplate.query(
                "SELECT * FROM empresa WHERE id = ?",
                (rs, rowNum) ->
                        new Destinatario(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"),
                                rs.getString("telefone"),
                                rs.getString("cnpj")
                        ), id).get(0);
    }

    public Destinatario save(Destinatario destinatario) {
        jdbcTemplate.update(
                "INSERT INTO empresa (nome, endereco, telefone, cnpj) VALUES (?, ?, ?, ?)",
                destinatario.getNome(), destinatario.getEndereco(), destinatario.getTelefone(), destinatario.getCnpj()
        );
        return destinatario;
    }

    public void deleteById(Long id){
        jdbcTemplate.update(
                "DELETE FROM empresa WHERE id = ?",
                id
        );
    }

    public Destinatario update(Destinatario destinatario) {
        jdbcTemplate.update(
                "UPDATE empresa SET nome = ?, endereco = ?, telefone = ?, cnpj = ? WHERE id = ?",
                destinatario.getNome(), destinatario.getEndereco(), destinatario.getTelefone(), destinatario.getCnpj(), destinatario.getId()
        );
        return destinatario;
    }

}
