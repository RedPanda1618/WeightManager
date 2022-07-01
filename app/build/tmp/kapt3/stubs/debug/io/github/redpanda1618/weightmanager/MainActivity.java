package io.github.redpanda1618.weightmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lio/github/redpanda1618/weightmanager/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showData", "size", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final io.github.redpanda1618.weightmanager.MainActivity.Companion Companion = null;
    public static android.widget.EditText editTextName;
    public static android.widget.Button buttonUpdate;
    public static android.widget.ListView listViewNames;
    public static io.github.redpanda1618.weightmanager.UserRoomDatabase db;
    public static io.github.redpanda1618.weightmanager.UserDao dao;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.lang.Object showData(int size, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2 = {"Lio/github/redpanda1618/weightmanager/MainActivity$Companion;", "", "()V", "buttonUpdate", "Landroid/widget/Button;", "getButtonUpdate", "()Landroid/widget/Button;", "setButtonUpdate", "(Landroid/widget/Button;)V", "dao", "Lio/github/redpanda1618/weightmanager/UserDao;", "getDao", "()Lio/github/redpanda1618/weightmanager/UserDao;", "setDao", "(Lio/github/redpanda1618/weightmanager/UserDao;)V", "db", "Lio/github/redpanda1618/weightmanager/UserRoomDatabase;", "getDb", "()Lio/github/redpanda1618/weightmanager/UserRoomDatabase;", "setDb", "(Lio/github/redpanda1618/weightmanager/UserRoomDatabase;)V", "editTextName", "Landroid/widget/EditText;", "getEditTextName", "()Landroid/widget/EditText;", "setEditTextName", "(Landroid/widget/EditText;)V", "listViewNames", "Landroid/widget/ListView;", "getListViewNames", "()Landroid/widget/ListView;", "setListViewNames", "(Landroid/widget/ListView;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.EditText getEditTextName() {
            return null;
        }
        
        public final void setEditTextName(@org.jetbrains.annotations.NotNull()
        android.widget.EditText p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Button getButtonUpdate() {
            return null;
        }
        
        public final void setButtonUpdate(@org.jetbrains.annotations.NotNull()
        android.widget.Button p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ListView getListViewNames() {
            return null;
        }
        
        public final void setListViewNames(@org.jetbrains.annotations.NotNull()
        android.widget.ListView p0) {
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