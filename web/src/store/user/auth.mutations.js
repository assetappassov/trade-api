import {
    SET_AUTH,
    PURGE_AUTH,
    SET_ERROR
  } from '../mutations.type'

export const mutations = {
    [SET_ERROR] (state, error) {
      state.errors = error
    },
    [SET_AUTH] (state, data) {
      state.isAuthenticated = true
      state.user = data.user
      state.errors = {}
    },
    [PURGE_AUTH] (state) {
      state.isAuthenticated = false
      state.user = {}
      state.errors = {}
    }
  }
