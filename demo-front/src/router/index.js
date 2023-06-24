import { createRouter, createWebHistory } from 'vue-router';

import DashboardView from '../views/DashboardView.vue';
import KorisnikForm from '../components/KorisnikForm.vue';
import RegistrationForm from '../components/RegistrationForm.vue';

import ZahtevComponent from './components/ZahtevComponent';
import LoginComponent from './components/LoginComponent';
import ProfilCitaoca from '../viewProfilCitaoca.vue';
import ProfilAutora from '../viewProfilAutora.vue';
import ProfilAdmina from '../viewProfilAdmina.vue';

import TraziKnjiguPoNaslovuView from '@/views/TraziKnjiguPoNaslovuView.vue';

const routes = [
  {
    path: '/',
    name: 'hello',
    component: HelloWorld
  },
  
  {
    path: '/zahtev',
    name: 'zahtev',
    component: ZahtevComponent
  },
  {
    path: '/login',
    name: 'login',
    component: LoginComponent
  },
  
  {
    path: '/dashboard',
    name: 'dashboard',
    component: DashboardView
  },
  {
    path: '/korisnici',
    name: 'korisnici',
    component: KorisnikForm
  },
  {
    path: '/register',
    name: 'Registration',
    component: RegistrationForm
  },
  {
    path: '/profil-admina',
    name: 'ProfilAdmina',
    component: ProfilAdmina
  },
  {
    path: '/profil-autora',
    name: 'ProfilAutora',
    component: ProfilAutora
  },
  {
    path: '/profil-citaoca',
    name: 'ProfilCitaoca',
    component: ProfilCitaoca
  },

  {
    path: '/search',
    name: 'PretragaKnjige',
    component: TraziKnjiguPoNaslovuView,
  },

];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
