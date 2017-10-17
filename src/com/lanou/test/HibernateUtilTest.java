package com.lanou.test;

import com.lanou.domain.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by dllo on 17/10/17.
 */
public class HibernateUtilTest {
    @Test
    public void findAll(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        // 查询学生表中的所有数据
        List<Student> students = session.createQuery("from Student ").list();
        // 遍历查询结果
        for (Student stu : students){
            System.out.println(stu);
        }
        transaction.commit();// 提交本次事务
        HibernateUtil.closeSession();// 关闭当前 session 对象
    }


}
