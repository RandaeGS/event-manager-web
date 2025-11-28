import http from '@/plugins/axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useAuthStore = defineStore('auth', () => {
  const user = ref(null)

  /**
  @param {string} email - The user email.
  @param {string} password - The user password.
  **/
  async function login(email, password) {
    try {
      const response = await http.post('/auth/login', {
        email: email,
        password: password,
      })
      user.value = response.data
    } catch (error) {
      console.error(error)
      return false
    }
    return true
  }

  return { user, login }
})
