/**
 * 
 */
package cn.edu.hdu.webbf.core.servlet;

/**
 * 
 * 
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年6月30日
 * @see
 * @since webbf V1.0.0
 */

public class RelativeUrl
{
    private static final String INDEX = "index";
    private static final String INDEX_URL = "index.html";

    private static final String LOGIN = "login";
    private static final String LOGIN_URL = "login.html";

    private static final String USER = "user";
    private static final String USER_URL = "user.html";

    private static final String CHART = "chart";
    private static final String CHART_URL = "chartdemo.html";

    private static final String ANTDDEMO = "antddemo";
    private static final String ANTDDEMO_URL = "antddemo.html";

    /**
     * 
     * @param page
     * @return
     */
    public static String getPageUrl(String page)
    {
        if (page == null)
        {
            return INDEX_URL;
        }
        else if (page.equals(INDEX))
        {
            return INDEX_URL;
        }
        else if (page.equals(LOGIN))
        {
            return LOGIN_URL;
        }
        else if (page.equals(USER))
        {
            return USER_URL;
        }
        else if (page.equals(CHART))
        {
            return CHART_URL;
        }
        else if (page.equals(ANTDDEMO))
        {
            return ANTDDEMO_URL;
        }
        else
        {
            return INDEX_URL;
        }

    }

    /**
     * 
     * @param page
     * @return
     */
    public static String getPublicPageUrl(String page)
    {
        String url = INDEX_URL;
        if (page == null)
            return INDEX_URL;
        switch (page)
        {
        case INDEX:
            url = INDEX_URL;
            break;
        default:
            url = LOGIN_URL;
            break;
        }
        return url;
    }
}
