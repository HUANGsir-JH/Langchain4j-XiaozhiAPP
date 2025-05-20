package org.huang.xiaozhiapp.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * appointment
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment implements Serializable {
    private Long id;

    private String username;

    private String idCard;

    private String department;

    private String date;

    private String time;

    private String doctorName;

    private static final long serialVersionUID = 1L;
}