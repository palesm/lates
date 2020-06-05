<template>
    <div>
        <h1>Add late event</h1>
        <div id="addDiv">
            <form  @submit.prevent="createLate">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input id="name" type="text" class="form-control" v-model="late.name" placeholder="Name">
                </div>
                <div class="form-group">
                    <label>Minutes</label>
                    <input type="number" class="form-control" v-model="late.minutes" min="0" placeholder="Minutes">
                </div>
                <div class="form-group">
                    <label>Date</label>
                    <input type="date" class="form-control" v-model="late.date" placeholder="Date">
                </div>
                <div id="btnDiv">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</template>


<script>
export default {
    name: 'late-form',
    data() {
        return {
            late: {
                name: '',
                minutes: null,
                date: null,
            },
        }
    },
    methods: {
        createLate() {
            this.$store.dispatch("create", { name: this.late.name, minutes: this.late.minutes, date: this.late.date })
                .catch(error => {
                    console.log(error)
                })
        },
    }
}
</script>

<style scoped>
    #addDiv {
        margin-top: 20px;
        text-align: start;
        margin-left: 30%;
        margin-right: 30%;
    }
    #btnDiv {
        text-align: center;
        margin: 10px
    }

</style>