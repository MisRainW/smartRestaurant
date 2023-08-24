
//员工登录
function loginApi(data) {
  return $axios({
    'url': '/employee/login',
    'method': 'post',
    data
  })
}

//员工退出
function logoutApi(){
  return $axios({
    'url': '/employee/logout',
    'method': 'post',
  })
}
