<script setup>
import { computed, reactive } from 'vue'

const form = reactive({
  email: '',
  password: '',
  firstName: '',
  lastName: '',
  role: 'attendee',
  organization: '',
})

const formConfirm = reactive({
  email: '',
  password: '',
})

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
            <FloatLabel variant="on">
              <InputText id="first-name" v-model="form.firstName" fluid />
              <label for="first-name">First Name</label>
            </FloatLabel>
            <FloatLabel variant="on">
              <InputText id="last-name" v-model="form.lastName" fluid />
              <label for="last-name">Last Name</label>
            </FloatLabel>

            <FloatLabel variant="on">
              <InputText id="email" v-model="form.email" type="email" fluid />
              <label for="email">Email</label>
            </FloatLabel>
            <FloatLabel variant="on">
              <InputText id="confirm-email" v-model="formConfirm.email" type="email" fluid />
              <label for="confirm-email">Confirm email</label>
            </FloatLabel>

            <FloatLabel variant="on">
              <InputText id="password" v-model="form.password" type="password" fluid />
              <label for="password">Password</label>
            </FloatLabel>
            <FloatLabel variant="on">
              <InputText
                id="confirm-password"
                v-model="formConfirm.password"
                type="password"
                fluid
              />
              <label for="confirm-passwod">Confirm password</label>
            </FloatLabel>

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

            <FloatLabel variant="on">
              <InputText
                :disabled="!isOrganizationEnabled"
                id="organization"
                v-model="form.organization"
                fluid
              />
              <label for="organization">Organization</label>
            </FloatLabel>

            <Button label="Login" severity="secondary"></Button>
            <Button label="Sign Up"></Button>
          </div>
        </template>
      </Card>
    </div>
  </div>
</template>
