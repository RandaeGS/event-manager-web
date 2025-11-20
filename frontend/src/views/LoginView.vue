<script setup></script>

<template>
  <div class="flex grow justify-center">
    <div class="justify-center content-center">
      <Card class="p-6 w-96">
        <template #title>
          <h1 class="text-center">Login</h1>
        </template>

        <template #content>
          <div class="flex flex-col gap-4">
            <InputText placeholder="Email" type="email" />
            <InputText placeholder="Password" type="password" />
            <Button label="Login"></Button>
            <router-link to="signup">
              <Button label="Sign Up" severity="secondary" fluid></Button>
            </router-link>
          </div>
        </template>
      </Card>
    </div>
  </div>
</template>
