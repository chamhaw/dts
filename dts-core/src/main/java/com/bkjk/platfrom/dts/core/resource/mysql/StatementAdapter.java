package com.bkjk.platfrom.dts.core.resource.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bkjk.platform.dts.common.DtsContext;
import com.bkjk.platfrom.dts.core.resource.mysql.common.SQLType;
import com.bkjk.platfrom.dts.core.resource.mysql.parser.PaserExecutor;

public class StatementAdapter extends AbstractStatementAdapter {

    private String sql;

    public StatementAdapter(ConnectionAdapter connection, Statement statement) {
        super(connection, statement);
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        setSql(sql);
        if (shouldParse()) {
            SQLType sqlType = PaserExecutor.parse(this);
            boolean execute = this.statement.execute(sql);
            PaserExecutor.after(this, sqlType);
            return execute;
        }

        return this.statement.execute(sql);
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        setSql(sql);
        if (shouldParse()) {
            SQLType sqlType = PaserExecutor.parse(this);
            boolean execute = this.statement.execute(sql, autoGeneratedKeys);
            PaserExecutor.after(this, sqlType);
            return execute;
        }
        return this.statement.execute(sql, autoGeneratedKeys);
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        setSql(sql);
        if (shouldParse()) {
            SQLType sqlType = PaserExecutor.parse(this);
            boolean execute = this.statement.execute(sql, columnIndexes);
            PaserExecutor.after(this, sqlType);
            return execute;
        }
        return this.statement.execute(sql, columnIndexes);
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        setSql(sql);
        if (shouldParse()) {
            SQLType sqlType = PaserExecutor.parse(this);
            boolean execute = this.statement.execute(sql, columnNames);
            PaserExecutor.after(this, sqlType);
            return execute;
        }
        return this.statement.execute(sql, columnNames);
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        setSql(sql);
        return this.statement.executeQuery(sql);
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        setSql(sql);
        if (shouldParse()) {
            SQLType sqlType = PaserExecutor.parse(this);
            int execute = this.statement.executeUpdate(sql);
            PaserExecutor.after(this, sqlType);
            return execute;
        }
        return this.statement.executeUpdate(sql);
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        setSql(sql);
        if (shouldParse()) {
            SQLType sqlType = PaserExecutor.parse(this);
            int execute = this.statement.executeUpdate(sql, autoGeneratedKeys);
            PaserExecutor.after(this, sqlType);
            return execute;
        }
        return this.statement.executeUpdate(sql, autoGeneratedKeys);
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        setSql(sql);
        if (shouldParse()) {
            SQLType sqlType = PaserExecutor.parse(this);
            int execute = this.statement.executeUpdate(sql, columnIndexes);
            PaserExecutor.after(this, sqlType);
            return execute;
        }
        return this.statement.executeUpdate(sql, columnIndexes);
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        setSql(sql);
        if (shouldParse()) {
            SQLType sqlType = PaserExecutor.parse(this);
            int execute = this.statement.executeUpdate(sql, columnNames);
            PaserExecutor.after(this, sqlType);
            return execute;
        }
        return this.statement.executeUpdate(sql, columnNames);
    }

    public String getSql() {
        return this.sql;
    }

    protected boolean inTransaction() {
        return DtsContext.getInstance().inTransaction();
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    protected boolean shouldParse() {
        return inTransaction() && getSql() != null;
    }

}
