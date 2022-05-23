import Vue from 'vue'
import Router from 'vue-router'
import BettingDapp from '@/components/betting-dapp'
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