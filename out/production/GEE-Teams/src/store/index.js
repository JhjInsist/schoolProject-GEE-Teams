import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    dialogVisible: true
  },
  mutations: {
    setDialogVisible(state, payload) {
      state.dialogVisible = payload;
    }
  },
  actions: {
    updateDialogVisible({ commit }, payload) {
      commit('setDialogVisible', payload);
    }
  },
  getters: {
    getDialogVisible(state) {
      return state.dialogVisible;
    }
  }
});

export default store