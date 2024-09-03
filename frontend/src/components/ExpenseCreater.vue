<template>
  <div class="expense-creator">
    <h2>Create a New Expense</h2>
    <form @submit.prevent="submitExpense">
      <div class="form-group">
        <label for="expenseName">Expense Name</label>
        <input v-model="expenseName" id="expenseName" class="expenseName" type="text" placeholder="Enter expense name" required>
      </div>
      
      <div class="form-group">
        <label for="expenseDate">Expense Date</label>
        <input v-model="expenseDate" id="expenseDate" class="expenseDate" type="date" required>
      </div>
      
      <div class="form-group">
        <label for="expenseType">Expense Type</label>
        <input v-model="expenseType" id="expenseType" class="expenseType" type="text" placeholder="Enter expense type" required>
      </div>
      
      <div class="form-group">
        <label for="expenseValue">Expense Value</label>
        <input v-model.number="expenseValue" id="expenseValue" class="expenseValue" type="number" step="0.01" placeholder="Enter expense value" required>
      </div>
      
      <button type="submit" class="submit-button">Add Expense</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
   return {
    expenseName: '',
    expenseDate: '',
    expenseType: '',
    expenseValue: ''
   };
  },
  methods: {
    async submitExpense() {
      try {
        const response = await axios.post('http://localhost:8080/api/expense/v2', {
          expenseName: this.expenseName,
          expenseDate: this.expenseDate,
          expenseType: this.expenseType,
          expenseValue: this.expenseValue
        }, {
          headers: { "Content-Type": "application/json" }
        });
          // Reset form fields
        this.expenseName = '';
        this.expenseDate = '';
        this.expenseType = '';
        this.expenseValue = '';
        console.log('Expense submitted successfully:', response.data);
        
      } catch (error) {
        console.error('Error submitting expense:', error);
      }
    }
  }
}
</script>

<style scoped>
/* Your existing styles seem appropriate and are retained as is */
.expense-creator {
  max-width: 400px;
  margin: 20px auto;
  padding: 20px;
  background-color: #f3f3f3;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  margin-right: 20rem;
}

h2 {
  text-align: center;
  color: #333;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  font-weight: 600;
  margin-bottom: 5px;
  color: #555;
}

.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
}

.form-group input:focus {
  border-color: #007BFF;
  outline: none;
  box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

.submit-button {
  width: 100%;
  padding: 12px;
  background-color: #007BFF;
  border: none;
  border-radius: 4px;
  color: white;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.submit-button:hover {
  background-color: #0056b3;
}
</style>
