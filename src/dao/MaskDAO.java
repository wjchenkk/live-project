package dao;

import pojo.Reservation;

public interface MaskDAO {
	void add(Reservation user); //添加
    void update(int id,String status); //更新中标状态
    Reservation[] list(String id);  //获取最近0-3次预约
    Reservation[] getList(int times);//获取预约轮次中的所有预约记录
    boolean query(String id,int times);//判断单次预约轮次预约有且仅有一次成功
    boolean queryTel(String tel,int times);//判断单次预约轮次预约有且仅有一次成功
    Reservation get(int getNumber);//获取单条记录
    Reservation get(String id,int times);//获取单条记录
}
