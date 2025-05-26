# expo-server-sdk-java

A powerful and flexible Java SDK for Expo push notifications, designed for developers. Supports both sending
notifications and querying receipts. Easy to integrate and extend.

**Language: [简体中文(Chinese)](readme_zh.md)**

---

✨ **Features**

- 🚀 Supports Expo official push API, compatible with the latest interfaces
- 🔒 Secure HTTP communication using Apache HttpClient5
- 🧩 Modular design for easy extension and customization
- 📦 Supports custom HTTP clients and access tokens
- 📝 Detailed error handling and logging
- 📱 Optimized for mobile push notification scenarios

---

## 📦 Installation

Add the dependency in your Maven project:

```xml

<dependency>
    <groupId>com.github.flanchanowo</groupId>
    <artifactId>expo-server-sdk-java</artifactId>
    <version>0.1.0</version>
</dependency>
```

🚀 Quick Start

1. Create the client

```java
import com.github.flanchanowo.ExpoPushNotificationClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

ExpoPushNotificationClient client = ExpoPushNotificationClient.builder()
        .setHttpClient(HttpClients.createDefault())
        .setAccessToken("your-access-token") // optional
        .build();
```

2. Send a push notification

```java
import com.github.flanchanowo.request.PushNotification;

import java.util.Arrays;

PushNotification notification = new PushNotification(
        Arrays.asList("ExponentPushToken[xxxxxx]"),
        "Hello World!",
        "This is a test notification."
);

client.

sendPushNotifications(Arrays.asList(notification));
```

3. Query push receipts

```java
import java.util.Arrays;

client.getPushNotificationReceipts(Arrays.asList("receipt-id-1", "receipt-id-2"));
```

## 📝 Key Parameters

| Parameter   | Type                | Description                                                     |
|-------------|---------------------|-----------------------------------------------------------------|
| baseUri     | String              | Base URL of the Expo API (default: https://exp.host/--/api/v2/) |
| httpClient  | CloseableHttpClient | CloseableHttpClient	Custom HTTP client                          |
| accessToken | String              | Expo access token (optional)                                    |

🎨 Highlighted Features

Error Handling: All APIs throw detailed exceptions for easier debugging
Logging: Integrated with SLF4J; supports custom logging implementations
Type Safety: Uses Jackson for automatic serialization/deserialization

🛠️ Advanced Usage

Custom HTTP Client
You can provide a custom-configured CloseableHttpClient (e.g., proxy, timeouts).
Custom API Base URL
You can customize the baseUri to fit test or proxy environments.

📋 Supported Notification Content

Title, body, and data payload
Batch push to multiple devices
Custom notification parameters (e.g., sound, priority, etc.)

💡 Recommendations

Before using this SDK, please read the official Expo documentation to understand the basics of push notifications.
Make sure to manage your accessToken securely in production environments.