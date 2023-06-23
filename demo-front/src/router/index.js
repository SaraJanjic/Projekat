import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import DashboardView from '../views/DashboardView.vue';
import KorisnikForm from '../components/KorisnikForm.vue';
import RegistrationForm from '../components/RegistrationForm.vue';

import ZahtevComponent from '/components/ZahtevComponent';

import ProfilCitaoca from '../viewProfilCitaoca.vue'
import ProfilAutora from '../viewProfilAutora.vue'
import ProfilAdmina from '../viewProfilAdmina.vue'

import TraziKnjiguPoNaslovuView from '@/views/TraziKnjiguPoNaslovuView.vue';

const routes = [
  {
    path: '/',
    name: 'hello',
    component: HelloWorld
  },
  {
    path: '/kreiraj-zahtev',
    name: 'kreirajZahtev',
    component: ZahtevComponent
  },
  {
    path: '/zahtevi-za-aktivaciju/:zahtevId/prihvati',
    name: 'PrihvatiZahtev',
    component: ZahtevAktivacija
  },
  {
    path: '/zahtevi-za-aktivaciju/:zahtevId/odbij',
    name: 'OdbijZahtev',
    component: ZahtevAktivacija
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
    path: '/',
    name: 'home',
    component: TraziKnjiguPoNaslovuView,
  },

];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
