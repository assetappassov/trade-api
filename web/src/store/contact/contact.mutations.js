import { SET_SHOP_CONTACT, SET_ERROR } from '../mutations.type'

export const mutations = {
    [SET_SHOP_CONTACT] (state, contact) {
      state.contact = contact;
    },
    [SET_ERROR] (state, error) {
      state.error = error;
    }
  }