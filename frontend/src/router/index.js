import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AppLayout from '@/layout/AppLayout.vue'
import LoginView from '@/views/LoginView.vue'
import SignUp from '@/views/SignUp.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: AppLayout,
      children: [
        {
          name: 'home',
          path: '/',
          component: HomeView,
        },
        {
          name: 'login',
          path: '/login',
          component: LoginView,
        },
        {
          name: 'signup',
          path: '/signup',
          component: SignUp,
        },
      ],
    },
  ],
})

export default router
