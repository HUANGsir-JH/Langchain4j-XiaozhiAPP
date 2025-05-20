package org.huang.xiaozhiapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.huang.xiaozhiapp.bean.Appointment;

@Mapper
public interface AppointmentMapper {
    int deleteByPrimaryKey(Appointment record);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);
    
    Appointment selectByAppointment(Appointment appointment);
}