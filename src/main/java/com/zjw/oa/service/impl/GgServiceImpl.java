package com.zjw.oa.service.impl;

import com.zjw.oa.entity.Gsgg;
import com.zjw.oa.entity.Xmjd;
import com.zjw.oa.mapper.GgMapper;
import com.zjw.oa.service.GgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GgServiceImpl implements GgService {

    @Autowired
    private GgMapper ggMapper;

    @Override
    public List<Gsgg> getGgList() {
        return ggMapper.getGgList();
    }

    @Override
    public List<Xmjd> getxmList() {
        return ggMapper.getxmList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(Gsgg gsgg) {
        ggMapper.add(gsgg);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Gsgg gsgg) {
        ggMapper.delete(gsgg);
    }

}
