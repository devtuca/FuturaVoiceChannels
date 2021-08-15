package dev.tuca.storage;

import lombok.SneakyThrows;
import org.bukkit.plugin.Plugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

public class SQLProvider extends SQLConnection {

    public SQLProvider() {
        super();
    }

    @SneakyThrows
    public <K> Optional<K> query(String sql, SQLConsumer<ResultSet, K> consumer, Object... objects) {
        PreparedStatement ps = getMySQL().getConnection().prepareStatement(sql);
        syncObjects(ps, objects);
        ResultSet set = ps.executeQuery();
        K result = set != null && set.next() ? consumer.apply(set) : null;
        set.close();
        ps.close();
        return Optional.ofNullable(result);
    }


    @SneakyThrows
    public int update(String sql, Object... objects) {
        PreparedStatement ps = getMySQL().getConnection().prepareStatement(sql);
        syncObjects(ps, objects);
        int result = ps.executeUpdate();
        ps.close();
        return result;
    }

    private void syncObjects(PreparedStatement ps, Object... objects) throws SQLException {
        Iterator<Object> iterator = Arrays.stream(objects).iterator();
        for (int i = 1; iterator.hasNext(); i++) {
            ps.setObject(i, iterator.next());
        }
    }
}