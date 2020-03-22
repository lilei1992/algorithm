package com.tb.function;

import java.util.function.Consumer;

/**
 * @author: lilei
 * @time: 2020/3/22 17:56
 */
public class Connection {
    public void commit() {
    }

    public void rollback() {
    }

    public void close() {
    }

    public void setAutoCommit(boolean autoCommit) {
    }

    public void setRunWithTrasaction(Consumer<Connection> consumer) {
        Connection connection = null;
        try {
            connection = new Connection();
            connection.setAutoCommit(true);
            consumer.accept(connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }
    }
}

