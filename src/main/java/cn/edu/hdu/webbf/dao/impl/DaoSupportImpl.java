package cn.edu.hdu.webbf.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.hdu.webbf.dao.IDAOSupport;

/**
 * 
 * 
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年5月24日
 * @see
 * @since webbf V1.0.0
 */
@Repository
public class DaoSupportImpl<T> implements IDAOSupport<T>
{

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 保存对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object save(String str, Object obj) throws Exception
    {
        return sqlSessionTemplate.insert(str, obj);
    }

    /**
     * 批量更新
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object batchSave(String str, List<T> objs) throws Exception
    {
        return sqlSessionTemplate.insert(str, objs);
    }

    /**
     * 修改对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws Exception
    {
        return sqlSessionTemplate.update(str, obj);
    }

    /**
     * 批量更新
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public void batchUpdate(String str, List<T> objs) throws Exception
    {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        // 批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try
        {
            if (objs != null)
            {
                for (int i = 0, size = objs.size(); i < size; i++)
                {
                    sqlSession.update(str, objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
        finally
        {
            sqlSession.close();
        }
    }

    /**
     * 批量更新
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object batchDelete(String str, List<T> objs) throws Exception
    {
        return sqlSessionTemplate.delete(str, objs);
    }

    /**
     * 删除对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws Exception
    {
        return sqlSessionTemplate.delete(str, obj);
    }

    /**
     * 查找对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForObject(String str, Object obj) throws Exception
    {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    /**
     * 查找对象
     * 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public List<T> findForList(String statement, Map<String, Object> mapParam) throws Exception
    {
        return sqlSessionTemplate.selectList(statement, mapParam);
    }

    public Object findForMap(String str, Object obj, String key, String value) throws Exception
    {
        return sqlSessionTemplate.selectMap(str, obj, key);
    }

}
