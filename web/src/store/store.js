import Vue from 'vue'
import Vuex from 'vuex'

import auth from './user/auth.module'
import contact from './contact/contact.module'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    auth,
    contact
  }
})
