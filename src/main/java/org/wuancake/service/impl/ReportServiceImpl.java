package org.wuancake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuancake.dao.ReportMapper;
import org.wuancake.entity.GatherBean;
import org.wuancake.entity.ReportBean;
import org.wuancake.service.IReportService;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<GatherBean> queryByGroupId(Integer groupId, Integer startIndex, Integer pageSize) {
        return reportMapper.queryByGroupId(groupId, startIndex, pageSize);
    }

    @Override
    public List<ReportBean> queryReportStatus(Integer userId, Integer maxWeekNum) {
        return reportMapper.queryReportStatus(userId, maxWeekNum);
    }

    @Override
    public List<GatherBean> queryAll(Integer startIndex, Integer pageSize) {
        return reportMapper.queryAll(startIndex, pageSize);
    }
}
