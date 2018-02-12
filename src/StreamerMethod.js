import { NativeModules } from 'react-native';

const { KSYStreamerModule } = NativeModules;
const {
  /* 开启摄像头预览 */
  startCameraPreview,
  /* 关闭摄像头预览 */
  stopCameraPreview,
  /* 切换摄像头 */
  switchCamera,
  /* 切换闪光灯 */
  toggleTorch,
  /* 开始推流 */
  startStream,
  /* 关闭推流 */
  stopStream,
  /*
   * 设置磨皮效果
   * 参数float 0 ~ 1
   */
  setGrindRatio,
  /*
   * 设置美白效果
   * 参数float 0 ~ 1
   */
  setWhitenRatio,
  /*
   * 设置红润效果
   * 参数float 0 ~ 1
   */
  setRuddyRatio,
  /* 混响设置 @params (int) i */
  setAudioReverbFilter,
  /* 变声设置 @params (int) i */
  setAudioEffectFilter,
  /* 升降调设置 @params (int) i */
  // setAudioKeyEffectFilter,
} = KSYStreamerModule;

export default {
  startCameraPreview,
  stopCameraPreview,
  switchCamera,
  toggleTorch,
  startStream,
  stopStream,
  setGrindRatio,
  setWhitenRatio,
  setRuddyRatio,
  setAudioReverbFilter,
  setAudioEffectFilter,
  // setAudioKeyEffectFilter,
}
