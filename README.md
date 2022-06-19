# react-native-mHw-Analytics

[![npm version](https://badge.fury.io/js/react-native-mhw-analytics.svg)](https://badge.fury.io/js/react-native-mhw-analytics)

华为分析服务，目前业务需要只做到android初始化

## 安装

```sh
npm i react-native-mhw-analytics -E
```

## 集成

1. 参考 [https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/android-integrating-sdk-0000001050161876](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/android-integrating-sdk-0000001050161876) 文档集成
2. 打开 android/app/build.gradle ，在 defaultConfig 下添加:

```js
manifestPlaceholders = [
    HW_APP_CHANNEL: "普通", //华为统计SDK渠道
]
```

## 使用

 在 `MainApplication` 的 onCreate 中添加下方初始化代码，注意隐私合规协议后

```java

// 华为Analytics SDK初始化
MhwAnalyticsModule.setAccessNetwork();
MhwAnalyticsModule.initializeSDK(this);

```

## License

MIT
