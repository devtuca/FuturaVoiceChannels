package dev.tuca.storage;

import lombok.Getter;
import lombok.SneakyThrows;
import pro.husk.mysql.MySQL;

import java.sql.SQLException;

public class SQLConnection {

    @Getter
    private MySQL mySQL;

    public SQLConnection() {

        this.mySQL = new MySQL("jdbc:mysql://localhost:3306/teste", "root", "");

    }

    @SneakyThrows
    public void closeConnection() {
        if (mySQL.getConnection() != null) {
            mySQL.getConnection().close();
        }
    }
}
