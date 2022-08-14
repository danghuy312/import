package com.vnpt.dao;

import com.vnpt.utils.OracleDB;
import com.vnpt.model.CDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CDR_DAOImpl implements CDR_DAO {

    @Override
    public void insertDataToDB(List<CDR> list) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = OracleDB.getInstance().getConnection();

            /*oracle database
            StringBuilder sql = new StringBuilder("INSERT ALL");
            for (CDR cdr : list) {
                sql.append(" INTO CDR(phone_number, code, date_time) VALUE (?, ?, ?)");
            }
            sql.append(" SELECT 1 FROM dual");
            */

            //sql server database
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CDR");
            sql.append("     (phone_number, code, date_time)");
            sql.append(" VALUES ");
            sql.append("     (?, ?, ?)");
            for (int i = 1; i < list.size(); i++) {
                sql.append(" ,(?, ?, ?)");
            }
            //end sql server database

            statement = connection.prepareStatement(sql.toString());
            int i = 1;
            for (CDR cdr : list) {
                statement.setString(i++, cdr.getPhoneNumber());
                statement.setString(i++, cdr.getCode());
                statement.setString(i++, cdr.getDateTime());
            }
            statement.execute();
            System.out.println("insert data success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("insert data error");
        } finally {
            release(connection, statement);
        }
    }

    @Override
    public void deleteDataAndInsertLog() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = OracleDB.getInstance().getConnection();

//            StringBuilder sql = new StringBuilder();
//            sql.append("INSERT INTO LOG(phone_number, code, date_time)");
//            sql.append(" SELECT phone_number, code, date_time");
//            sql.append(" FROM CDR");

            //sql server database
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO LOG");
            sql.append("     (phone_number, code, date_time)");
            sql.append(" SELECT");
            sql.append("      phone_number, code, date_time");
            sql.append(" FROM CDR");

            statement = connection.prepareStatement(sql.toString());
            statement.execute();

//            String sql2 = "DELETE FROM CDR";
            String sql2 = "TRUNCATE TABLE CDR";
            statement = connection.prepareStatement(sql2);
            statement.execute();
            System.out.println("insert log success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("insert log error");
        } finally {
            release(connection, statement);
        }
    }

    private void release(Connection connection, PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
