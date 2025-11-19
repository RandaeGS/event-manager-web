<script setup></script>

<template>
  <div class="flex justify-between shadow p-4">
    <div class="items-center text-center flex gap-5">
      <h1>Eventman</h1>
      <IconField>
        <InputIcon class="pi pi-search" />
        <InputText size="small" type="text" placeholder="Search event" style="width: 25rem" />
      </IconField>
    </div>
    <div class="items-center">
      <Button label="Manage Events" severity="contrast" variant="text"></Button>
      <Button label="Tickets" severity="contrast" variant="text"></Button>
      <Button label="Sign Up" severity="contrast" variant="text"></Button>
      <Button label="Login" severity="primary" variant="text"></Button>
    </div>
  </div>
</template>
