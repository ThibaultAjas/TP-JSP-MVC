/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yay.jsp.mvc.resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Dalfrak
 */
public class DAO {

    protected final DataSource myDataSource;
    private Rates ratesList;

    public DAO(DataSource dataSource) {
        this.myDataSource = dataSource;
        this.ratesList = new Rates();
    }

    public DAO(DataSource dataSource, Rates r) {
        this.myDataSource = dataSource;
        this.ratesList = r;
    }

    public Rates getRates() {
        String sql = "SELECT DISCOUNT_CODE, RATE FROM DISCOUNT_CODE";
        try (
                Connection con = myDataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                RateEntity rate = new RateEntity();
                rate.setCode(rs.getString("DISCOUNT_CODE"));
                rate.setRate(rs.getFloat("RATE"));
                this.ratesList.add(rate);
            }
        } catch (SQLException e) {
        }
        return this.ratesList;
    }

    public Rates addRate(RateEntity rate) {
        String sql = "INSERT INTO DISCOUNT_CODE VALUES (?, ?)";

        try (Connection con = myDataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, rate.getCode());
            stmt.setFloat(2, rate.getRate());
            stmt.executeUpdate();
            this.ratesList.add(rate);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.ratesList;
    }

    public Rates deleteRate(RateEntity rate) {
        String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE=? AND RATE=?";
        try (Connection con = myDataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, rate.getCode());
            stmt.setFloat(2, rate.getRate());
            stmt.executeUpdate();
            this.ratesList.deleteRate(rate);
        } catch (SQLException e) {
        }
        return this.ratesList;
    }

    public Rates updateRate(RateEntity newRate) {
        String sql = "UPDATE DISCOUNT_CODE SET RATE=? WHERE DISCOUNT_CODE=? AND RATE=?";
        RateEntity oldRate = this.ratesList.getRateFromCode(newRate.getCode());
        try (Connection con = myDataSource.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setFloat(1, newRate.getRate());
            stmt.setString(2, oldRate.getCode());
            stmt.setFloat(3, oldRate.getRate());
            stmt.executeUpdate();
            this.ratesList.updateRate(oldRate, newRate.getRate());
        } catch (SQLException e) {
        }
        return this.ratesList;
    }

}
