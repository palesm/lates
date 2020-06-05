<!--<template>-->
<!--  <div>-->
<!--    <h1>Add late event</h1>-->
<!--    <div id="addDiv">-->
<!--      <form  @submit.prevent="createLate">-->
<!--        <div class="form-group">-->
<!--          <label for="name">Name</label>-->
<!--          <input id="name" type="text" class="form-control" v-model="late.name" placeholder="Name">-->
<!--        </div>-->
<!--        <div class="form-group">-->
<!--          <label>Minutes</label>-->
<!--          <input type="number" class="form-control" v-model="late.minutes" min="0" placeholder="Minutes">-->
<!--        </div>-->
<!--        <div class="form-group">-->
<!--          <label>Date</label>-->
<!--          <input type="date" class="form-control" v-model="late.date" placeholder="Date">-->
<!--        </div>-->
<!--        <div id="btnDiv">-->
<!--          <button type="submit" class="btn btn-primary">Submit</button>-->
<!--        </div>-->
<!--      </form>-->
<!--    </div>-->
<!--      <button id="btnAdd" @click.prevent="getLates()" type="submit" class="btn btn-primary">Show all late events</button>-->
<!--      <button id="btnDel" @click.prevent="deleteLates()" type="submit" class="btn btn-primary">Clear all late events</button>-->
<!--      <button id="btnGen" @click.prevent="generateLates()" type="submit" class="btn btn-primary">Generate some late events</button>-->
<!--    <div v-if="showLates" id="tableDiv" >-->
<!--      <table class="table" :key="tableKey">-->
<!--        <thead>-->
<!--        <th v-for="header in tableHeader">{{header}}</th>-->
<!--        </thead>-->
<!--        <tbody>-->
<!--          <tr  v-for="late in lates">-->
<!--            <td>{{ late.name }}</td>-->
<!--            <td>{{ late.minutes }}</td>-->
<!--            <td>{{ late.date }}</td>-->
<!--          </tr>-->
<!--        </tbody>-->
<!--      </table>-->
<!--    </div>-->

<!--  </div>-->
<!--</template>-->

<script>import api from "./backend-api";
export default {
  name: 'add-late',

  data () {
    return {
      response: [],
      errors: [],
      // late: {
      //   name: '',
      //   minutes: null,
      //   date: null,
      // },
      tableHeader:['Name', 'Minutes', 'Date'],
      showLates: false,
      tableKey: 0
    }
  },
  computed: {
    lates() {
      return this.$store.getters.lateList;
    },
  },
  getters: {
    lates: (state, getters) => {
      return getters.lateList;
    }
  },
  methods: {
    getLates() {
     api.getLates().then(
             response => {
               this.lates = response.data;
               this.showLates = true;
             }
     )
             .catch(error => console.log(error)
     )
    },
    deleteLates() {
      this.$store.dispatch("delete");
      api.deleteLates();
      this.tableKey += 1;
      console.log(this.tableKey)
    },
    generateLates() {
      api.generateLates()
    }
  }
}
</script>
<style scoped>
  /*#addDiv {*/
  /*  margin-top: 20px;*/
  /*  text-align: start;*/
  /*  margin-left: 30%;*/
  /*  margin-right: 30%;*/
  /*}*/
  /*#btnDiv {*/
  /*  text-align: center;*/
  /*  margin: 10px*/
  /*}*/
  #tableDiv {
    margin-top:  20px;
    margin-left: 20%;
    margin-right: 20%;
  }
  #btnAdd {
    margin: 10px;
  }
  #btnDel {
    margin: 10px;
  }
  #btnGen {
    margin: 10px;
  }

</style>