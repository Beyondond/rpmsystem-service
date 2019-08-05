package cn.com.dhc.rpmsystem.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhouyongzhou
 * @description log工具类
 * @date 2019/8/1
 */
public class LogUtils {

    /**
     * info级日志
     *
     * @param clazz
     * @param log
     */
    public static void info(Class<?> clazz, String log) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(log);
    }

    /**
     * warn级日志
     *
     * @param clazz
     * @param log
     */
    public static void warn(Class<?> clazz, String log) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.warn(log);
    }

    /**
     * error级日志
     *
     * @param clazz
     * @param log
     */
    public static void error(Class<?> clazz, String log) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(log);
    }

    /**
     * debug级日志
     *
     * @param clazz
     * @param log
     */
    public static void debug(Class<?> clazz, String log) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.debug(log);
    }

}
