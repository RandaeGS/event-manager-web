import './assets/main.css'
import 'primeicons/primeicons.css'

import { createApp } from 'vue'
import PrimeVue from 'primevue/config'
import Aura from '@primeuix/themes/aura'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import { ToastService } from 'primevue'

const app = createApp(App)

app.use(PrimeVue, {
  ripple: true,
  theme: {
    preset: Aura,
    options: {
      prefix: 'p',
      darkModeSelector: false,
    },
  },
})
app.use(ToastService)
app.use(createPinia())
app.use(router)

app.mount('#app')
