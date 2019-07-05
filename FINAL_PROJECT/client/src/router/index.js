import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/components/Register'
import Login from '@/components/Login'
import MainPage from '@/components/Main';
import UsersPages from '@/components/userspage/UsersPage';
import ErrorPage from '@/components/Error'

import store from '@/store/store'

Vue.use(Router)

const router = new Router({
  routes: [{
    path: '/',
    name: 'MainPage',
    component: MainPage
  },
    {
      path: '/users',
      name: 'Users',
      component: UsersPages
    },
    {
      path: '*',
      redirect: to => {
        store.dispatch('setError', 'Not Found');
        store.dispatch('setErrorCode', '404');
        return {name: 'ErrorPage'};
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.isUserLoggedIn)) {
    if (store.state.isUserLoggedIn === false) {
      store.dispatch('setError', 'Unauthorized');
      store.dispatch('setErrorCode', '401');
      next({
        path: '/error',
        query: {
          redirect: 'ErrorPage',
        },
      });
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router;
