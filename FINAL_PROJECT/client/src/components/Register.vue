<template>
  <div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4 class="modal-title" id="myModalLabel">Register</h4>
          <h4 style="color: red">{{error}}</h4>
          <h4 style="color: green">{{submit}}</h4>
        </div>
        <div class="modal-body">
          <div class="panel panel-primary">
            <div class="panel-heading"></div>
            <div class="panel-body">
              <form v-on:submit.prevent="validateBeforeSubmit">
                <div class="form-group">
                  <label class="control-label" for="name">Name</label>
                  <span class="form-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                  <input class="form-control" v-model="firstName" data-error="Enter name" id="name" name="firstname"
                         v-validate='required' data-vv-delay="500"
                         :class="{'input': true, 'is-danger': errors.has('name') }" type="text" placeholder="Name"
                         required/>
                  <i v-show="errors.has('name')" class="fa fa-warning"></i>
                  <span v-show="errors.has('name')" class="help is-danger">Name is incorect</span>
                </div>
                <div class="form-group">
                  <label class="control-label" for="surname">Surname</label>
                  <span class="form-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                  <input class="form-control" v-model="lastName" data-error="Enter password" id="surname"
                         name="lastName" v-validate='required' type="text" placeholder="Surname" required/>
                  <i v-show="errors.has('surname')" class="fa fa-warning"></i>
                  <span v-show="errors.has('surname')" class="help is-danger">Surname is incorect</span>
                </div>
                <div class="form-group">
                  <label class="control-label">Username</label>
                  <span class="form-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                  <input class="form-control" name="username" v-model="username" data-vv-delay="1000"
                         :class="{'input': true }" type="text" placeholder="username" required>
                  <i v-show="errors.has('email')" class="fa fa-warning"></i>
                  <span v-show="errors.has('email')" class="help is-danger">Email is incorect</span>
                </div>
                <div class="form-group">
                  <label for="password" class="control-label">Password</label>
                  <span class="form-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                  <input type="password" v-model="password" v-validate="'required'" id="password" name="password"
                         data-minlength="5" class="form-control" data-error="Пароль має містити мінімум 5 символів"
                         placeholder="Pasword" required>
                </div>
                <div class="form-group">
                  <label for="password2" class="control-label">Password</label>
                  <span class="form-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                  <input type="password" v-validate="'confirmed:password'"
                         :class="{'input': true, 'is-danger': errors.has('password') }" id="password2" name="password2"
                         data-minlength="5" class="form-control" data-error="Password don`t matches"
                         placeholder="Password" required>
                  <div class="alert alert-danger" v-show="errors.any()">
                    <div v-if="errors.has('password')">
                      Enter password
                    </div>
                    <div v-if="errors.has('password2')">
                      Password is incorect
                    </div>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                  <button type="submit" class="btn btn-warning">Register <span class="glyphicon glyphicon-send"></span>
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import AuthenticationService from '@/services/AuthenticationService'

  export default {
    name: 'register',
    data() {
      return {
        firstName: "",
        lastName: "",
        username: "",
        password: "",
        error: "",
        submit: ""
      }
    },
    methods: {
      validateBeforeSubmit(e) {
        this.$validator.validateAll();
        if (!this.errors.any()) {
          this.formSubmit()
        } else {
          this.error('Data is incorect');
        }
      },
      async formSubmit() {
        try {
          const responce = await AuthenticationService.register({
            firstName: this.firstName,
            lastName: this.lastName,
            username: this.username,
            password: this.password
          });
          this.submit = "Ok";
          this.error = "";
        } catch (err) {
          this.error = 'Incorect username';
        }
      }
    }

  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

  /* .invalid .multiselect__tags {
    border-color: red;
  } */
  .textarea.is-danger {
    border-color: #ff3860;
  }

  .is-danger {
    color: red;
  }

  /* .help.is-danger {
          color: #ff3860;
  } */
</style>
