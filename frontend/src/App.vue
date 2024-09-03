//script

<script setup>
  import ExpenseCreater from "./components/ExpenseCreater.vue"
  import TopExpenses from "./components/TopExpenses.vue"
</script>


//template
<template>
 <main class="main-class">
   <div class="create-expense"> 
     <ExpenseCreater />
   </div>
   <div class="display-top">
     <TopExpenses />
   </div>
 </main>
</template>

//styles

<style scoped>
body {
  margin: 0;
  padding: 0;
  background-color: #e0f7fa; /* Pale blue color */
  font-family: Arial, sans-serif; /* Optional: Set a default font */
}

.main-class {
  display: flex;
  justify-content: space-between; /* Space between the two boxes */
  max-width: 1200px;
  margin: 20px auto; /* Center the container horizontally */
  padding: 20px;
}

.create-expense,
.display-top {
  flex: 1; /* Allow the boxes to grow and fill available space */
  margin: 0 10px; /* Space between the two boxes */
  background-color: #ffffff; /* White background for content boxes */
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 5px;
}

.create-expense {
    width: 1rem;
}

.display-top {
  width: 100rem;
}
</style>
