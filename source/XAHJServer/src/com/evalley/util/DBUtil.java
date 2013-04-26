/*
 * Created on 12-9-14
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Copyright @2012 the original author or authors.
 */
package com.evalley.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Description of this file.
 * User: Xiong Neng
 * Date: 12-9-14
 * Time: 上午11:25
 */
public class DBUtil {
    private static Connection conn = null;
    private static Statement stmt;
    private static PreparedStatement pstmt = null;
    private static String url = "", driver = "", userName = "", password = "";

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        url = bundle.getString("jdbc.url");
        driver = bundle.getString("jdbc.driverClassName");
        userName = bundle.getString("jdbc.username");
        password = bundle.getString("jdbc.password");
    }

    public DBUtil() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
