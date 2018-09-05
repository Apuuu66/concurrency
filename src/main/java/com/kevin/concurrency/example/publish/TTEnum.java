package com.kevin.concurrency.example.publish;

/**
 * Created by Kevin on 2018/8/24.
 */
public class TTEnum {
    public static void main(String[] args) {
        DBConnection c1 = DataSourceEnum.DATASOURCE.getConnection();
        DBConnection c2 = DataSourceEnum.DATASOURCE.getConnection();
        if (c1 == c2) {
            System.out.println(123);
        }
    }
}
