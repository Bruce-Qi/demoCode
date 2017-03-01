package wwtao.demo.demo_activityrouter.utils;

import com.alibaba.android.arouter.facade.template.IProvider;

import android.content.Context;

/**
 * Created by wangweitao04 on 17/2/27.
 */

public interface CustomToast extends IProvider {
    void showToast(String content);
}
