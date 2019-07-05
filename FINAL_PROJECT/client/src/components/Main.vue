<template>
  <div class="page">
    <PageHeader></PageHeader>
    <div class="container-fluid">
      <div class="row ">
        <div class="col-md-3  hidden-xs">
        </div>
        <div class="col-md-9 col-xs-12">
        </div>
      </div>
    </div>
    <div class="container-fluid text-center">
    </div>
  </div>

</template>


<script>
  import PageHeader from './Header'

  export default {
    data() {
      return {
        bpages: null,
      }
    },
    components: {
      PageHeader,
    },
    async mounted() {
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .page {

  }
</style>
