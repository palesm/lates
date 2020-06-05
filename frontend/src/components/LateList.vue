<template>
    <div id="tableDiv" >
        <table class="table">
            <thead>
            <th v-for="header in tableHeader">{{header}}</th>
            </thead>
            <tbody>
            <tr v-for="late in lates">
                <td>{{ late.name }}</td>
                <td>{{ late.minutes }}</td>
                <td>{{ late.date }}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "LateList",
        data () {
            return {
                late: {
                    name: '',
                    minutes: null,
                    date: null,
                },
                tableHeader:['Name', 'Minutes', 'Date'],
            }
        },
        computed: {
            lates () {
                return this.$store.getters.lateList
            }
        },
        created() {
            this.$store.dispatch("getLateList")
        }

    }
</script>

<style scoped>
    #tableDiv {
        margin-top:  20px;
        margin-left: 20%;
        margin-right: 20%;
    }
</style>