package com.rbbr.hemoglobin.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class SessionStuff {
    public void setSessionUserType(String userType, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userType", userType);
    }
}
