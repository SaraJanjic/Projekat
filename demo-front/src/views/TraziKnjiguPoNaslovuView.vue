<template>
    <div>
      <h2>Traži knjigu po naslovu</h2>
      <form @submit.prevent="traziKnjigu">
        <label for="naslov">Naslov knjige:</label>
        <input type="text" id="naslov" v-model="naslov" required>
        <br>
        <button type="submit">Traži</button>
      </form>
  
      <div v-if="knjiga">
        <h3>Rezultat pretrage:</h3>
        <p>Naslov: {{ knjiga.naslov }}</p>
        <p>Autor: {{ knjiga.autor }}</p>
        <!-- Dodajte ostale informacije o knjizi koje želite prikazati -->
      </div>
      <div v-else>
        <p>Nema rezultata pretrage.</p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        naslov: '',
        knjiga: null,
      };
    },
    methods: {
      traziKnjigu() {
        axios.get(`http://localhost:8080/api/traziKnjiguPoNaslovu/${this.naslov}`)
          .then(response => {
            if (response.data) {
              this.knjiga = response.data;
            } else {
              this.knjiga = null;
            }
          })
          .catch(error => {
            console.error('Greška prilikom pretrage knjige:', error);
          });
      },
    },
  };
  </script>