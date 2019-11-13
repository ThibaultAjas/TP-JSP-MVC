/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yay.jsp.mvc.resources;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.hsqldb.cmdline.SqlToolError;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author Dalfrak
 */
public class DAOTest {
    
    private DAO myDAO;
    private Rates rates;

    public DAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws SQLException, IOException, SqlToolError {
        this.rates = new Rates();
        this.rates.add(new RateEntity("H", 16f));
        this.rates.add(new RateEntity("M", 11f));
        this.rates.add(new RateEntity("L", 7f));
        this.rates.add(new RateEntity("N", 0f));
        
        myDAO = new DAO(DataSourceFactory.getDataSource(), this.rates);
        
        System.out.println(this.rates);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getRates method, of class DAO.
     */
    @Test
    public void testGetRates() {
        System.out.println("getRates");
        Rates expResult = this.rates;
        Rates result = myDAO.getRates();
        assertEquals(expResult, result);
    }

    /**
     * Test of addRate method, of class DAO.
     */
    @Test
    public void testAddRate() {
        System.out.println("addRate");
        RateEntity rate = new RateEntity("A", 10.5f);
        this.rates.add(rate);
        Rates expResult = rates;
        Rates result = myDAO.addRate(rate);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteRate method, of class DAO.
     */
    @Test
    public void testDeleteRate() {
        System.out.println("deleteRate");
        RateEntity rate = new RateEntity("A", 10.5f);
        Rates expResult = this.rates;
        Rates result = myDAO.deleteRate(rate);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateRate method, of class DAO.
     */
    @Test
    public void testUpdateRate() {
        System.out.println("updateRate");
        this.rates.add(new RateEntity("N", 10.5f));
        RateEntity rate = new RateEntity("N", 10.5f);
        Rates expResult = this.rates;
        Rates result = myDAO.updateRate(rate);
        assertEquals(expResult, result);
    }

}
//[RateEntity{code=A, rate=16.0}, RateEntity{code=M, rate=11.0}, RateEntity{code=L, rate=7.0}, RateEntity{code=N, rate=0.0}]
//[RateEntity{code=H, rate=16.0}, RateEntity{code=M, rate=11.0}, RateEntity{code=L, rate=7.0}, RateEntity{code=N, rate=0.0}]
