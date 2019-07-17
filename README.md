# 重新学习 Spring Cloud 相关知识，代码实战。

主要包括 zuul、eureka、consul、config、zipkin 等，所有服务注册到注册中心，zuul 负责扫描服务的特征，作为 API 网关入口。统一网关入口可以做很多事情，比如统一校验、异常请求拦截、token 校验、流量控制等。注册中心可选 eureka、consul 和 Nacos，consul 和 Nacos 是独立的软件，eureka 是程序。config 可以通过在 git、svn 等配置的方式来打到和本地配置分离的效果，如果有需要，还可以通过 bus 来将变更的数据实时通知到程序中，zipkin 可以用来对程序监控，通过统一的拦截，比如对数据库、Redis、远程接口等监控，配合 Sleuth 能够更好地展示。
