package cn.edu.hdu.webbf.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * 系统配置信息工具类
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年8月2日
 * @see
 * @since webbf V1.0.0
 */

public class ProjectConfigUtil
{
    public static final String CONFIG_FILE_RELATIVE_PATH = "./config.properties";

    /**
     * 获取配置信息
     *
     * @return
     */
    public static Properties getConfig()
    {
        Properties p = getProperties(CONFIG_FILE_RELATIVE_PATH);
        return p;
    }

    /**
     * 获取classes路径
     *
     * @return
     */
    public static String getProjectClassesPath()
    {
        URL fileUrl = ProjectConfigUtil.class.getClassLoader().getResource("");
        String path = fileUrl.getPath();
        return path;
    }

    /**
     * 获取配置文件信息
     * 
     * @param relativePath
     * @return
     */
    public static Properties getProperties(String relativePath)
    {
        String filePath = null;
        if (relativePath.startsWith("./"))
            relativePath = relativePath.substring(2);
        else if (relativePath.startsWith("/") || relativePath.startsWith("."))
            relativePath = relativePath.substring(1);

        filePath = getProjectClassesPath() + relativePath;
        Properties properties = new Properties();
        FileInputStream in = null;
        try
        {
            in = new FileInputStream(filePath);
            properties.load(in);
            in.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("couldn't load properties file '" + filePath + "'", e);
        }
        return properties;
    }
}
