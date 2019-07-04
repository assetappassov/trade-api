import ApiService from '@/common/api.service'

import { FETCH_SHOP_CONTACT } from '../actions.type'
  
import {
  SET_SHOP_CONTACT,
  SET_ERROR } from '../mutations.type'

export const actions = {
    [FETCH_SHOP_CONTACT] (ctx, nickname) {
      return new Promise(resolve => {
        ApiService.get(`${nickname}/contact`)
          .then(({ data }) => {
            ctx.commit(SET_SHOP_CONTACT, data)
            resolve(data)
          })
          .catch(({ response }) => {
            ctx.commit(SET_ERROR, response.data)
          })
      })
    }
  }