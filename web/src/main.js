import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store/store'
import './registerServiceWorker'

import NotificationService from './common/notification.service'
import ApiService from './common/api.service'

Vue.config.productionTip = false
ApiService.init()
NotificationService.init()

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
