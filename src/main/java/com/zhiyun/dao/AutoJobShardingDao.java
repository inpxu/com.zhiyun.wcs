package com.zhiyun.dao;

import com.zhiyun.entity.SinglePathSet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-07 15:49
 */
@Repository
public interface AutoJobShardingDao {
    /**
     * 通过起点终点id查询出所有的单路径
     *
     * @param param
     * @return void
     * @author 邓艺
     * @date 2018/9/7 15:53
     */
    List<SinglePathSet> queryAllPath(Map<String, Object> param);
}
