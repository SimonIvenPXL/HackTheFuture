<!-- src/components/FoodPile.vue -->
<script setup>
import { ref } from 'vue';

const foodPile = ref(100); // Initial food pile value
const amountToTake = ref(1); // Amount to take from the food pile
const message = ref('');

const takeFood = () => {
  if (amountToTake.value <= foodPile.value) {
    foodPile.value -= amountToTake.value;
    message.value = `You took ${amountToTake.value} from the pile!`;
  } else {
    message.value = 'Not enough food to take!';
  }
};
</script>

<template>
  <div class="foodpile-container">
    <h2>Excess nutrition</h2>
    <div class="foodpile-number">{{ foodPile }}</div>
    <div class="take-food">
      <input
          type="number"
          v-model="amountToTake"
          min="1"
          :max="foodPile"
          placeholder="Amount to take"
      />
      <button @click="takeFood">Take Food</button>
    </div>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<style scoped>
.foodpile-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  text-align: center;
}

.foodpile-number {
  font-size: 5rem;
  font-weight: bold;
  margin: 20px 0;
  color: #007bff;
}

.take-food {
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-top: 20px;
}

.take-food input {
  padding: 10px;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 150px;
}

.take-food button {
  padding: 10px 20px;
  font-size: 1rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.take-food button:hover {
  background-color: #0056b3;
}

.message {
  margin-top: 20px;
  font-weight: bold;
  color: green;
}
</style>
