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
      axios.post('/api/register', {
        // Include the necessary registration data
        // For example, you can pass email and password as request parameters or in the request body
        // Modify the following lines to include the actual registration data
        email: 'example@example.com',
        password: 'password123'
      })
      .then(response => {
        // Handle the response after a successful registration
        console.log('Registration successful!', response.data);
        // Add your code here to navigate to the desired page or perform any other desired actions
      })
      .catch(error => {
        // Handle the error in case of a failed registration
        console.error('Registration failed!', error);
        // Add your code here to display an error message or perform any other desired actions
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
</style>
