import Vue from 'vue'
import Notifications from 'vue-notification';

const NotificationService = {
    init() {
        Vue.use(Notifications)
    },
    error(data, error) {
        let title = ''
        let text = ''

        if (error.data && error.data.id) {
            title = `<b>${error.status}:</b> ${error.data.id}`
            text = error.data.message
        } else {
            text = `<b>${error.status}:</b> ${error.statusText}`
        }

        data.$notify({
            group: 'system',
            position: 'top right',
            duration: 5000,
            title: title,
            text: text,
            type: 'error',
        });
    },
    success(data, title, text) {
        data.$notify({
            group: 'system',
            position: 'top right',
            duration: 5000,
            title: title,
            text: text,
            type: 'success',
        });
    },
    warning(data, title, text) {
        data.$notify({
            group: 'system',
            position: 'top right',
            duration: 5000,
            title: title,
            text: text,
            type: 'warning',
        });
    }
  };
  
export default NotificationService