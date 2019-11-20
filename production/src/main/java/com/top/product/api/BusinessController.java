/**
 * Copyright(c) Runsdata Technology Co.,Ltd.
 * All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Runsdata
 * Technology Co.,Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Runsdata Technology Co.,Ltd.
 * For more information about Runsdata, welcome to http://www.runsdata.com
 * <p>
 * project: production
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/11/5 1.0          vae          Creation File
 */

package com.top.product.api;

import com.top.util.HttpResponse;
import com.top.util.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/11/5 21:44
 */
@RestController
public class BusinessController {

    Logger logger = LoggerFactory.getLogger(getClass());
    private static final String URL_PREFIX = "/api/admin/business/export";

    // private final BusinessExportService businessExportService;

    //注入Service层
/*    @Autowired
    public BusinessExportController(BusinessExportService businessExportService) {
        this.businessExportService = businessExportService;
    }*/

    @GetMapping(URL_PREFIX)
    public HttpResponse getBusinessExportDownloadUrl(Authentication authentication/*, @Validated WebBusinessQueryDto webBusinessQueryDto*/) {
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();
        Long userId = userEntity.getUserId();
        if (logger.isDebugEnabled()) {
            logger.debug("Request /api/admin/business/export [Get]. Current user is {}", userId);
        }
        return new HttpResponse<String>().setData("");
        /*businessExportService.exportBusinessByType(userId, webBusinessQueryDto)*/
    }
}

