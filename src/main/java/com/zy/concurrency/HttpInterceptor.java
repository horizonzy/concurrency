package com.zy.concurrency;

import com.zy.concurrency.example.threadlocal.RequestHolder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by Horizon Time: 下午4:52 2018/11/11 Description:
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        log.info("preHandle , {}", Thread.currentThread().getId());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, @Nullable Exception ex) throws Exception {
        RequestHolder.remove();
        log.info("afterCompletion");
    }

}
