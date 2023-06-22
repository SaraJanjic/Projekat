<template>
    <div>
      <h2>Zahtevi za aktivaciju autora</h2>
      <ul>
        <li v-for="zahtev in zahtevi" :key="zahtev.id">
          <p>Email: {{ zahtev.email }}</p>
          <p>Broj telefona: {{ zahtev.brojTelefona }}</p>
          <p>Dodatna poruka: {{ zahtev.dodatnaPoruka }}</p>
          <div>
            <button @click="posaljiZahtev">Pošalji zahtev</button>
          </div>
          <button @click="prihvatiZahtev(zahtev.id)">Prihvati zahtev</button>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        zahtevi: []
      };
    },
    mounted() {
      this.fetchZahtevi();
    },
    methods: {
      fetchZahtevi() {
        axios.get('/api/zahtevi-za-aktivaciju')
          .then(response => {
            this.zahtevi = response.data;
          })
          .catch(error => {
            console.error('Greška prilikom dohvatanja zahteva:', error);
          });
      },
      prihvatiZahtev(zahtevId) {
        axios.post(`/api/zahtevi-za-aktivaciju/${zahtevId}/prihvati`)
          .then(response => {
            console.log('Zahtev uspešno prihvaćen:', response.data);
            this.fetchZahtevi();
          })
          .catch(error => {
            console.error('Greška prilikom prihvatanja zahteva:', error);
          });
      },
      posaljiZahtev() {
        axios.post('/api/kreiraj-zahtev', {
          email: 'primer@email',
          brojTelefona: '123456789',
          dodatnaPoruka: 'Dodatna poruka'
        })
          .then(response => {
            console.log('Zahtev uspešno poslat!', response.data);
            this.fetchZahtevi();
          })
          .catch(error => {
            console.error('Greška prilikom slanja zahteva:', error);
          });
      },
    },
  };
  </script>
  