export default class ValidationUtil {
  static getValidationState(value, success, warning, error) {
    const length = value.length;
    if (length > success) {
      return 'success';
    } else if (length > warning) {
      return 'warning';
    } else if (length > error) {
      return 'error';
    }
  }
}
