/*
 * Constant.java [V 1.0.0]
 * classes com.emcc.edp.ucenter.utls.Constant
 * 高炎  Creact 2015年7月13日 下午5:20:03
 */
package com.hollysys.hiadsp.common.util;

/**
 * com.emcc.edp.ucenter.utls.Constant
 * 
 * @author 高炎 <br/>
 *         Create at 2015年7月13日 下午5:20:03
 */
public interface Constant {
    
    
    /**
     * 配置文件名字
     */
    public final static String QUEUE_PROPERTIES = "queue.properties";
    
    
    /**
     * 爬虫编号标识
     */
    public final static String CRAWLER_NO = "em2_1";
//    public final static String CRAWLER_NO = "em2_2";
    
    /**
     * redis系统服务目标机
     */
    public final static String REMOVAL_SERVICE_IP = "192.168.66.189";
    /*redis系统服务端口*/
    public final static int REMOVAL_SERVICE_PORTS = 6379;
    /*redis文件*/
    public final static String REMOVAL_SERVICE_FILE = "/usr/local/crawler/redis/data-for-1.2.4/data/dictionary/stopwords.txt";
//    public final static String REMOVAL_SERVICE_FILE = "F:\\data-for-1.2.4\\data\\dictionary\\stopwords.txt";
    
    
    /**
     * 爬虫缓存默认路径
     */
    public final static String DEFAULT_DATA_PATH = "/usr/local/crawler/app/crawlCache/tempData";
    /* 爬虫缓存指定路径*/
    public final static String ASSING_DATA_PATH = "/crawlCache/tempData";
    /* 爬虫图片默认路径*/
    public final static String DEFAULT_IMAGE_PATH = "/usr/local/crawler/app/crawlCache/imageData";
    /* 爬虫图片指定路径*/
    public final static String ASSING_IMAGE_PATH = "/crawlCache/imageData";
    
    
    /**
     * 任务表数据是否在爬取的状态
     * 
     */
    public final static int TASK_STATUS_SLEEP = 1;// 待执行
    public final static int TASK_STATUS_RUNNING = 2;// 正在执行
    
    
    /**
     * 任务表数据事都在队列状态
     * 
     */
    public final static int TASK_STATUS_EXIST = 1;// 在队列
    public final static int TASK_STATUS_NO = 0;// 不在队列
    
    
    /**
     * 图片处理
     */
    public static final float QUALITY = 1.0f; // 压缩比率
    public static final int TINY_SIZE = 100; // 小图尺寸
    public static final int HEAD_SIZE = 100; // 小图尺寸
    public static final int ME_SIZE = 350; // 小图尺寸
    public static final int BIG_SIZE = 750; // 大图尺寸

    
    
    /**
     * 定义上传大小
     */
    public static final long IMAGE_SIZE = 5 * 1024 * 1024L;
    
    
    /**
     * 阿里云
     */
    public static final String ACCESS_ID = "tRRYbgu096Uqy1yR";
    public static final String ACCESS_KEY = "fkFVYW7gsD8NA36QqiE4wG53Y3k3iX";
//    public static final String OSS_ENDPOINT = "http://oss.aliyuncs.com/";
//    public static final String DEFAULT_BUCKETNAME = "changedig-crawler";
    public static final int IMG_MAX_WIDTH = 1080;//原图最大宽度
}
