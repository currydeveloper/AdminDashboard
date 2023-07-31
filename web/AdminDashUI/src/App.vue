<script setup>
import { ref } from 'vue';
const searhcSelection=ref();
const selections=ref(["Identity","Group"]);
</script>

<template>
  <div class="card">
    <h2></h2>
        <Dropdown v-model="searhcSelection" :options="selections" placeholder="Select the search type"/>
        <Panel header="Header" toggleable>
            <p class="m-0">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </Panel>
    </div>
</template>

<style scoped>

</style>
