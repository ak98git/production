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
 * 2019/10/15 1.0          vae          Creation File
 */

package com.top.common.thirdparty;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.top.utils.Base64;
import com.top.utils.LogUtil;

import java.util.UUID;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/15 22:59
 */
public class QiniuUploadImgUtil {

    /**
     * 设置需要操作账号的AK和SK
     */
    private static final String ACCESS_KEY = "Z3S-J9Ppl2yll9DZengAnipOP4davSDQ9UQfv_RV";
    private static final String SECRET_KEY = "8zq4OtEJdSCrs1s8eaNTTM0UZ0zjLdvXVJRBWQyo";
    /**
     * 要上传的空间
     */
    private static final String BUCKET_NAME = "productapi";

    /**
     * 构造一个带指定 Region 对象的配置类
     * Zone.zone0 华东机房
     * Zone.zone1 华北机房
     * Zone.zone2 华南机房
     */
    private static Configuration cfg = new Configuration(Zone.zone2());
    private static UploadManager uploadManager = new UploadManager(cfg);

    /**
     * 七牛云服务器
     * 访问域名
     */
    private static final String VISIT_PATH = "px45uxsff.bkt.clouddn.com/";

    /**
     * 上传图片到七牛云
     *
     * @param imageAlias   图片别名,标识上传的是那个图片，记日志
     * @param base64String 图片转base64后的字符串
     * @return 七牛云的图片地址
     */
    public static String uploadImageToQiniu(String imageAlias, String base64String) {

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = UUID.randomUUID().toString().replace("-", "") + ".jpg";
        try {
            base64String = base64String.replaceAll("[\\t\\n\\r]", "");
            byte[] uploadBytes = Base64.decode(base64String);
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKET_NAME);

            Response response = uploadManager.put(uploadBytes, key, upToken);
            LogUtil.logger.info("statuscode={}, error={}", response.statusCode, response.error);
            if (response.statusCode == 200) {
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return VISIT_PATH + putRet.key;
            }
        } catch (Exception ex) {
            LogUtil.logger.info("{}，uploadImageToQiniu error={}", imageAlias, ex.getMessage());
        }
        return null;
    }
}

