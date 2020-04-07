package Service;

import Model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsJDBCServiceImpl implements NewsJDBCService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudymvc";
    private String jdbcUsername = "root";
    private String jdbcPassword = "volong0708";


    private static final String SELECT_ALL_USERS = "SELECT * FROM news ORDER BY id DESC";
    private static final String SELECT_BY_ID = "select id, date, title, img, content from news where id = ?";
    private static final String INSERT_USERS_SQL = "INSERT INTO news" + "  ( date, title, img, content) VALUES "
            + " (?, ?, ?, ?);";
    private static final String DELETE_USERS_SQL = "delete from news where id = ?;";
    private static final String UPDATE_USERS_SQL = "update news set date = ?, title = ?, img=?, content=? where id = ?;";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public News findById(int id) {
        News news = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String date = rs.getString("date");
                String title = rs.getString("title");
                String img = rs.getString("img");
                String content = rs.getString("content");
                news = new News(id, date, title, img, content);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return news;
    }

    @Override
    public List<News> findAll() {
        List<News> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("date");
                String title = rs.getString("title");
                String img = rs.getString("img");
                String content = rs.getString("content");
                users.add(new News(id, date, title, img, content));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }


    @Override
    public void save(News news) {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, news.getDate());
            preparedStatement.setString(2, news.getTitle());
            preparedStatement.setString(3, news.getImg());
            preparedStatement.setString(4, news.getContent());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void update(int id, News news) {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, news.getDate());
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getImg());
            statement.setString(4, news.getContent());
            statement.setInt(5, news.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        //return rowUpdated;
    }

    @Override
    public void remove(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

