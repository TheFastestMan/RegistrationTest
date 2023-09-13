package dao;

import entity.User;
import exception.DaoException;
import util.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;

public class UserDao{
    private static final UserDao INSTANCE = new UserDao();
    private static final String SAVE_SQL = """
            INSERT INTO users1 (
            name, password, email
            )
            values
            (?,?,?);
            """;

    public User save(User user) {

        try (var connection = ConnectionManager.open();
             var prepareStatement = connection.prepareStatement(SAVE_SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getEmail());

            prepareStatement.executeUpdate();

            var keys = prepareStatement.getGeneratedKeys();
            if (keys.next())
                user.setId(keys.getLong("id"));
            return user;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    public static UserDao getInstance(){
        return INSTANCE;
    }
}
