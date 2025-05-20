package org.huang.xiaozhiapp;

import jakarta.annotation.Resource;
import org.huang.xiaozhiapp.bean.Appointment;
import org.huang.xiaozhiapp.service.XiaozhiService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentTest {
    @Resource
    private XiaozhiService xiaozhiService;
    
    @Test
    public void testGetAppointment() {
        String username = "李四";
        String idCard = "123456789012345678";
        var appointment = new Appointment();
        appointment.setUsername(username);
        appointment.setIdCard(idCard);
        var res = xiaozhiService.getAppointment(appointment);
        System.out.println(res);
    }
    
    @Test
    public void testInsertAppointment() {
        var appointment = new Appointment();
        appointment.setUsername("李四");
        appointment.setIdCard("123456789012345678");
        appointment.setDate("2025-10-01");
        appointment.setTime("上午");
        appointment.setDepartment("内科");
        appointment.setDoctorName("王医生");
        
        int result = xiaozhiService.insertAppointment(appointment);
        System.out.println(result > 0 ? "插入成功" : "插入失败");
    }
}
