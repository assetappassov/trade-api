import { getters } from './auth.getters'
import { actions } from './auth.actions'
import { mutations } from './auth.mutations'


const state = {
  error: null,
  user: {}
}

export default {
  state,
  actions,
  mutations,
  getters
}
