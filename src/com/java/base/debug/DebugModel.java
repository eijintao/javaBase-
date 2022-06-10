package com.java.base.debug;

/**
 * asus 梅锦涛
 * 2022/5/22
 *
 * @author mjt
 */
public class DebugModel {

    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DebugModel{" +
                "userId=" + userId +
                '}';
    }
}
