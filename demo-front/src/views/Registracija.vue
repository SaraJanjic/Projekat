<template>
    <div>
      <h2>Registracija</h2>
      <form @submit.prevent="register">
        <label for="ime">Ime:</label>
        <input type="text" id="ime" v-model="formData.ime" required>

        <label for="prezime">Prezime:</label>
        <input type="text" id="prezime" v-model="formData.prezime" required>
  
        <label for="userName">userName:</label>
        <input type="userName" id="userName" v-model="formData.userName" required>

        <label for="email">Email:</label>
        <input type="email" id="email" v-model="formData.email" required>
  
        <label for="lozinka">Lozinka:</label>
        <input type="lozinka" id="lozinka" v-model="formData.lozinka" required>
  
        <button type="submit">Registruj se</button>
      </form>
      <p v-if="message">{{ message }}</p>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        formData: {
          ime: '',
          prezime: '',
          email: '',
          userName: '',
          lozinka: '',
        },
        message: ''
      };
    },
    methods: {
      register() {
        axios.post('/api/register', this.formData)
          .then(response => {
            this.message = 'Uspešno ste se registrovali!';
          })
          .catch(error => {
            this.message = 'Došlo je do greške prilikom registracije.';
            console.error(error);
          });
      }
    }
  };
  </script>