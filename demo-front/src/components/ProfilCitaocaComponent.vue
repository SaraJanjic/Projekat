<template>
  <div>
    <h2>Dobrodošli, {{ korisnik && korisnik.ime }} {{ korisnik && korisnik.prezime }}</h2>
    <p v-if="korisnik">Police: {{ korisnik.police }}</p>
  </div>


</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {

      korisnik: null
    };
  },
  mounted() {
    // Pozovite server za dobavljanje podataka o korisniku nakon prijave
    // Ovo može biti axios poziv ili bilo koja druga metoda za dobavljanje podataka

    // Na primer, ako koristite axios:
    axios.get(`/api/korisnik`)
      .then(response => {
        this.korisnik = response.data;
      })
      .catch(error => {
        console.error(error);
      });
  },
  
};
</script>

<style scoped>
.dashboard {
max-width: 800px;
margin: 0 auto;
padding: 20px;
}

.dashboard h2 {
font-size: 24px;
margin-bottom: 20px;
}

.dashboard p {
margin-bottom: 10px;
}

.dashboard ul {
list-style-type: none;
padding: 0;
}

.dashboard li {
margin-bottom: 5px;
}

</style>

