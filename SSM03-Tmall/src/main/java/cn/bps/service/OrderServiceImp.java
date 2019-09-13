package cn.bps.service;


import cn.bps.mapper.OrderMapper;
import cn.bps.pojo.Order;
import cn.bps.util.OrderCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderMapper orderMapper;



    @Override
    public int generatorOrder(int userId) {

        Order order = new Order();

        String orderCode = OrderCode.getOrderCode();
        order.setOrder_code(orderCode);

        order.setUser_id(userId);

        Date now = new Date();
        java.sql.Date sqlNow = new java.sql.Date(now.getTime());

        order.setCreate_date(sqlNow);

        order.setStatus("未提交");



        return orderMapper.insertSelective(order);
    }
}
