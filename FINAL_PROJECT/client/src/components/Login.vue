<template>
  <div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <h4 class="modal-title" id="myModalLabel">Sign in</h4>
          </div>
          <div class="modal-body">
            <form role="form" class="form-horizontal">
              <div class="form-group has-feedback">
                <label class="control-label col-xs-3">Логин:</label>
                <div class="col-xs-6">
                  <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input label="Login" v-model="login" type="text" class="form-control" required="required">
                  </div>
                  <span class="glyphicon form-control-feedback"></span>
                </div>
              </div>
              <div class="form-group has-feedback">
                <label class="control-label col-xs-3">Пароль:</label>
                <div class="col-xs-6">
                  <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                    <input type="password" v-model="password" class="form-control" required="required">
                  </div>
                  <span class="glyphicon form-control-feedback"></span>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                <button id="save" @click="signin" class="btn btn-primary" data-dismiss="modal">Увійти</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import AuthenticationService from '@/services/AuthenticationService'

  export default {
    name: 'login',
    data() {
      return {
        login: 'test1',
        password: 'test1',
        error: null
      }
    },

    methods: {
      async signin() {
        try {
          const responce = await AuthenticationService.login({
            username: this.login,
            password: this.password
          })
          console.log(responce.data);
          this.$store.dispatch('setToken', responce.data)
          // this.$store.dispatch('setUser', responce.data.user)
        } catch (error) {
          this.error = error.response.data.error
          console.log(error);
        }
      },
      logout() {
        this.$store.dispatch('setToken', null)
        this.$store.dispatch('setUser', null)
      }
    }

  }
</script>

<style scoped>

</style>
