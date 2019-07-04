<template>
  <div class="container text-center" v-if="isLoading">
      <div class="spinner-grow text-success"></div>
      <div class="spinner-grow text-info"></div>
      <div class="spinner-grow text-warning"></div>
      <div class="spinner-grow text-danger"></div>
  </div>
</template>

<script>
export default {
    props: {
        isLoading: {
          type: Boolean
        }
    },
    data() {
      return {}
    }
}
</script>