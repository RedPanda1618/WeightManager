package io.github.redpanda1618.weightmanager;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\'J\b\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\f"}, d2 = {"Lio/github/redpanda1618/weightmanager/UserDao;", "", "deleteAll", "", "get", "", "Lio/github/redpanda1618/weightmanager/User;", "size", "", "getAll", "insert", "user", "app_debug"})
public abstract interface UserDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    io.github.redpanda1618.weightmanager.User user);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM user_table LIMIT :size")
    public abstract java.util.List<io.github.redpanda1618.weightmanager.User> get(int size);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM user_table")
    public abstract int size();
    
    @androidx.room.Query(value = "DELETE FROM user_table")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM user_table")
    public abstract java.util.List<io.github.redpanda1618.weightmanager.User> getAll();
}