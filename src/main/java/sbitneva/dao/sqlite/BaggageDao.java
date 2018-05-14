package sbitneva.dao.sqlite;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Qualifier("baggageDao")

public class BaggageDao {

    private static Logger log = Logger.getLogger(BaggageDao.class.getName());

    private static final String GET_CAPACITY = "select sum (weight) from baggage;";


    @Autowired
    private DataSource dataSource;


    public int calcCapacity(){
        int capacity = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CAPACITY)) {
             ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                capacity = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            log.error(e.getClass() + " : " + e.getMessage());
        }
        return  capacity;
    }

}
