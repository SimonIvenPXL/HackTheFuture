<template>
  <div class="kindness-container">
    <div class="kindness-list">
      <h2>Acts of Kindness</h2>
      <ul>
        <li v-for="(act, index) in acts" :key="index" class="kindness-item">
          <div>
            <h3>{{ act.title }}</h3>
            <p>{{ act.description }}</p>
          </div>
          <button @click="upvote(index)">Upvote ({{ act.upvotes }})</button>
        </li>
      </ul>
    </div>
    <div class="kindness-form">
      <h2 class="title">Share a Random Act of Kindness</h2>
      <form @submit.prevent="submitKindness">
        <div class="form-group">
          <label for="title">Title:</label>
          <input type="text" id="title" v-model="title" required />
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

<script>
export default {
  name: "KindnessForm",
  data() {
    return {
      title: "",
      description: "",
      message: "",
      acts: [
        { title: "Helping a stranger", description: "Helped carry groceries for an elderly person.", upvotes: 5 },
        { title: "Donated books", description: "Gave away books to a local library.", upvotes: 3 },
        { title: "Paid for someone's coffee", description: "Covered the cost of a coffee for the person behind in line.", upvotes: 7 }
      ]
    };
  },
  methods: {
    submitKindness() {
      if (this.title && this.description) {
        this.acts.push({ title: this.title, description: this.description, upvotes: 0 });
        this.message = `Thank you for sharing: "${this.title}"`;
        this.title = "";
        this.description = "";
      }
    },
    upvote(index) {
      this.acts[index].upvotes++;
    }
  },
};
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
