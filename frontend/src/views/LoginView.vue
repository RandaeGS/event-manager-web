<script setup>
import { useAuthStore } from '@/stores/authStore'
import { useToast } from 'primevue'
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import z from 'zod'
import http from '@/plugins/axios'

const authStore = useAuthStore()
const router = useRouter()
const toast = useToast()

const form = reactive({
  email: '',
  password: '',
})

const errors = ref({})
const formSchema = z.object({
  email: z.email(),
  password: z.string().min(8, 'Min 8 characters'),
})

const validateForm = () => {
  try {
    formSchema.parse(form)
    errors.value = {}
    return true
  } catch (error) {
    errors.value = {}
    error.issues.forEach((err) => {
      errors.value[err.path[0]] = err.message
    })
    return false
  }
}

const login = async () => {
  if (!validateForm()) return

  try {
    if (await authStore.login(form.email, form.password)) {
      router.push('/')
    } else {
      toast.add({ severity: 'error', summary: 'Error', detail: 'Error during login', life: 3000 })
    }
  } catch (error) {
    toast.add({ severity: 'error', summary: 'Error', detail: 'Error during login', life: 3000 })
    console.error(error)
  }
}
</script>

<template>
  <div class="flex grow justify-center">
    <div class="justify-center content-center">
      <Card class="p-6 w-96">
        <template #title>
          <h1 class="text-center">Login</h1>
        </template>

        <template #content>
          <div class="flex flex-col gap-4">
            <div>
              <InputText v-model="form.email" fluid placeholder="Email" type="email" />
              <Message v-if="errors.email" severity="error" size="small" variant="simple">{{
                errors.email
              }}</Message>
            </div>
            <div>
              <InputText v-model="form.password" fluid placeholder="Password" type="password" />
              <Message v-if="errors.password" severity="error" size="small" variant="simple">{{
                errors.password
              }}</Message>
            </div>
            <Button label="Login" @click="login"></Button>
            <router-link to="signup">
              <Button label="Sign Up" severity="secondary" fluid></Button>
            </router-link>
          </div>
        </template>
      </Card>
    </div>
  </div>
</template>
