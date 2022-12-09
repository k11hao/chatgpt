package cn.oyjg;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenResponseBody;
import com.aliyun.teaopenapi.models.Config;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 阳建国
 * @since 2021/4/11/011 15:13
 **/
public class AccessTokenUtils {

    public static TimedCache<String, String> accessTokenTimedCache;
    private static final String ACCESS_TOKEN = "accessToken";

    private static TimedCache<String, String> getAccessTokenTimedCache(String appKey, String appSecret) throws Exception {
        if (accessTokenTimedCache == null || StringUtils.isEmpty(accessTokenTimedCache.get(getCacheKey(appKey)))) {
            synchronized (AccessTokenUtils.class) {
                if (accessTokenTimedCache == null || StringUtils.isEmpty(accessTokenTimedCache.get(getCacheKey(appKey)))) {
                    Config config = new Config();
                    config.protocol = "https";
                    config.regionId = "central";
                    com.aliyun.dingtalkoauth2_1_0.Client client = new com.aliyun.dingtalkoauth2_1_0.Client(config);
                    GetAccessTokenRequest getAccessTokenRequest = new GetAccessTokenRequest()
                            .setAppKey(appKey)
                            .setAppSecret(appSecret);
                    GetAccessTokenResponseBody response = client.getAccessToken(getAccessTokenRequest).getBody();
                    accessTokenTimedCache = CacheUtil.newTimedCache((response.getExpireIn() - 60) * 1000);
                    accessTokenTimedCache.put(getCacheKey(appKey), response.getAccessToken());
                }
            }
        }
        return accessTokenTimedCache;
    }

    public static String getAccessToken(String appKey, String appSecret) throws Exception {
        return getAccessTokenTimedCache(appKey, appSecret).get(getCacheKey(appKey));
    }

    private static String getCacheKey(String appKey){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ACCESS_TOKEN).append("_").append(appKey);
        return stringBuilder.toString();
    }

}
