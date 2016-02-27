package com.jzhihui.mmmouzhe.utils;

/**
 * Created by 程 on 2016/1/26.
 * 管理接口的类
 */
public class ConstantUtils {

    /**
     * 服务器地址
     */
    public static final String SERVER_URL = "http://www.jzhihui.com/mz/";
    /**
     * 用户登录的接口
     */
    public static final String LOGIN_URL = SERVER_URL + "index.php?g=Member&m=Public&a=doLogin&app=1";
    /**
     * 用户注册的接口
     */
    public static final String REGIST_URL = SERVER_URL + "index.php?g=Member&m=Public&a=doRegister&app=1";
}
