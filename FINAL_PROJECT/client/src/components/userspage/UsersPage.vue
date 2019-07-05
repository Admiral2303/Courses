<template>
  <div class="page">
    <PageHeader></PageHeader>
    <div class="container-fluid">
      <div class="row ">
        <div class="col-md-3  hidden-xs">
        </div>
        <div class="col-md-9 col-xs-12">
          <users-list/>
        </div>
      </div>
    </div>
    <div class="container-fluid text-center">
    </div>
  </div>

</template>


<script>
  import PageHeader from '../Header'
  import UsersList from './UsersList'
  import UsersService from '@/services/UsersService'

  export default {
    data() {
      return {
        bpages: null,
      }
    },
    components: {
      PageHeader,
      UsersList,
    },
    async mounted() {
      try {
        let response = await UsersService.users();
        console.log(response)
        this.$store.dispatch('setUsers', {});
        this.$store.dispatch('setUsers', response.data.users);
      } catch (err) {
        console.log(err)
      }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .page {

  }
</style>
