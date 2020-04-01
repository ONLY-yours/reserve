package com.example.reserve.base;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.reserve.R;
import com.example.reserve.utils.ActivityCollector;
import com.example.reserve.utils.ToastUtil;
import com.gyf.immersionbar.ImmersionBar;

/**
 * @auther: lijunjie
 * @createDate: 2020/1/29  18:24
 * @purpose：
 */
public abstract   class BaseActivity extends AppCompatActivity {

    public static final String TAG = "IDcard service up";
    //比对阈值，建议为0.82
    public static final double THRESHOLD = 0.82d;
    public static final int ACTION_REQUEST_PERMISSIONS = 0x001;
    // 在线激活所需的权限
    public static final String[] NEEDED_PERMISSIONS = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    public int displayOrientation = 0;

    //用于快速授权
    protected boolean checkPermissions(String[] neededPermissions) {
        if (neededPermissions == null || neededPermissions.length == 0) {
            return true;
        }
        boolean allGranted = true;
        for (String neededPermission : neededPermissions) {
            allGranted &= ContextCompat.checkSelfPermission(this, neededPermission) == PackageManager.PERMISSION_GRANTED;
        }
        return allGranted;
    }

    //用于快速启动活动
    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        //        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /**
     * 弹出界面提示内容
     *
     * @param msg 提示内容文字内容
     */
    public void showToast(String msg) {
        ToastUtil.toastShortShow(getApplication(), msg);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorNav)     //状态栏颜色，不写默认透明色\
                .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题
                .fitsSystemWindows(true)    //解决顶部状态栏重叠问题
//                .hideBar(BarHide.FLAG_HIDE_BAR)
                .init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.addActivity(this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(null != this.getCurrentFocus()){
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            assert mInputMethodManager != null;
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super .onTouchEvent(event);
    }

}
