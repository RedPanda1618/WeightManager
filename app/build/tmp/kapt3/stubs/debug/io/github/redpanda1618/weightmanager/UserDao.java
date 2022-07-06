package io.github.redpanda1618.weightmanager;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\'\u00a8\u0006\u000b"}, d2 = {"Lio/github/redpanda1618/weightmanager/UserDao;", "", "get", "Lio/reactivex/Flowable;", "", "Lio/github/redpanda1618/weightmanager/User;", "size", "", "insert", "", "user", "app_debug"})
public abstract interface UserDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    io.github.redpanda1618.weightmanager.User user);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM user_table LIMIT :size")
    public abstract io.reactivex.Flowable<java.util.List<io.github.redpanda1618.weightmanager.User>> get(int size);
}