package org.huang.xiaozhiapp.service.impl;

import jakarta.annotation.Resource;
import org.huang.xiaozhiapp.bean.Appointment;
import org.huang.xiaozhiapp.mapper.AppointmentMapper;
import org.huang.xiaozhiapp.service.XiaozhiService;
import org.springframework.stereotype.Service;

@Service
public class XiaozhiServiceImpl implements XiaozhiService {
    
    @Resource
    private AppointmentMapper appointmentMapper;
    
    @Override
    public Appointment getAppointment(Appointment appointment) {
        return appointmentMapper.selectByAppointment(appointment);
    }
    
    @Override
    public int insertAppointment(Appointment appointment) {
        return appointmentMapper.insert(appointment);
    }
    
    @Override
    public int deleteAppointment(Appointment appointment) {
        return appointmentMapper.deleteByPrimaryKey(appointment);
    }
    
    
}
