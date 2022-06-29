export default class HwAnalytics {
    /**
     * 记录事件
     * Android only
     * @param event 
     * @param data 
     */
    onEvent(event: string, data: any): void;
}