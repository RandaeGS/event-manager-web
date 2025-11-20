<script setup>
import AppTopbar from './AppTopbar.vue'
</script>

<template>
  <div class="h-screen flex flex-col">
    <header>
      <app-topbar></app-topbar>
    </header>
    <main class="bg-gray-200 p-6 flex grow">
      <router-view />
    </main>
  </div>
</template>
