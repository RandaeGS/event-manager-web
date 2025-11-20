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
          path: '/',
          component: HomeView,
        },
        {
          path: '/login',
          component: LoginView,
        },
        {
          path: '/signup',
          component: SignUp,
        },
      ],
    },
  ],
})

export default router
