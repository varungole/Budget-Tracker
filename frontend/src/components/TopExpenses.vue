<template>
  <section class="top-expenses-container">
    <h1 class="top-expenses-heading">Your Top Expenses</h1>
    <ol class="top-expenses-list">
      <!-- Use v-for to render list items dynamically -->
    <li v-for="expense in expenses" :key="expense.id" class="top-expense-item">
    {{ expense.expenseName }} - {{ expense.expenseValue }}
    </li>
    </ol>
  </section>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      expenses: [] // Initialize an empty array to store expenses
    };
  },
  created() {
    this.fetchTopExpense();
  },
  methods: {
    async fetchTopExpense() {
      try {
        const response = await axios.get('http://localhost:8080/api/expense/v2/top');
        this.expenses = response.data;
        console.log(this.expenses);
      } catch (error) {
        console.error('Error fetching top expenses:', error);
      }
    }
  }
}
</script>

<style scoped>
.top-expenses-container {
  max-width: 600px;
  margin: 20px auto;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.top-expenses-heading {
  font-size: 24px;
  color: #333;
  margin-bottom: 20px;
  text-align: center;
}

.top-expenses-list {
  list-style-type: none;
  padding: 0;
}

.top-expense-item {
  font-size: 18px;
  color: #555;
  border-bottom: 1px solid #ddd;
  padding: 10px 0;
  transition: background-color 0.3s, color 0.3s;
}

.top-expense-item:last-child {
  border-bottom: none;
}

.top-expense-item:hover {
  background-color: #f0f8ff;
  color: #007BFF;
}
</style>
