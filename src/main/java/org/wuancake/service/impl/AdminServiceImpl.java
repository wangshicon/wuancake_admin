package org.wuancake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuancake.dao.AdminMapper;
import org.wuancake.entity.*;
import org.wuancake.service.IAdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public void addTutor(TutorBean tutor) {

        adminMapper.addTutor(tutor);
    }

    @Override
    public TutorBean findTutorByEmail(String email) {
        return adminMapper.findTutorByEmail(email);
    }

    @Override
    public void addAdmin(AdminBean adminBean) {
        adminMapper.addAdmin(adminBean);
    }

    @Override
    public Integer queryAllUserNumBeKicked() {
        return adminMapper.queryAllUserNumBeKicked();
    }

    @Override
    public AdminBean findAdminByEmail(String email) {
        return adminMapper.findAdminByEmail(email);
    }

    @Override
    public void updatePwd(Integer id, String generate) {
        adminMapper.updatePwd(id, generate);
    }

    @Override
    public List<KickBean> queryUserListBeKicked(Integer startIndex, Integer pageSize) {
        return adminMapper.queryUserListBeKicked(startIndex, pageSize);
    }
}
