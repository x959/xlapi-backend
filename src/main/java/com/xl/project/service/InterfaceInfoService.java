package com.xl.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xl.project.model.entity.InterfaceInfo;

/**
* @author xl
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-06-21 12:50:09
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
