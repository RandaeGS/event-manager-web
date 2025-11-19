<script setup>
import { ref } from 'vue'

const menuItems = ref([
  {
    label: 'Eventman',
  },
  {
    label: 'Search Event',
  },
  {
    label: 'Manage events',
  },
  {
    label: 'Tickets',
  },
  {
    label: 'Sign Up',
  },
  {
    label: 'Login',
  },
])
</script>

<template>
  <div>
    <header>
      <Menubar :model="menuItems">
        <template></template>
      </Menubar>
    </header>

    <RouterView />
  </div>
</template>
