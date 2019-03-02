package com.pingyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pingyougou.mapper.TbBrandMapper;
import com.pingyougou.pojo.TbBrand;
import com.pingyougou.pojo.TbBrandExample;
import com.pingyougou.pojo.TbBrandExample.Criteria;
import com.pingyougou.sellergoods.service.BrandService;

import entity.PageResult;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private TbBrandMapper brandMapper;
	

	public List<TbBrand> findAll() {
		// TODO Auto-generated method stub
		return brandMapper.selectByExample(null);
	}


	
	public PageResult findPage(int pageNum, int pageSize) {
		//使用pageHelper插件
		PageHelper.startPage(pageNum, pageSize);
		//查询数据库
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
		
		return new PageResult(page.getTotal(),page.getResult());
	}



	public void add(TbBrand brand) {
		brandMapper.insert(brand);
	}



	@Override
	public TbBrand findOne(Long id) {
		// TODO Auto-generated method stub
		return brandMapper.selectByPrimaryKey(id);
	}



	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
		
	}



	@Override
	public void delete(Long[] ids) {
		//循环遍历数组的id
		for(Long id:ids) {
			brandMapper.deleteByPrimaryKey(id);
		}

	}


	@Override
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		//使用pageHelper插件
		PageHelper.startPage(pageNum, pageSize);
		
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if (brand != null) {
			if (brand.getName() != null && brand.getName().length() > 0) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0) {
				criteria.andFirstCharLike(brand.getFirstChar());
			}
		}
		
		
		//查询数据库
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
		
		return new PageResult(page.getTotal(),page.getResult());
		
	}

}
