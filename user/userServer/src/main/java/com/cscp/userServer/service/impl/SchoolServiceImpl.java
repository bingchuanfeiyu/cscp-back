package com.cscp.userServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cscp.common.utils.GridRequest;
import com.cscp.common.utils.GridResponse;
import com.cscp.common.utils.GridService;
import com.cscp.common.utils.ViewException;
import com.cscp.userServer.dao.entity.School;
import com.cscp.userServer.dao.mapper.SchoolMapper;
import com.cscp.userServer.service.ISchoolService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 学校 服务实现类
 * </p>
 *
 * @author ckz
 * @since 2020-01-02
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {
    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public GridResponse<School> get(GridRequest gridRequest) {
        return new GridService<School>().getGridResponse(schoolMapper, gridRequest);
    }

    @Override
    public void post(School school) {
        if(StringUtils.isEmpty(school.getName())){
            throw  new ViewException("school name should not be null");
        }
        if(!CollectionUtils.isEmpty(schoolMapper.selectList(new QueryWrapper<School>().eq("name",school.getName())))){
            throw new ViewException("this school already exist");
        }
        save(school);
    }

    @Override
    public void put(School school) {
        updateById(school);
    }

    @Override
    public void delete(List<String> ids) {
        removeByIds(ids);
    }
}
