package com.example.springboot.service;

import com.example.springboot.exception.ApiMsiException;
import com.example.springboot.exception.ApiRequestException;
import com.google.gson.Gson;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

public abstract class ExternalRESTService {

    private static final String UTF_8 = "UTF_8";
    private static final String MSI = "MSI";
    private static final String TIME_OUT = "timeout";
    private static Gson gson = new Gson();

    @Autowired
    private ApiMsiException apiMsiException;

    protected <Request, Response> Response CallREST(
                                            HttpMethod method,
                                            Request request,
                                            Class<Response> respType,
                                            Function<Object, String> toError){

        String hostUrl = getHostUrl(request, method);
        Integer timeout = getTimeOut();

        HttpUriRequest http = null;
        if(HttpMethod.GET == method) { http = buildGetRequest(hostUrl,timeout); }
        if(HttpMethod.POST == method){ http = buildPostRequest(hostUrl,timeout,request); }

        String resText = null;
        String errorMsg = null;
        Response response = null;

        try(CloseableHttpClient client = getREST(hostUrl);
            CloseableHttpResponse res = client.execute(http)){
            resText = EntityUtils.toString(res.getEntity());
            System.out.println(resText);
            errorMsg = toError.apply(res.getStatusLine());
            if (errorMsg == null){
                response = gson.fromJson(resText, respType);
            }else throw new ApiRequestException(errorMsg);
        } catch (ClientProtocolException e) {
            throw new ApiRequestException(e.getMessage());
        } catch (IOException e) {
            throw new ApiRequestException(e.getCause().toString());
        }
        return response;
    }


    protected HttpUriRequest buildGetRequest(String hostUrl, Integer timeout){
        HttpGet httpGet = new HttpGet();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .setAuthenticationEnabled(true)
                .build();
        return httpGet;
    }

    protected HttpUriRequest buildPostRequest(String hostUrl, Integer timeout, Object request){
        String reqText = gson.toJson(request);
        HttpPost httpPost = new HttpPost();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .setAuthenticationEnabled(true)
                .build();

        httpPost.setEntity(new StringEntity(reqText, UTF_8));
        httpPost.setConfig(config);
        return httpPost;
    }


    protected Integer getTimeOut(){
        Map<String,String> apiMsiConfig = apiMsiException.getConfigGroup(MSI);
        return apiMsiConfig.get(TIME_OUT) != null ?  Integer.parseInt(apiMsiConfig.get(TIME_OUT)):9000;
    }




    protected CloseableHttpClient getREST(String hostUrl){
        return HttpClients.createDefault();
    }



    protected abstract String getHostUrl(Object request, HttpMethod method);

}
