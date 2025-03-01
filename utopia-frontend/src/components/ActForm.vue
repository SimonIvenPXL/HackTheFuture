<template>
  <div class="kindness-container">
    <div class="kindness-list">
      <h2>Acts of Kindness</h2>
      <ul>
        <li v-for="(act, index) in acts" :key="index" class="kindness-item">
          <div>
            <h3>{{ act.name }}</h3>
            <p>{{ act.description }}</p>
          </div>
          <button @click="upvote(act.id, index)">Upvote ({{ act.amountOfNutritionPoints }})</button>
        </li>
      </ul>
    </div>
    <div class="kindness-form">
      <h2 class="title">Share a Random Act of Kindness</h2>
      <form @submit.prevent="submitKindness">
        <div class="form-group">
          <label for="name">Title:</label>
          <input type="text" id="name" v-model="name" required />
        </div>
        <div class="form-group">
          <label for="description">Description:</label>
          <textarea id="description" v-model="description" required></textarea>
        </div>
        <button type="submit">Submit</button>
      </form>
      <div v-if="message" class="message">{{ message }}</div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const name = ref('');
const description = ref('');
const message = ref('');
const acts = ref([]);

const fetchActs = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/act');
    acts.value = response.data;
  } catch (error) {
    console.error('Error fetching acts:', error);
  }
};

const submitKindness = async () => {
  try {
    const newAct = {
      name: name.value,
      description: description.value,
      amountOfNutritionPoints: 0,
      personId: 1
    };
    const response = await axios.post('http://localhost:8080/api/act', newAct);
    acts.value.push(response.data);
    message.value = `Thank you for sharing: "${name.value}"`;
    name.value = '';
    description.value = '';
  } catch (error) {
    console.error('Error submitting act:', error);
    message.value = 'There was an error submitting your act.';
  }
};

const upvote = async (actId, index) => {
  try {
    // Send PUT request to upvote the act
    const response = await axios.put(`http://localhost:8080/api/person/${actId}/upvote`);

    // Update the act in the frontend
    acts.value[index].amountOfNutritionPoints = response.data.amountOfNutritionPoints;
    console.log(`Upvoted act: ${acts.value[index].name}`);
  } catch (error) {
    console.error('Error upvoting act:', error);
  }
}

onMounted(() => {
  fetchActs();
});
</script>

<style scoped>
.kindness-container {
  display: flex;
  width: 100%;
  max-width: 1600px;
  margin: 0 auto;
  height: 100vh;
}
.kindness-list {
  width: 600px;
  padding: 40px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background: #f1f1f1;
  overflow-y: auto;
}
.kindness-item {
  width: 500px;
  justify-content: space-between;
  align-items: center;
  background: #fff;
  padding: 15px;
  margin-bottom: 15px;
  border-radius: 6px;
  box-shadow: 3px 3px 6px rgba(0, 0, 0, 0.1);
}
button {
  background: #007bff;
  color: white;
  border: none;
  padding: 8px 12px;
  cursor: pointer;
  border-radius: 6px;
}
button:hover {
  background: #0056b3;
}
.kindness-form {
  width: 400px;
  padding: 40px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background: #f9f9f9;
  overflow-y: auto;
}
.title {
  text-align: center;
}
.form-group {
  margin-bottom: 20px;
}
label {
  display: block;
  font-weight: bold;
}
input, textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 6px;
}
.message {
  margin-top: 20px;
  text-align: center;
  color: #155724;
  background: #d4edda;
  padding: 12px;
  border-radius: 6px;
}
</style>
