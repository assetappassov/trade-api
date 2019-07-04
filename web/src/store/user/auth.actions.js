import ApiService from '@/common/api.service'

import {
  LOGIN,
  LOGOUT,
  REGISTER,
  CHECK_AUTH,
  PURGE_AUTH,
  UPDATE_USER
} from '../actions.type'

export const actions = {
    [LOGIN] (context, credentials) {
      return new Promise(resolve => {
        ApiService.post('users/signIn', credentials)
          .then(({ data }) => {
            context.commit(SET_AUTH, data)
            resolve(data)
          })
          .catch(({ response }) => {
            context.commit(SET_ERROR, [response.data.error])
          })
      })
    },
    [LOGOUT] (context) {
      context.commit(PURGE_AUTH)
    },
    [REGISTER] (context, credentials) {
      return new Promise((resolve, reject) => {
        ApiService.post('users/register', credentials)
          .then(({ data }) => {
            context.commit(SET_AUTH, data)
            resolve(data)
          })
          .catch(({ response }) => {
            context.commit(SET_ERROR, response.data.errors)
            reject(response)
          })
      })
    },
    [CHECK_AUTH] (context) {
      if (true) {
        ApiService.get('users/currentUser')
          .then(({ data }) => {
            // context.commit(SET_AUTH, data)
          })
          .catch(({ response }) => {
            if (response) {
              context.commit(SET_ERROR, response.data)
            }
          })
      } else {
        context.commit(PURGE_AUTH)
      }
    },
    [UPDATE_USER] (context, payload) {
      const { email, username, password, image, bio } = payload
      const user = {
        email,
        username,
        bio,
        image
      }
      if (password) {
        user.password = password
      }
  
      return ApiService.put('user', user).then(({ data }) => {
        context.commit(SET_AUTH, data)
        return data
      })
    }
  }
