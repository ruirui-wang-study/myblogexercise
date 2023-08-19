package com.wrr.service.impl;

import com.wrr.entity.Category;
import com.wrr.entity.Tag;
import com.wrr.mapper.TagMapper;
import com.wrr.api.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wrr
 * @since 2021-05-26
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Override
    public List<Tag> listTagPage(Integer current, Integer size, String tagName) {
        //分页转码处理
        current=(current-1)*size;
        List<Tag> tagList=this.baseMapper.listTagPage(current,size,tagName);

//        System.out.println(title+articleList);
        if(tagList.size()<=0){
            return null;
        }

        return tagList;
    }
}
