package org.example.chainofresponsibilitypattern;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AuthService {

   private static Map<String,Date> authMap = new ConcurrentHashMap<String, Date>();

    public static Date queryAuthInfo(String uid, String orderId) {
        return authMap.get(uid.concat(orderId));
    }

    public static void auth(String uid, String orderId) {
        authMap.put(uid.concat(orderId), new Date());
    }

}
