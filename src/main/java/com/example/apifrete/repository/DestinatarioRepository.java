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



}
