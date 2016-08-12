package cn.edu.hdu.webbf.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年5月24日
 * @see
 * @since webbf V1.0.0
 */
public interface IDAOSupport<T>
{

    /**
     * 保存对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object save(String str, Object obj) throws Exception;

    /**
     * 修改对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws Exception;

    /**
     * 删除对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws Exception;

    /**
     * 查找对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForObject(String str, Object obj) throws Exception;

    /**
     * 查找对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public List<T> findForList(String statement, Map<String, Object> mapParam) throws Exception;

    /**
     * 查找对象封装成Map
     * 
     * @param s
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForMap(String sql, Object obj, String key, String value) throws Exception;

}
