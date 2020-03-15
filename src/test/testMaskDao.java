package test;

import org.junit.*;
import pojo.*; 
import dao.*;

/**
 * testMaskDao
 */
public class testMaskDao extends junit.framework.TestCase{

    //测试add(Reservation bean)方法
    @Test
    public void testAdd() {
        final int reserveNum = 1;
        final String name = "张三";
        final String ID = "62010419980911027X";
        final String tel = "13110513356";
        final int number = 10000;

        MaskDAOImpl maskDao = new MaskDAOImpl();
        Reservation reservation = new Reservation(reserveNum, name, ID, tel, number);
        maskDao.add(reservation);
    }

    //测试update(int id,String status)方法
    @Test
    public void testUpdate() {
        final int id = 1;
        final String status = "0";
        MaskDAOImpl maskDao = new MaskDAOImpl();
        maskDao.update(id, status);
    }

    //测试list(int id)方法
    @Test
    public void testList() {
        final String id = "1";
        MaskDAOImpl maskDao = new MaskDAOImpl();
        maskDao.list(id);
    }

    //测试query(String id, int times)方法
    @Test
    public void testQuery() {
        final String id = "13";
        final int times = 1;
        MaskDAOImpl maskDao = new MaskDAOImpl();
        assertTrue(maskDao.query(id, times));
    }

    //queryTel(String tel, int times)方法
    @Test
    public void testQueryTel() {
        final String tel = "13110513356";
        final int times = 1;
        MaskDAOImpl maskDao = new MaskDAOImpl();
        assertTrue(maskDao.queryTel(tel, times));
    }
}