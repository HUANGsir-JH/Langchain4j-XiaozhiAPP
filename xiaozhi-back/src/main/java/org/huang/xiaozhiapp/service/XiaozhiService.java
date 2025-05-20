package org.huang.xiaozhiapp.service;


import org.huang.xiaozhiapp.bean.Appointment;

public interface XiaozhiService {

    Appointment getAppointment(Appointment appointment);
    
    int insertAppointment(Appointment appointment);
    
    int deleteAppointment(Appointment appointment);
}
