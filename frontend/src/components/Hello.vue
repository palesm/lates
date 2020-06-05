<template>
  <div class="hello">
    <img src="./../assets/spring-boot-vuejs-logo.png">
    <h1>This is my Vue.js & Spring Boot app</h1>
    <h3>Here you can add new late event and check out the statistics</h3>
    <ul>
        <li>Add or view all late events:</li>
        <li><router-link to="/lates">/lates</router-link></li>
        <br/>
        <li>Statistics:</li>
        <li><router-link to="/stats">/stats</router-link></li>

    </ul>
  </div>
</template>

<script>
export default {
  name: 'hello',
  props: { hellomsg: { type: String, required: true } }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
