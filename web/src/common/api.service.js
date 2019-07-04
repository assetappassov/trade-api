import Vue from 'vue'
import VueAxios from 'vue-axios'
import axios from 'axios'
import { API_URL } from '@/common/config'

const ApiService = {
  init () {
    Vue.use(VueAxios, axios)
    Vue.axios.defaults.baseURL = API_URL
  },
  fetch (resource) {
    return Vue.axios.get(resource)
  },
  
  get (resource, params) {
    return Vue.axios.get(resource, {
      params: params
    })
  },

  post (resource, payload) {
    return Vue.axios.post(`${resource}`, payload)
  },

  update (resource, payload) {
    return Vue.axios.put(`${resource}`, payload)
  },

  put (resource, payload) {
    return Vue.axios.put(`${resource}`, payload)
  },

  delete (resource) {
    return Vue.axios.delete(resource)
  }
}

export default ApiService
