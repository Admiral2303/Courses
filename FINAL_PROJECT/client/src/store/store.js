import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  strict: true,
  plugins: [
    createPersistedState()
  ],
  state: {
    token: null,
    user: null,
    users: [],
    isUserLoggedIn: false,
    error: null,
    errorcode: null
  },
  mutations: {
    setToken(state, token) {
      state.token = token
      if (token) {
        state.isUserLoggedIn = true
      } else {
        state.isUserLoggedIn = false
      }
    },
    setUser(state, user) {
      state.user = user
    },
    setUsers(state, users) {
      state.users = users
    },
    setError(state, error) {
      state.error = error;
    },
    setErrorCode(state, errorcode) {
      state.errorcode = errorcode;
    }
  },
  actions: {
    setToken({commit}, token) {
      commit('setToken', token)
    },
    setUser({commit}, user) {
      commit('setUser', user)
    },
    setUsers({commit}, users) {
      commit('setUsers', users)
    },
    setError({commit}, error) {
      commit('setError', error)
    },
    setErrorCode({commit}, errorcode) {
      commit('setErrorCode', errorcode)
    },
  },
  getters: {
    user(state) {
      return state.user;
    },
    users(state) {
      return state.users;
    },
    error(state) {
      return state.error;
    },
    errorcode(state) {
      return state.errorcode;
    }
  }
})
