import { getters } from './contact.getters'
import { actions } from './contact.actions'
import { mutations } from './contact.mutations'

const state = {
  contact: {
    shop: {}
  },
  error: null
}

export default {
  state,
  actions,
  mutations,
  getters
}
