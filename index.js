import {NativeModules, Platform} from 'react-native';

const {MhwAnalytics} = NativeModules;

class HwAnalytics {
    static initSDK = () => {
        if (Platform.OS === 'android') {
            MhwAnalytics.initSDK();
        }
    }

    static onEvent = (eventName, eventProperties) => {
        if (Platform.OS === 'android') {
            MhwAnalytics.onEvent(eventName, eventProperties);
        }
    }
}

export default HwAnalytics;