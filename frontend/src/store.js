import Vue from 'vue'
import Vuex from 'vuex'
import api from './components/backend-api'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        lateList: [],
        statList: []
    },
    getters: {
        lateList: state => state.lateList,
        statList: state => state.statList
    },
    mutations: {
        lateList(state, lateList) {
            state.lateList = lateList
        },
        statList(state, statList) {
            state.statList = statList
        }
    },
    actions: {
        create(context, payload) {
            api.createLate(payload).then(() => context.dispatch("getLateList"))
        },
        getLateList(context) {
            api.getLates().then(res => context.commit("lateList", res.data))
        },
        deleteLates(context) {
            api.deleteLates().then(() => context.dispatch("getLateList"))
        },
        getStatList(context) {
            api.getStats().then(res => context.commit("statList", res.data))
        }
    },

})