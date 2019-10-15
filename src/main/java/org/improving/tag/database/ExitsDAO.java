package org.improving.tag.database;

import org.improving.tag.Adversary;
import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.improving.tag.items.UniqueItems;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Component
public class ExitsDAO {
    private final JdbcTemplate jdbcTemplate;

    public ExitsDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Exit> findExitsByOriginId(int id){
        try {
            List<Exit> exits = jdbcTemplate.query("SELECT * FROM exits WHERE OriginId = " + id,
                    (result, rownum) -> {
                        Exit exit = new Exit();
                        exit.setDestinationId(result.getInt("DestinationId"));
                        exit.setName(result.getString("Name"));
                        String getAliases = result.getString("Aliases");
                        String[] splitAliases = (getAliases.split(", "));
                        List<String> aliases = Arrays.asList(splitAliases);
                        exit.setAliases(aliases);
                        //EntityManager em = JPAUtility.getEntityManager();
                        //Exit exit = em.find(Exit.class, Long.parseLong(result.getString("Id")));

                        return exit;
                    });
            return exits;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }

}
