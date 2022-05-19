import Vue from 'vue'
import Router from 'vue-router'
import BettingDapp from '@/components/BettingDapp'
Vue.use(Router)

export default new Router ({
    routes: [
        {
            path: '/',
            name: 'betting-dapp',
            component: BettingDapp
        }
    ]
})