<template>
  <header class="navbar">
    <div class="navbar-left">
      <h1>Rations App</h1>
    </div>
    <nav class="navbar-center">
      <ul>
        <li><router-link to="/acts">Acts of Kindness</router-link></li>
        <li><router-link to="/">Food Pile</router-link></li>
      </ul>
    </nav>
    <div class="navbar-right">
      <div class="currency-box">
        <span>{{ currency }}</span>
      </div>
    </div>
  </header>

  <main>
    <router-view></router-view> <!-- This will render the active component based on the route -->
  </main>
</template>

<script setup>
import { ref } from 'vue';
import KindnessForm from './components/ActForm.vue';

const currency = ref('10');
</script>

<style scoped>
/* Navbar Styles */
.navbar {
  display: flex;
  justify-content: space-between;
  padding: 10px 20px;
  background-color: #333;
  color: white;
  position: fixed;
  width: 100%;
  top: 0;
  left: 0;
  z-index: 1000;
}

.navbar-left h1 {
  margin: 0;
}

.navbar-center {
  display: flex;
  justify-content: center;
  flex-grow: 1;
}

.navbar-center ul {
  display: flex;
  gap: 20px;
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.navbar-center li {
  display: inline;
}

.navbar-center a {
  text-decoration: none;
  color: white;
  font-weight: bold;
}

.navbar-right {
  display: flex;
  align-items: center;
}

.currency-box {
  background-color: #444;
  padding: 5px 10px;
  border-radius: 5px;
  font-weight: bold;
  margin-right: 50px;
}

/* Main content */
main {
  margin-top: 60px; /* To avoid the navbar overlapping with the main content */
  padding: 20px;
}

/* Responsive styling */
@media (min-width: 1024px) {
  .navbar {
    padding-right: calc(var(--section-gap) / 2);
  }

  .navbar-left h1 {
    margin: 0 2rem 0 0;
  }
}
</style>
