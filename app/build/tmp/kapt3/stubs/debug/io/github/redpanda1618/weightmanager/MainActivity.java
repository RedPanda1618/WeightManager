package io.github.redpanda1618.weightmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0003J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lio/github/redpanda1618/weightmanager/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "size", "", "addData", "", "view", "Landroid/view/View;", "editData", "getDao", "Lio/github/redpanda1618/weightmanager/UserDao;", "getData", "Ljava/util/ArrayList;", "Lio/github/redpanda1618/weightmanager/User;", "Lkotlin/collections/ArrayList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "showData", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private int size = 10;
    @org.jetbrains.annotations.NotNull()
    private static final io.github.redpanda1618.weightmanager.MainActivity.Companion Companion = null;
    @java.lang.Deprecated()
    public static io.github.redpanda1618.weightmanager.UserRoomDatabase db;
    @java.lang.Deprecated()
    public static io.github.redpanda1618.weightmanager.UserDao dao;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    public final void addData(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void editData(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void showData() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    private final java.util.ArrayList<io.github.redpanda1618.weightmanager.User> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.github.redpanda1618.weightmanager.UserDao getDao() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lio/github/redpanda1618/weightmanager/MainActivity$Companion;", "", "()V", "dao", "Lio/github/redpanda1618/weightmanager/UserDao;", "getDao", "()Lio/github/redpanda1618/weightmanager/UserDao;", "setDao", "(Lio/github/redpanda1618/weightmanager/UserDao;)V", "db", "Lio/github/redpanda1618/weightmanager/UserRoomDatabase;", "getDb", "()Lio/github/redpanda1618/weightmanager/UserRoomDatabase;", "setDb", "(Lio/github/redpanda1618/weightmanager/UserRoomDatabase;)V", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final io.github.redpanda1618.weightmanager.UserRoomDatabase getDb() {
            return null;
        }
        
        public final void setDb(@org.jetbrains.annotations.NotNull()
        io.github.redpanda1618.weightmanager.UserRoomDatabase p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final io.github.redpanda1618.weightmanager.UserDao getDao() {
            return null;
        }
        
        public final void setDao(@org.jetbrains.annotations.NotNull()
        io.github.redpanda1618.weightmanager.UserDao p0) {
        }
    }
}