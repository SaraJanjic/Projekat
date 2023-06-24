<template>
  <div>
    <h1>Dobrodošli na svoju stranicu</h1>
    <button v-if="isAdmin" @click="pregledZahteva">Pregled zahteva za aktivaciju</button>
  </div>
</template>

<script>
export default {
  // ...
  computed: {
    isAdmin() {
      const userRole = JSON.parse(localStorage.getItem('user')).uloga;
      return userRole === 'ADMINISTRATOR';
    }
  },
  methods: {
    pregledZahteva() {
    
    }
  }
};
</script>
