<template>
  <div>
    <h2>Podnošenje zahteva za aktivaciju autora</h2>
    <form @submit="submitZahtev">
      <label for="email">Email:</label>
      <input type="email" id="email" v-model="zahtev.email" required>
      <label for="brojTelefona">Broj telefona:</label>
      <input type="text" id="brojTelefona" v-model="zahtev.brojTelefona">
      <label for="dodatnaPoruka">Dodatna poruka:</label>
      <textarea id="dodatnaPoruka" v-model="zahtev.dodatnaPoruka"></textarea>
      <button type="submit">Podnesi zahtev</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      zahtev: {
        email: '',
        brojTelefona: '',
        dodatnaPoruka: ''
      }
    };
  },
  methods: {
    submitZahtev() {
      axios.post('/api/kreiraj-zahtev', this.zahtev)
        .then(response => {
          console.log('Zahtev uspešno podnet:', response.data);
          // Dodajte odgovarajuću logiku ili redirekciju nakon podnošenja zahteva
        })
        .catch(error => {
          console.error('Greška prilikom podnošenja zahteva:', error);
        });
    }
  }
};
</script>
