package com.haowq.mult;

/**
 * @Auther: haowq
 * @Date: 2021/7/6 14:26
 * @Description:
 * 数据源切换处理类，有对数据源变量的获取、设置和情况的方法，其中threadlocal用于保存某个线程共享变量
 */
public class DynamicDataSourceContextHolder {
    /***
     * @description: 使用ThreadLocal维护变量，TThreadLocal为每个使用该变量的县城提供独立的变量副本，
     * 所以每一个线程都可以独立改变自己的副本，而不会影响其他线程所对应的副本
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();


    /*** 
     * @description: 设置数据源变量
     */
    public static void setDataSourceType(String dataSourceType) {
        System.out.printf("切换到{s%}数据源", dataSourceType);
        CONTEXT_HOLDER.set(dataSourceType);
    }

    /*** 
     * @description: 获取数据源变量
     */
    public static String getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }
}
