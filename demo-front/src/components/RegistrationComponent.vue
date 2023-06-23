<template>
    <div>
      <h2>Registracija</h2>
      <form @submit="register">
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

        <label for="datumRodjenja">Datum rodjenja:</label>
        <input type="date" id="datumRodjenja" v-model="formData.datumRodjenja" required>
  
        <button type="submit">Registruj se</button>
      </form>
      <p>{{ registrationStatus }}</p>
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
          datumRodjenja: '',
        },
        registrationStatus: ''
      };
    },
    methods: {
      register(event) {
        event.preventDefault();
        axios.post('/api/register', this.formData)
          .then(response => {
            this.registrationStatus = response.data;
            alert("Uspesna registracija!")
          })
          .catch(error => {
            if(error.response && error.response.data){
                this.registrationStatus = error.response.data;
            }else{
                this.registrationStatus = 'Doslo je do greske prilikom registracije.';
                alert("Greska");
            }
            
          
          });
      }
    }
  };
  </script>