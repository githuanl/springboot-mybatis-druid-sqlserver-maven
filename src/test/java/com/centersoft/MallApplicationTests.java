package com.centersoft;

import com.alibaba.fastjson.JSON;
import com.centersoft.entity.City;
import com.centersoft.entity.CityMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	CityMapper cityMapper;


	@Test
	public void contextLoads() {
		// 传统方法
//		String  sql  =   "SELECT * FROM " + "city" +";";
//		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//		System.out.println("-------------"+list);

//		System.out.println("-------------"+ JSON.toJSONString(cityMapper.queryAll()));

		City city = new City();
		city.setName("北京");
		cityMapper.save(city);

		//分页插件: 查询第1页，每页10行
		Page<City> page = PageHelper.startPage(3, 10);
		cityMapper.findAll();
		//数据表的总行数
		page.getTotal();

		System.out.println("-------------"+ page.getTotal());
		//分页查询结果的总行数
		page.size();
		//第一个User对象，参考list，序号0是第一个元素，依此类推
		page.get(0);


		System.out.println("----------size---"+ page.size() + "--- > Total" + page.getTotal() + "--- >" + JSON.toJSONString(page.toArray()) );

	}

}
