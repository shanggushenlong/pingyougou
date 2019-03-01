package com.pingyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌接口
 * @author wuchaoqun
 *
 */
public interface BrandService {
	
	public List<TbBrand> findAll();
	
	/**
	 * 返回品牌分页结果
	 * @param pageNum 当前页码数
	 * @param pageSize 当前页的记录数
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	/**
	 * 新增商品
	 * @param brand
	 */
	public void add(TbBrand brand);
	
	/**
	 * 根据ID查询商品实体
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);
	
	/**
	 * 商品修改
	 * @param brand
	 */
	public void update(TbBrand brand);
	
	/**
	 * 商品删除
	 * @param ids 商品id
	 */
	public void delete(Long[] ids);
	
	/**
	 * 返回品牌分页结果
	 * @param pageNum 当前页码数
	 * @param pageSize 当前页的记录数
	 * @return
	 */
	public PageResult findPage(TbBrand brand,int pageNum,int pageSize);
}
