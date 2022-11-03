export default class HwAnalytics {
    /**
     * 初始化SDK
     * Android only
     */
    static initSDK(): void;

    /**
     * 记录事件
     * Android only
     * @param event 
     * @param data 
     */
    static onEvent(event: string, data: any): void;
}