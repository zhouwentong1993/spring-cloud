package com.wentong.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 自定义过滤器，可以实现鉴权、限流、异常请求拦截等操作。
 * pre	-3	ServletDetectionFilter	标记处理Servlet的类型
 * pre	-2	Servlet30WrapperFilter	包装HttpServletRequest请求
 * pre	-1	FormBodyWrapperFilter	包装请求体
 * route	1	DebugFilter	标记调试标志
 * route	5	PreDecorationFilter	处理请求上下文供后续使用
 * route	10	RibbonRoutingFilter	serviceId请求转发
 * route	100	SimpleHostRoutingFilter	url请求转发
 * route	500	SendForwardFilter	forward请求转发
 * post	0	SendErrorFilter	处理有错误的请求响应
 * post	1000	SendResponseFilter	处理正常的请求响应
 */
public class MyFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOGGER.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");// 获取请求的参数

        if (StringUtils.isNotBlank(token)) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(666);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
