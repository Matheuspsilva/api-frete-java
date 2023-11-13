package com.example.apifrete.repository;

import com.example.apifrete.model.Rota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RotaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rota> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM rota",
                (rs, rowNum) ->
                        new Rota(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getFloat("distancia"),
                                rs.getString("enderecoOrigem"),
                                rs.getString("enderecoDestino")
                        )
        );
    }

    public Rota findById(Long id) {
        return jdbcTemplate.query(
                "SELECT * FROM rota WHERE id = ?",
                (rs, rowNum) ->
                        new Rota(
                                rs.getLong("id"),
                                rs.getString("nome"),
                                rs.getFloat("distancia"),
                                rs.getString("enderecoOrigem"),
                                rs.getString("enderecoDestino")
                        ), id).get(0);
    }

    public Rota save(Rota rota) {
        jdbcTemplate.update(
                "INSERT INTO rota (nome, distancia, enderecoOrigem, enderecoDestino) VALUES (?, ?, ?, ?)",
                rota.getNome(), rota.getDistancia(), rota.getEnderecoOrigem(), rota.getEnderecoDestino()
        );
        return rota;
    }

    public void deleteById(Long id){
        jdbcTemplate.update(
                "DELETE FROM rota WHERE id = ?",
                id
        );
    }

    public Rota update(Rota rota) {
        jdbcTemplate.update(
                "UPDATE rota SET nome = ?, distancia = ?, enderecoOrigem = ?, enderecoDestino = ? WHERE id = ?",
                rota.getNome(), rota.getDistancia(), rota.getEnderecoOrigem(), rota.getEnderecoDestino(), rota.getId()
        );
        return rota;
    }
}
