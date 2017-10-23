package cn.com.systec.base;

import cn.com.systec.utility.CommonFunctions;
import cn.com.systec.utility.DbOperation;
import cn.com.systec.utility.Page;
import cn.com.systec.utility.QueryCondition;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Created by wh on 10/23/2017.
 */
public class BaseDao<T> {
    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private HibernateTemplate getHibernateTemplate() {
        return this.hibernateTemplate;
    }

    @SuppressWarnings("rawtypes")
    private Class getModelClass() {
        return entityClass;
    }

    @Transactional
    public Session getSession() {
        return getHibernateTemplate().getSessionFactory().getCurrentSession();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    // 单条记录操作
    /**
     * 增加记录
     * @param entity
     * @return
     */
    public Serializable doSaveObject(T entity) {
        // return getHibernateTemplate().save(entity);
        Serializable id = getHibernateTemplate().save(entity);

        if (id == null)
            throw new RuntimeException("");

        return id;
    }

    /**
     * 删除记录
     * @param entity
     */
    public void doDeleteObject(T entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * 保存记录
     * @param entity
     */
    public void doUpdateObject(T entity) {
        getHibernateTemplate().update(entity);
    }

    /**
     * 查找记录
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public T doFindObjectById(Serializable id) {
        return (T) getHibernateTemplate().get(getModelClass(), id);
    }



    // 批量记录操作
    /**
     * 批量保存或更新记录
     * @param entities
     */
    @SuppressWarnings("rawtypes")
    public void doSaveOrUpdateList(Collection entities){
        getHibernateTemplate().saveOrUpdateAll(entities);
    }


    /**
     * 批量删除记录
     * @param entities
     */
    @SuppressWarnings("rawtypes")
    public void doDeleteList(Collection entities) {
        getHibernateTemplate().deleteAll(entities);
    }

    /**
     * 根据HQL查询语句，批量更新或删除记录
     * @param queryString
     * @return
     */
    public int doBulkUpdateOrDeleteBySql(String queryString) {
        return getHibernateTemplate().bulkUpdate(queryString);
    }


    // 无分页记录操作
    /**
     * 无条件，无分页查询所有记录
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List doFindAll() {
        String queryString = "from " + getModelClass().getName();
        return getHibernateTemplate().find(queryString);
    }

    /**
     * 有条件、无分页等值查询（即properties列表中对应数据库字段记录与values列表值相等）
     * @param properties
     * @param values
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List doEqSearchObject(String[] properties, Object[] values) {
        Criteria criteria = getSession().createCriteria(getModelClass());

        if (properties == null) {
            return null;
        } else {
            for (int i = 0; i < properties.length; i++) {
                criteria.add(Restrictions.eq(properties[i], values[i]));
            }
        }

        return criteria.list();
    }

    /**
     * 有条件、无分页查询
     * @param conList
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List doSearchObject(List<Object[]> conList) {
        Criteria criteria = getSession().createCriteria(getModelClass());

        if (conList != null) {
            criteria = makeCriteria(criteria, conList);
        }

        return criteria.setCacheable(true).list();
    }

    // 有分页记录操作
    /***
     * 无条件、分页查询所有记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page doFindAllByPaging(int pageNum, int pageSize) {
        return new Page(
                pageNum,
                doCountObjectByConditions(null),
                pageSize,
                getHibernateTemplate().findByCriteria(
                        DetachedCriteria.forClass(getModelClass()), Page.getStartOfPage(pageNum, pageSize), pageSize));
    }

    /**
     * 有条件、分页等值查询
     * @param properties
     * @param values
     * @return
     */
    public Page doEqSearchObjectByPaging(int pageNum, int pageSize, String[] properties, Object[] values) {
        Criteria criteria = getSession().createCriteria(getModelClass());

        if (properties == null) {
            return new Page();
        } else {
            for (int i = 0; i < properties.length; i++) {
                criteria.add(Restrictions.eq(properties[i], values[i]));
            }
        }

        return new Page(
                pageNum,
                getRecordCount(criteria),
                pageSize,
                criteria.setFirstResult(Page.getStartOfPage(pageNum, pageSize)).setMaxResults(pageSize).list());
    }

    /**
     * 有条件、分页查询
     * @param pageNum
     * @param pageSize
     * @param conList <Object[]>
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Page doSearchObjectByPaging(int pageNum, int pageSize, List<Object[]> conList) {
        Criteria criteria = getSession().createCriteria(getModelClass());

        if (conList != null) {
            criteria = makeCriteria(criteria, conList);
        }

        List resultList = criteria.setCacheable(true).setFirstResult(Page.getStartOfPage(pageNum, pageSize)).setMaxResults(pageSize).list();
        List list = doSearchObject(conList);
        int totalRecord = 0;
        if(list != null && list.size() > 0) totalRecord = list.size();
        return new Page(
                pageNum,
                //totalRecord,
                doCountObjectByConditions(conList),
                //getRecordCount(criteria),
                pageSize,
                resultList);

    }

    /**
     * 有条件、分页查询
     * @param queryCondition
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Page doSearchObjectByConditions(QueryCondition queryCondition) {
        Page page = null;
//    	 page = doSearchObjectByPaging(
//               queryCondition.getPageNo(), queryCondition.getPageSize(), queryCondition.getConditions());
        if (CommonFunctions.isNull(queryCondition.getPageNo()) && CommonFunctions.isNull(queryCondition.getPageSize())) {
            // 未设置页码及页大小
            page = new Page();
            List resultList = doSearchObject(queryCondition.getConditions());

            page.setPageNum(1);
            page.setPageSize(1);
            page.setTotalRecord(resultList.size());
            page.setData(resultList);
        } else {
            page = doSearchObjectByPaging(
                    queryCondition.getPageNo(), queryCondition.getPageSize(), queryCondition.getConditions());
        }

        return page;
    }

    /**
     * 通过DetachedCriteria（离线查询，即在session外创建查询条件）有条件、分页查询
     * @param pageNum
     * @param pageSize
     * @param dCriteria
     * @return
     */
    @Deprecated
    public Page doSearchObjectByPaging(int pageNum, int pageSize, DetachedCriteria dCriteria) {
        return new Page(
                pageNum,
                getRecordCount(dCriteria.getExecutableCriteria(getSession())),
                pageSize,
                getHibernateTemplate().findByCriteria(dCriteria, Page.getStartOfPage(pageNum, pageSize), pageSize));
    }

    // 统计记录
    /**
     * 根据条件获取记录数量
     * @param criteria
     * @return
     */
    @SuppressWarnings("rawtypes")
    private int getRecordCount(Criteria criteria) {
        List list = criteria.setProjection(Projections.rowCount()).list();

        if (list.size() == 0) {
            return 0;
        } else {
            return (Integer) list.get(0);
        }
    }

    /**
     * 获得根据查询条件得到的对象个数
     * @param conList <Object[]>
     * @return
     */
    public int doCountObjectByConditions(List<Object[]> conList) {
        return getRecordCount(
                makeCriteria(
                        getSession().createCriteria(getModelClass()),
                        conList));
    }

    // 条件处理
    /**
     * 根据自定义条件数组，构造查询条件
     * @param criteria
     * @param conList
     */
    protected Criteria makeCriteria(Criteria criteria, List<Object[]> conList) {
        if (conList != null && conList.size() != 0 ) {
            for (int j = 0; j < conList.size(); j++) {
                Object[] obj = (Object[]) conList.get(j);

                if(DbOperation.ORDER.equals(obj[0])) {
                    // 排序
                    if(DbOperation.ASC.equalsIgnoreCase((String) obj[2])) {
                        criteria.addOrder(Order.asc((String) obj[1]));
                    }
                    else if(DbOperation.DESC.equalsIgnoreCase((String) obj[2])) {
                        criteria.addOrder(Order.desc((String) obj[1]));
                    }
                    else
                        throw new RuntimeException("Unsupport sort type. " + (String) obj[2]);
                }
                else if(DbOperation.JOIN.equals(obj[0])) {
                    // 连接
                    // obj[1] - 关联属性
                    // obj[2] - 别名
                    // obj[3] - 排序类型，0:INNER_JOIN，1:LEFT_JOIN，4:FULL_JOIN
                    criteria.createCriteria((String) obj[1], (String) obj[2], ((Integer) obj[3]).intValue());
                }else if (DbOperation.OR.equals(obj[0])) {
                    // 或条件
                    Criterion criterion = Restrictions.or(
                            toCritetion((Object[]) obj[1]), toCritetion((Object[]) obj[2]));

                    for (int i = 3; i < obj.length; i++) {
                        criterion = Restrictions.or(criterion, toCritetion((Object[]) obj[i]));
                    }

                    criteria.add(criterion);
                }
                else {
                    criteria.add(toCritetion(obj));
                }
            }
        }

        return criteria;
    }

    /**
     * 构造查询条件
     * @param obj
     * @return
     */
    @SuppressWarnings("rawtypes")
    protected Criterion toCritetion(Object[] obj) {
        Criterion criterion = null;

        if (DbOperation.EQ.equals(obj[0])) {
            criterion = Restrictions.eq((String) obj[1], obj[2]);
        }
        else if (DbOperation.NE.equals(obj[0])) {
            criterion = Restrictions.ne((String) obj[1], obj[2]);
        }
        else if (DbOperation.GE.equals(obj[0])) {
            criterion = Restrictions.ge((String) obj[1], obj[2]);
        }
        else if (DbOperation.LE.equals(obj[0])) {
            criterion = Restrictions.le((String) obj[1], obj[2]);
        }
        else if (DbOperation.GT.equals(obj[0])) {
            criterion = Restrictions.gt((String) obj[1], obj[2]);
        }
        else if (DbOperation.LT.equals(obj[0])) {
            criterion = Restrictions.lt((String) obj[1], obj[2]);
        }
        else if (DbOperation.LIKE.equals(obj[0])) {
            criterion = Restrictions.like((String) obj[1], obj[2]);
        }
        else if (DbOperation.UNLIKE.equals(obj[0])) {
            criterion = Restrictions.like((String) obj[1], obj[2]);
            criterion = Restrictions.not(criterion);
        }
        else if (DbOperation.IN.equals(obj[0])) {
            if (obj[2] instanceof List)
                criterion = Restrictions.in((String) obj[1], (List) obj[2]);
            else if (obj[2] instanceof Object[])
                criterion = Restrictions.in((String) obj[1], (Object[]) obj[2]);
            else
                throw new RuntimeException("Unsupported collection for IN operation.");
        }
        else if (DbOperation.NOTIN.equals(obj[0])) {
            if (obj[2] instanceof List)
                criterion = Restrictions.not(Restrictions.in((String) obj[1], (List) obj[2]));
            else if (obj[2] instanceof Object[])
                criterion = (Restrictions.not(Restrictions.in((String) obj[1], (Object[]) obj[2])));
            else
                throw new RuntimeException("Unsupported collection for NOT IN operation.");
        }
        else if (DbOperation.ISNULL.equals(obj[0])) {
            criterion = Restrictions.isNull((String) obj[1]);
        }
        else if (DbOperation.ISNOTNULL.equals(obj[0])) {
            criterion = Restrictions.isNotNull((String) obj[1]);
        }
        else if (DbOperation.ISEMPTY.equals(obj[0])) {
            criterion = Restrictions.isEmpty((String) obj[1]);
        }
        else if (DbOperation.ISNOTEMPTY.equals(obj[0])) {
            criterion = Restrictions.isNotEmpty((String) obj[1]);
        }
        else if (DbOperation.BETWEEN.equals(obj[0])) {
            criterion = (Restrictions.between((String) obj[1], new Date(Long.parseLong(obj[2].toString())), new Date(Long.parseLong(obj[3].toString()))));
        }
        else if (DbOperation.SQL.equals(obj[0])) {
            criterion = (Restrictions.sqlRestriction((String) obj[1]));
        }
        else
            throw new RuntimeException("Unsupported operation.");
        /*
        else if ("sql1".equals(obj[0])) {
            criterion = (Restrictions.sqlRestriction((String) obj[1], (Object) obj[2], (Type) obj[3]));
        }
        else if ("sqls".equals(obj[0])) {
            criterion = (Restrictions.sqlRestriction((String) obj[1], (Object[]) obj[2], (Type[]) obj[3]));
        }
        */

        return criterion;
    }

    // 计算记录
    /**
     * 根据查询条件对结果进行计算
     * @param conList
     * @param computeFieldList
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Object[] doComputeFields(List<Object[]> conList, List<String[]> computeFieldList) {
        Criteria criteria = getSession().createCriteria(getModelClass());
        criteria = makeCriteria(criteria, conList);

        Object[] result = null;

        if (criteria.list().size() != 0) {
            ProjectionList projectionList = Projections.projectionList();

            for(int i = 0; i < computeFieldList.size(); i++) {
                String[] computeCondition = computeFieldList.get(i);

                // obj[0] - 计算类型
                // obj[1-n] - 计算字段
                for (int k = 1; k < computeCondition.length; k++) {
                    if (DbOperation.SUM.equals(computeCondition[0])) {
                        projectionList.add(Projections.sum(computeCondition[k]));
                    }
                    else if (DbOperation.AVG.equals(computeCondition[0])) {
                        projectionList.add(Projections.avg(computeCondition[k]));
                    }
                    else if (DbOperation.MAX.equals(computeCondition[0])) {
                        projectionList.add(Projections.max(computeCondition[k]));
                    }
                    else if (DbOperation.MIN.equals(computeCondition[0])) {
                        projectionList.add(Projections.min(computeCondition[k]));
                    }
                    else if (DbOperation.COUNT.equals(computeCondition[0])) {
                        projectionList.add(Projections.count(computeCondition[k]), "originalAmount");
                    }
                    else if (DbOperation.COUNTDISTINCT.equals(computeCondition[0])) {
                        projectionList.add(Projections.countDistinct(computeCondition[k]));
                    }
                    else if (DbOperation.PROPERTY.equals(computeCondition[0])) {
                        projectionList.add(Projections.groupProperty(computeCondition[k]));
                    }
                    else if (DbOperation.GROUPBY.equals(computeCondition[0])) {
                        projectionList.add(Projections.groupProperty(computeCondition[k]));
                    }
                }
            }

            List list = criteria.setProjection(projectionList).list();

            result = (Object[]) list.get(0);
        }

        return result;
    }

    // SQL查询
    /**
     * 根据SQL查询语句进行查询
     * @param query sql语句
     * @param c 实体类对象
     * @return 返回list<c>
     */

    @SuppressWarnings("rawtypes")
    public List doSearchBySql(final String query,final Class c) {
        return getHibernateTemplate().executeFind(
                new HibernateCallback() {
                    public Object doInHibernate(Session session) {
                        try {
                            SQLQuery q = session.createSQLQuery(query);
                            q.addEntity(c);
                            return q.list();
                        }
                        catch (HibernateException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }

    // SQL查询
    /**
     * 根据SQL查询语句进行查询
     * @param query sql语句
     */

    @SuppressWarnings("rawtypes")
    public List doSearchBySqlString(final String query) {
        return getHibernateTemplate().executeFind(
                new HibernateCallback() {
                    public List doInHibernate(Session session) {
                        try {
                            Query q = session.createSQLQuery(query).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                            return q.list();
//                        return q.getQueryString();
                        }
                        catch (HibernateException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }

    /**
     * 根据查询语句进行查询 该方法经过测试发现实体类的字段需要和数据库字段完全一致才有用.
     * @param query  sql语句
     * @param c  实例化对象
     * @return
     */
    //该方法经过测试发现javabean的字段需要和数据字段完全一致才有用.
    @SuppressWarnings("rawtypes")
    public List doSearchBySqlToObjects(final String query, final Class c) {
        return getHibernateTemplate().executeFind(
                new HibernateCallback() {
                    public Object doInHibernate(Session session) {
                        try {
                            Query q = session.createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(c));
                    	/*Query q = session.createSQLQuery(query).addEntity(c);*/
                            return q.list();
                        }
                        catch (HibernateException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }

    //HQL查询
    /**
     * 根据查询语句进行查询
     * @param query
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List doSearchByHql(final String query) {
        return getHibernateTemplate().executeFind(
                new HibernateCallback() {
                    public Object doInHibernate(Session session) {
                        try {
                            Query q = session.createQuery(query);
                            return q.list();
                        }
                        catch (HibernateException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }

    /**
     * 根据更新语句进行更新
     * @param query
     * @return
     */
    public void doUpdateOrDeleteByHql(final String query) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query q = session.createQuery(query);
        q.executeUpdate();
    }
}
