
<template>
    <div>
      <h1>Dobrodosli u prijavu</h1>
      <login-component @login-success="loginPrijava"></login-component>
    </div>
    </template>
  
    <script>
    import LoginComponent from '@components/LoginComponent.vue'
  
    export default{
      components: {
        LoginComponent,
      },
      loginPrijava() {
      // Redirect the user to the appropriate view based on their role
      const userRole = JSON.parse(localStorage.getItem('user')).uloga;
      switch (userRole) {
        case 'CITALAC':
          this.$router.push('/profil-citaoca');
          break;
        case 'AUTOR':
          this.$router.push('/profil-autora');
          break;
        case 'ADMINISTRATOR':
          this.$router.push('/profil-admina');
          break;
        default:
          break;
      }
    },
  };
    </script>