<script setup>
import { ref } from 'vue'
import { watch } from 'vue'
import { computed, reactive } from 'vue'
import z from 'zod'

const form = reactive({
  email: '',
  password: '',
  firstName: '',
  lastName: '',
  role: 'attendee',
  organization: '',
})

const errors = ref({})
const formSchema = z.object({
  email: z.email(),
  firstName: z.string().min(3, 'Min 3 characters'),
  lastName: z.string().min(3, 'Min 3 characters'),
  password: z.string().min(8, 'Min 8 characters'),
  organization: z.string(),
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

const signUp = () => {
  validateForm()
}

const isOrganizationEnabled = computed(() => {
  return form.role === 'organizer'
})
</script>

<template>
  <div class="flex grow justify-center">
    <div class="justify-center content-center w-full lg:w-3/4">
      <Card class="p-6">
        <template #header>
          <h1 class="text-center">Sign Up</h1>
        </template>

        <template #content>
          <div class="grid grid-cols-1 gap-4 md:grid-cols-2">
            <div>
              <FloatLabel variant="on">
                <InputText id="first-name" v-model="form.firstName" fluid />
                <label for="first-name">First Name</label>
              </FloatLabel>
              <Message v-if="errors.firstName" severity="error" size="small" variant="simple">{{
                errors.firstName
              }}</Message>
            </div>

            <div>
              <FloatLabel variant="on">
                <InputText id="last-name" v-model="form.lastName" fluid />
                <label for="last-name">Last Name</label>
              </FloatLabel>
              <Message v-if="errors.lastName" severity="error" size="small" variant="simple">{{
                errors.lastName
              }}</Message>
            </div>

            <div>
              <FloatLabel variant="on">
                <InputText id="email" v-model="form.email" type="email" fluid />
                <label for="email">Email</label>
              </FloatLabel>
              <Message v-if="errors.email" severity="error" size="small" variant="simple">{{
                errors.email
              }}</Message>
            </div>

            <div>
              <FloatLabel variant="on">
                <InputText id="password" v-model="form.password" type="password" fluid />
                <label for="password">Password</label>
              </FloatLabel>
              <Message v-if="errors.password" severity="error" size="small" variant="simple">{{
                errors.password
              }}</Message>
            </div>

            <RadioButtonGroup name="role" v-model="form.role" class="gap-4">
              <h2 class="flex items-center">Role</h2>
              <div class="flex items-center gap-2">
                <RadioButton inputId="attendee" value="attendee" />
                <label for="attendee">Attendee</label>
              </div>

              <div class="flex items-center gap-2">
                <RadioButton inputId="organizer" value="organizer" />
                <label for="organizer">Organizer</label>
              </div>
            </RadioButtonGroup>

            <div>
              <FloatLabel variant="on">
                <InputText
                  :disabled="!isOrganizationEnabled"
                  id="organization"
                  v-model="form.organization"
                  fluid
                />
                <label for="organization">Organization</label>
              </FloatLabel>
              <Message v-if="errors.organization" severity="error" size="small" variant="simple">{{
                errors.organization
              }}</Message>
            </div>

            <router-link to="login">
              <Button label="Login" fluid severity="secondary"></Button>
            </router-link>
            <Button label="Sign Up" @click="signUp"></Button>
          </div>
        </template>
      </Card>
    </div>
  </div>
</template>
