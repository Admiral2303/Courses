<template>

  <div>
    <login/>
    <register/>
    <nav class="navbar navbar-inverse bg-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <!-- <a href="/" class="navbar-brand">BookA</a> -->
        </div>
        <ul v-if="$store.state.isUserLoggedIn" class="nav navbar-nav hidden-sm hidden-xs">
          <li><a href="/#/users">Users</a></li>
        </ul>
        <ul v-else class="nav navbar-nav navbar-right">
          <li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user"></span> Sign
            in</a></li>
          <li><a href="#" data-toggle="modal" data-target="#myModal1"><span class="glyphicon glyphicon-log-in"></span>
            Sign up</a></li>
        </ul>
        <ul v-if="$store.state.isUserLoggedIn" class="nav navbar-nav navbar-right">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle profile-image" data-toggle="dropdown" aria-expanded="false">
              <span></span>
              <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
              <!-- <li><a href="/books?page=1" class="visible-sm visible-xs">Users</a></li> -->
              <li role="separator" class="divider"></li>
              <li><a @click="logout"><span class="glyphicon glyphicon-log-out"></span> Sign out</a></li>
              <li><a href="/help"><span class="glyphicon glyphicon-info-sign"></span> Help</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
  import AuthenticationService from '@/services/AuthenticationService'
  import Login from './Login'
  import Register from './Register'

  export default {
    data() {
      return {}
    },
    components: {
      Login,
      Register
    },
    methods: {
      logout() {
        this.$store.dispatch('setToken', null)
        this.$store.dispatch('setUser', null)
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
