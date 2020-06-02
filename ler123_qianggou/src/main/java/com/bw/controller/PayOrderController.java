package com.bw.controller;

import com.bw.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RequestMapping("/alipay")
@Controller
public class PayOrderController {

    @Autowired
    private OrderInfoService orderService;
    @RequestMapping("/update_order")
    @ResponseBody
    public String updateOrder(HttpServletRequest request) {
        //商户订单号，商户网站订单系统中唯一订单号，必填
        try {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            System.out.println(out_trade_no);
            Boolean flag = this.orderService.updateOrder(out_trade_no);
            if(flag) {
                return "success";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "fail";
    }
}
