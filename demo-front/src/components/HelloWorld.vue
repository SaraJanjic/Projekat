<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>

      Pronadjite, citajte i ocenite knjige!<br>
      <button @click="handleButtonClick">Registruj se</button>
      
    </p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  
  name: 'HelloWorld',
  props: {
    msg: String
  },

  methods: {
    handleButtonClick() {
      
      this.$router.push('/registration');
      console.log('Registration button clicked!');

      // Make an HTTP POST request to the registration endpoint
      axios.post('/api/register', 'api/search', {
        
        email: 'example@example.com',
        password: 'password123',
        query: 'query'
      })
      .then(response => {
       
        console.log('Registration successful!', response.data);
        const searchResults = response.data;
        console.log('Search results:', searchResults);
        
      })
      .catch(error => {
       
        console.error('Registration failed!', error);
        console.error('Search failed!', error);      
       });
    }
  }
};

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}


.category {
  padding: 10px 20px;
  margin-right: 10px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.category:hover {
  background-color: #379e70;
}


</style>
