package edu.fosu.common.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;


/**
 */
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T>,InsertListMapper<T>,ConditionMapper<T>
{
}