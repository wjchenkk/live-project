package dao;

import pojo.Reservation;

public interface MaskDAO {
	void add(Reservation user); //向数据库添加预约对象
    	void update(int id,String status); //输入预约编号和中奖状态，更新预约对象的中奖情况
   	Reservation list(int id);  //输入预约编号返回要查询的预约对象的数据
    	boolean query(String id,int times);//输入身份证号和当前轮数，判断是否有报名
    	boolean queryTel(String tel,int times);//输入手机号和当前轮数，判断是否有报名
}
