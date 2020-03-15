package test;

import org.junit.*;
import pojo.Reservation;

/**
 * testReservation
 */
public class testReservation extends junit.framework.TestCase {

    @Test 
	public void testRegistration() {
        final int reserveNum1 = 1;
        final String name1 = "张三";
        final String ID1 = "62010419980911027X";
        final String tel1 = "13110513356";
        final int number1 = 10000;
        final int status1 = 0;
        final int winningNum1 = 213;
        final String updateTel1 = "13919347896";

        //测试带全部参数的构造函数
        Reservation reservation1 = new Reservation(reserveNum1,
            name1, ID1, tel1, number1, status1, winningNum1); 
        //测试 setandget       
        assertEquals(name1, reservation1.getName());       
        reservation1.setTel(updateTel1);
        assertEquals(updateTel1, reservation1.getTel());

        final int reserveNum2 = 1;
        final String name2 = "李四";
        final String ID2 = "620104199809111134";
        final String tel2 = "18259317408";
        final int number2 = 99;

        //测试不带 "status" 和 "winningNum" 的构造函数
        Reservation reservation2 = new Reservation(reserveNum2,
            name2, ID2, tel2, number2);
        assertEquals(0, reservation2.getStatus());
        assertEquals(0, reservation2.getWinningNum());
    }    
}