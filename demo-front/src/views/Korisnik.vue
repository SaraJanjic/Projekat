<template>
    <div>
      <h2>Korisnici</h2>
      <ul>
        <li v-for="korisnik in korisnici" :key="korisnik.id">
          <h3>{{ korisnik.username }}</h3>
          <p>Ime: {{ korisnik.ime }}</p>
          <p>Prezime: {{ korisnik.prezime }}</p>
          <p>Opis: {{ korisnik.opis }}</p>
          <p>Slika: {{ korisnik.slikaKorisnika }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
    import axios from 'axios';
    const userEndpoint = 'https://api/korisnici'; //nisam sig

  export default {
    data() {
      return {
        korisnici: [] 
      };
    },
    created() {
      axios.get(userEndpoint)
     .then(response => {
      const korisnici = response.data;

    console.log(korisnici); // Ispis podataka korisnika u konzoli
  })
  .catch(error => {
    console.error(error);
  });
      this.fetchKorisnici();
    },
    methods: {
      fetchKorisnici() {
        axios.get('/api/korisnici')
      .then(response => {
        this.korisnici = response.data; // Ažuriranje niza users sa dobavljenim korisnicima
      })
      .catch(error => {
        console.log(error);
      });
      }
    }
  };
  </script>
  
  <style>
  .korisnik-list {
    list-style: none;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  
  .korisnik {
    width: 250px;
    margin-bottom: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f7f7f7;
  }
  
  .korisnik-username {
    font-size: 18px;
    font-weight: bold;
  }
  
  .korisnik-ime,
  .korisnik-prezime,
  .korisnik-opis,
  .korisnik-slika {
    font-size: 14px;
    color: #666;
  }
  </style>
  