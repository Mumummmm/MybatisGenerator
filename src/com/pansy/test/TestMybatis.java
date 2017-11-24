package com.pansy.test;

import com.pansy.mapper.CategoryMapper;
import com.pansy.pojo.Category;
import com.pansy.pojo.CategoryExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        CategoryExample example = new CategoryExample();
        example.createCriteria().andNameLike("%9%");
        List<Category> categories = categoryMapper.selectByExample(example);
        for (Category c : categories)
            System.out.println(c.getName());
    }
}
