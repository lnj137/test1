package com.nj.dao;

import com.mysql.jdbc.PreparedStatement;
import com.nj.utils.JDBCUtils;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
/**
 * @author Li
 * @version 1.0
 * @date:2022-08-13 16:25
 */
public class BaseDao {

    public int update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count=0;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回一个PreparedStatement的实例
            ps = (PreparedStatement) conn.prepareStatement(sql);
            //3.填充占位符：？
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //4.执行
            count= ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.close(null,ps,conn);

        }

        return count;
    }


    /**
     * 通用的查询操作，返回表中的一条记录，封装为相应类的一个对象
     * @param clazz :返回的对象所属的类。比如：Customer
     * @param sql :包含占位符的查询语句
     * @param args ：填充占位符的实参值
     * @return clazz所对应的运行时类的一个对象
     */

    // 数据库的查询操作
    public <T> T queryForInstance(Class<T> clazz,String sql,Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回一个PreparedStatement的实例
            ps = (PreparedStatement) conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }

            //4.执行，返回一个结果集：ResultSet
            rs = ps.executeQuery();

            //5.处理结果集。(难点)
            //结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();//获取了结果集的列数
            //创建一个Class对应的运行时类的对象
            T t = clazz.newInstance();// new Customer(); id=0,nume=null,...

            if(rs.next()){
                for(int i = 0;i < columnCount;i++){
                    Object columnVal = rs.getObject(i + 1);//获取的具体列的列值

                    String columnLabel = rsmd.getColumnLabel(i + 1);//获取列的别名

                    //通过反射装配属性值给t对象
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnVal);

                }
                return t;
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //7.关闭资源
            JDBCUtils.close(rs, ps, conn);

        }
        return null;
    }
}
