package ua.lviv.iot;

import ua.lviv.iot.view.View;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {

        new View().show();
    }
}
