# expo-server-sdk-java

一个强大、灵活的 Java Expo 推送通知服务端 SDK，专为开发者设计，支持同步推送与回执查询，易于集成和扩展。

---

✨ **特性**

- 🚀 支持 Expo 官方推送 API，兼容最新接口
- 🔒 安全的 HTTP 通信，基于 Apache HttpClient5
- 🧩 模块化设计，易于扩展和自定义
- 📦 支持自定义 HTTP 客户端与访问令牌
- 📝 详细的错误处理与日志输出
- 📱 适配移动端推送场景

---

## 📦 安装

Maven 项目中添加依赖：

```xml
<dependency>
    <groupId>io.github.flanchanxwo</groupId>
    <artifactId>expo-server-sdk-java</artifactId>
    <version>0.1.1</version>
</dependency>
```

<hr>
🚀 快速上手

1. 创建客户端

```java
ExpoPushNotificationClient client = ExpoPushNotificationClient.builder()
        .setHttpClient(HttpClients.createDefault())
        .setAccessToken("your-access-token") // 可选
        .build();
```

2. 发送推送通知

```java
PushNotification notification = new PushNotification(
        Arrays.asList("ExponentPushToken[xxxxxx]"),
        "Hello World!",
        "This is a test notification."
);

// 也可以使用构建器模式
PushNotification notification = PushNotification.builder()
        .to(Arrays.asList("ExponentPushToken[xxxxxx]"))
        .title("Hello World!")
        .body("This is a test notification.")
        .build();

client.sendPushNotifications(Arrays.asList(notification));
```

3. 查询推送回执

```java
client.getPushNotificationReceipts(Arrays.asList("receipt-id-1", "receipt-id-2"));
```

<hr>

## 📝 主要参数

| 参数名         | 类型                  | 说明                                                |
|-------------|---------------------|---------------------------------------------------|
| baseUri     | String              | Expo API 基础地址（默认值 "https://exp.host/--/api/v2/" ） |
| httpClient  | CloseableHttpClient | 自定义 HTTP 客户端                                      |
| accessToken | String              | Expo 访问令牌（可选）                                     |

<hr>

🎨 特色功能

错误处理：所有接口均抛出详细异常，便于定位问题
日志输出：集成 SLF4J，支持自定义日志实现
类型安全：基于 Jackson 自动序列化/反序列化

<hr>

🛠️ 进阶用法

自定义 HTTP 客户端
可传入自定义配置的 CloseableHttpClient，如设置代理、超时等。  
自定义 API 地址
支持自定义 baseUri，适配测试或代理环境。

<hr>

📋 支持的推送内容

标题、正文、数据 payload
多设备批量推送
自定义通知参数（如声音、优先级等）

<hr>

💡 使用建议

使用该SDK前请先阅读 Expo 官方文档，了解推送通知的基本概念和要求。\
https://docs.expo.dev/push-notifications/overview/ \
生产环境请妥善管理 accessToken
<hr>

📄 License
MIT License  