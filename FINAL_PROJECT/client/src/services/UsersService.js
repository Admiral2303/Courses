import Api from '@/services/Api'

export default {
  users() {
    return Api().get('/users');
  }
}
