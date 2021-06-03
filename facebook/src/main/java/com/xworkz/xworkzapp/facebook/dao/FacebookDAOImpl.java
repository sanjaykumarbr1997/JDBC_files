package com.xworkz.xworkzapp.facebook.dao;

import java.sql.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;

import java.sql.ResultSet;


public class FacebookDAOImpl implements  FacebookDAO {

    @Override
    public void createFaceBook(FacebookDTO bookDTO) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fbn", "root", "passeror");
            statement = connection.createStatement();
            statement.execute("insert into facebook_table values(" + bookDTO.getId() + ",'" + bookDTO.getName() + "','" + bookDTO.getEmail() + "','" + bookDTO.getPassword() + "')");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement!= null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!= null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Override
    public List<FacebookDTO> getAllFaceBookDetails() {

        Connection connection = null;
        Statement statement = null;
        List<FacebookDTO> bookDTOs = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fbn", "root", "passeord");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select*from facebook_table");

            while (resultSet.next()) {

                FacebookDTO bookDTO = new FacebookDTO();
                bookDTO.setId(resultSet.getInt("facebook_id"));
                bookDTO.setName(resultSet.getString("facebook_name"));
                bookDTO.setEmail(resultSet.getString("facebook_email"));
                bookDTO.setPassword(resultSet.getString("facebook_password"));

                bookDTOs.add(bookDTO);
                System.out.println(bookDTOs);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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
        return bookDTOs;

    }

}
