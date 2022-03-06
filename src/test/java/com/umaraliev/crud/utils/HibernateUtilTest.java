package com.umaraliev.crud.utils;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Umaraliev Bek
 */
public class HibernateUtilTest {
    
    /**
     * Test of getSessionFactory method, of class HibernateUtil.
     */
    @Test
    public void testGetSessionFactory() {
        assertEquals(true, HibernateUtil
                .getSessionFactory()
                .openSession()
                .isOpen());
        
    }
    
}
